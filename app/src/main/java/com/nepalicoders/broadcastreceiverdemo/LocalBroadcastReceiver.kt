package com.nepalicoders.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_local_broadcast_receiver.*

class LocalBroadcastReceiver : AppCompatActivity() {

    private val TAG = LocalBroadcastReceiver::class.java

    private var mLocalBRManager: LocalBroadcastManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_broadcast_receiver)

        mLocalBRManager = LocalBroadcastManager.getInstance(this)

        btnSendBroadcast.setOnClickListener { view -> sendNormalBroadcast(view) }
    }

    fun sendNormalBroadcast(view: View) {

        val intent = Intent(this, MyReceiver::class.java)

        intent.putExtra("a", 10)
        intent.putExtra("b", 20)

        sendBroadcast(intent)

    }

    override fun onResume() {
        super.onResume()

        val intentFilter = IntentFilter("my.result.intent")
        mLocalBRManager?.registerReceiver(resultReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()

        mLocalBRManager?.unregisterReceiver(resultReceiver)
    }

    private val resultReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            val sum = intent?.getIntExtra("sum", 0)
            Toast.makeText(context, "Sum is $sum", Toast.LENGTH_SHORT).show()

        }

    }

}
