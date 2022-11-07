package com.example.itarch

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.os.HandlerCompat
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity"
    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.edit_text)
        imageView = findViewById(R.id.result)
        val downloadButton: Button = findViewById(R.id.button)
        downloadButton.setOnClickListener { v ->
            val stringUrl = editText.text.toString()
            dowloadImage(stringUrl)
            Log.d(TAG, stringUrl)
        }
    }

    private fun dowloadImage(urlSt: String) {
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
