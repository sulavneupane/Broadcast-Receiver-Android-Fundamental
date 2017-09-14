package com.nepalicoders.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sticky_broadcast_deprecated_api21.*

class StickyBroadcastActivityDeprecatedApi21 : AppCompatActivity() {

    private val TAG = StickyBroadcastActivityDeprecatedApi21::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sticky_broadcast_deprecated_api21)

        btnMethod1.setOnClickListener { view -> methodOne(view) }
        btnMethod2.setOnClickListener { view -> methodTwo(view) }
    }

    private fun methodOne(view: View?) {

        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val intent = registerReceiver(null, intentFilter)

        val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        displayBatteryStatus(status)
        Log.i(TAG, status.toString())

    }

    private fun methodTwo(view: View?) {

        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)

        registerReceiver(batteryStatusReceiver, intentFilter)

    }

    private val batteryStatusReceiver = object : BroadcastReceiver() {

        private val TAG = "Main Charger Receiver"

        override fun onReceive(context: Context?, intent: Intent?) {
            val status = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            status?.let { displayBatteryStatus(it) }
            Log.i(TAG, status.toString())
        }

    }

    fun displayBatteryStatus(status: Int) {

        if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            Toast.makeText(this, "Battery Getting Charged", Toast.LENGTH_SHORT).show()
        }

        if (status == BatteryManager.BATTERY_STATUS_DISCHARGING) {
            Toast.makeText(this, "Battery Getting Discharged", Toast.LENGTH_SHORT).show()
        }

        if (status == BatteryManager.BATTERY_STATUS_FULL) {
            Toast.makeText(this, "Battery Fully Charged", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(batteryStatusReceiver)
    }
}
