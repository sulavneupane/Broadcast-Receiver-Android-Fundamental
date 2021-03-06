package com.nepalicoders.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/**
 * Created by Sulav on 9/10/17.
 */
class MyFourthReceiver : BroadcastReceiver() {

    private val TAG = MyFourthReceiver::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent?) {

        if (isOrderedBroadcast) {
            val initCode = resultCode
            val initData = resultData
            val initBundle = getResultExtras(true)
            val title = initBundle.getString("title")

            Log.i(TAG, "Code: $initCode, Data: $initData, Bundle: $title")

            Log.i(TAG, "Hello from 4th Receiver")
            Toast.makeText(context, "Hello from 4th Receiver", Toast.LENGTH_SHORT).show()

        }

    }

}