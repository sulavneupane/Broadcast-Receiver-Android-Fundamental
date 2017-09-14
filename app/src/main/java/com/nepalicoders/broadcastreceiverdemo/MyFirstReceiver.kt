package com.nepalicoders.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/**
 * Created by Sulav on 9/10/17.
 */
class MyFirstReceiver : BroadcastReceiver() {

    private val TAG = MyFirstReceiver::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent?) {

//        if (isOrderedBroadcast) {
//            val initCode = resultCode
//            val initData = resultData
//            val initBundle = getResultExtras(true)
//            val title = initBundle.getString("title")
//
//            Log.i(TAG, "Code: $initCode, Data: $initData, Bundle: $title")
//
//            Log.i(TAG, "Hello from 1st Receiver")
//            Toast.makeText(context, "Hello from 1st Receiver", Toast.LENGTH_SHORT).show()
//
//            initBundle.putString("title", "LazyDeveloper")
//            setResult(83, "Windows", initBundle)
//
//        } else {
////            val name = intent?.getStringExtra("name")
////            val age = intent?.getIntExtra("age", 0)
////            Log.i(TAG, "Name: $name, Age: $age")
//
//            Log.i(TAG, "Hello from 1st Receiver, Thread Name: ${Thread.currentThread().name}")
//            Toast.makeText(context, "Hello from 1st Receiver", Toast.LENGTH_SHORT).show()
//        }


        Log.i(TAG, "Hello from 1st Receiver")
        Toast.makeText(context, "Hello from 1st Receiver", Toast.LENGTH_SHORT).show()

    }

}