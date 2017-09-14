package com.nepalicoders.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager

/**
 * Created by Sulav on 9/11/17.
 */
class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if (intent != null) {
            with(intent) {
                val a = getIntExtra("a", 0)
                val b = getIntExtra("b", 0)

                val sum = a + b

                val localBroadcastManager = LocalBroadcastManager.getInstance(context)

                val returningIntent = Intent("my.result.intent")
                returningIntent.putExtra("sum", sum)

                localBroadcastManager.sendBroadcast(returningIntent)
            }
        }
    }

}
