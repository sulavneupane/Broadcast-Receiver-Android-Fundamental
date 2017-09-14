package com.nepalicoders.broadcastreceiverdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_app_security_with_broadcast_receiver.*

class AppSecurityWithBroadcastReceiver : AppCompatActivity() {

    private val TAG = AppSecurityWithBroadcastReceiver::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_security_with_broadcast_receiver)

        btnSendBroadcast.setOnClickListener { view -> sendBroadcast(view) }
    }

    fun sendBroadcast(view: View) {

        val intent = Intent("my.custom.action.name")
        sendBroadcast(intent, "my.permission")

    }

}
