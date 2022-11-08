package com.example.itarch

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.os.HandlerCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG = "MainActivity"

    var mBound = false
    private val mAidlConnection = AidlConnection()
    private var mServiceAidl: IMyAidlInterface? = null
    private var imageView: ImageView? = null
    private var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener(this)
        findViewById<EditText>(R.id.edit_text)
        imageView = findViewById<ImageView>(R.id.result)
    }

    override fun onClick(view: View) {
        val _mServiceAidl = mServiceAidl
        if(edit_text.text != null) {
            var ret = ""
            try {
                val str = edit_text.text.toString()
                ret = _mServiceAidl!!.getURL(str)
                downloadImage(ret)
            } catch (e: RemoteException){
                e.printStackTrace()
            }
        } else {
            
        }
    }

    override fun onStart() {
        super.onStart()
        val intentAidl = Intent().setComponent(ComponentName("com.example.itarch", "com.example.itarch.MyService"))
        val bindAidl = bindService(Intent(this, MyService::class.java), AidlConnection(), Context.BIND_AUTO_CREATE)
        Log.d(TAG, "Bind Aidl Connection "+ bindAidl)
    }

    private inner class AidlConnection : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            mServiceAidl = IMyAidlInterface.Stub.asInterface(service)
            mBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mServiceAidl = null
            mBound = false
        }
    }

    private fun downloadImage(urlSt: String) {
        // Singleの別スレッドを立ち上げる
        Executors.newSingleThreadExecutor().execute {
            try {
                val url = URL(urlSt)
                val urlCon: HttpURLConnection = url.openConnection() as HttpURLConnection

                // タイムアウト設定
                urlCon.setReadTimeout(10000)
                urlCon.setConnectTimeout(20000)

                // リクエストメソッド
                urlCon.setRequestMethod("GET")



                // リダイレクトを自動で許可しない設定
                urlCon.setInstanceFollowRedirects(false)
                val `is`: InputStream = urlCon.getInputStream()
                val bmp = BitmapFactory.decodeStream(`is`)

                // 別スレッド内での処理を管理し実行する
                HandlerCompat.createAsync(mainLooper).post { // Mainスレッドに渡す
                    imageView!!.setImageBitmap(bmp)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
