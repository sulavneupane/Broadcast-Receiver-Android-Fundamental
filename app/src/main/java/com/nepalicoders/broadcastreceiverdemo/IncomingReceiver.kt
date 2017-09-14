package com.nepalicoders.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast

/**
 * Created by Sulav on 9/11/17.
 */
class IncomingReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val state = intent?.getStringExtra(TelephonyManager.EXTRA_STATE)

        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            Toast.makeText(context, "Ringing State", Toast.LENGTH_SHORT).show()
        }

        if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            Toast.makeText(context, "Received State", Toast.LENGTH_SHORT).show()
        }

        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            Toast.makeText(context, "Idle State", Toast.LENGTH_SHORT).show()
        }

    }

}