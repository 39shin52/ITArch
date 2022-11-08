package com.example.itarch

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException


class MyService : Service() {
    override fun onCreate(){
        super.onCreate()
    }
    override fun onBind(intent : Intent): IBinder {
        return mBinder
    }
    val TAG = "Service"
    val nametourl = mapOf<String, String>(
        "sairahha" to "https://arknights.wikiru.jp/attach2/A5B5A5A4A5E9A5C3A5CF_7361696C656163685F7472696D2E706E67.png",
        "madrock" to "https://arknights.wikiru.jp/attach2/A5DEA5C9A5EDA5C3A5AF_6D7564726F636B5F2E706E67.png",
        "goldengrow" to "https://arknights.wikiru.jp/attach2/A5B4A1BCA5EBA5C7A5F3A5B0A5EDA1BC_476F6C64656E676C6F772E706E67.png",
    )

    private val mBinder = object : IMyAidlInterface.Stub() {
        override fun getURL(operator_name: String): String {
            if (nametourl[operator_name] != null) {
                return nametourl[operator_name]!!
            } else {
                return ""
            }
        }
    }
}
