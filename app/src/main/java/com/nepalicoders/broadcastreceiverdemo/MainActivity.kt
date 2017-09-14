package com.nepalicoders.broadcastreceiverdemo

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private var myFirstReceiver: MyFirstReceiver? = null
    private var ctr = 1

    private val timeTickReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

            val minutes = ctr
            placeholderText.text = "$minutes minute over"
            ctr++

            Toast.makeText(context, "Hello from Time Tick Receiver", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myFirstReceiver = MyFirstReceiver()


        btnRegisterTimer.setOnClickListener { view -> registerReceiver(view) }
        btnUnregisterTimer.setOnClickListener { view -> unregisterReceiver(view) }

//        btnSendBroadcastMessage.setOnClickListener { view -> sendBroadcastMessage(view) }
//        btnSendInnerBroadcastMessage.setOnClickListener { view -> broadcastToInnerReceiver(view) }
    }

    private fun registerReceiver(view: View?) {
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        registerReceiver(timeTickReceiver, intentFilter)
    }

    private fun unregisterReceiver(view: View?) {
        unregisterReceiver(timeTickReceiver)
    }

//    private fun broadcastToInnerReceiver(view: View?) {
//
////        val intent = Intent(this, MyThirdReceiverInner::class.java)
//        val intent = Intent("my.custom.anotheraction.name")
//
////        val bundle = Bundle()
////        bundle.putString("name", "Sulav Neupane")
////        bundle.putInt("age", 10)
////        intent.putExtras(bundle)
//
//        sendBroadcast(intent)
//
//    }
//
//    private fun sendBroadcastMessage(view: View?) {
//
////        val intent = Intent(this, MyFirstReceiver::class.java)
//        val intent = Intent("my.custom.action.name")
//
////        intent.putExtra("name", "Sulav Neupane")
////        intent.putExtra("age", 10)
////        sendBroadcast(intent)
//
////        sendOrderedBroadcast(intent, null)
//
//        val b = Bundle()
//        b.putString("title", "SmartDeveloper")
//
//        sendOrderedBroadcast(intent, null, MyFourthReceiver(), null, Activity.RESULT_OK, "Android", b)
//
//        Log.i(TAG, "After Seding Broadcast")
//
//    }
//
//    class MyThirdReceiverInner : BroadcastReceiver() {
//
//        private val TAG = MyThirdReceiverInner::class.java.simpleName
//
//        override fun onReceive(context: Context?, intent: Intent?) {
//
//            if (isOrderedBroadcast) {
//                val initCode = resultCode
//                val initData = resultData
//                val initBundle = getResultExtras(true)
//                val title = initBundle.getString("title")
//
//                Log.i(TAG, "Code: $initCode, Data: $initData, Bundle: $title")
//
//                Log.i(TAG, "Hello from 3rd Receiver")
//                Toast.makeText(context, "Hello from 3rd Receiver", Toast.LENGTH_SHORT).show()
//
//                resultCode = 17
//                resultData = "iOS"
//
//                initBundle.putString("title", "WiseDeveloper")
//                setResultExtras(initBundle)
//
//            } else {
//
////                val name = intent?.getStringExtra("name")
////                val age = intent?.getIntExtra("age", 0)
////                Log.i(TAG, "Name: $name, Age: $age")
//
//                Log.i(TAG, "Hello from 3rd Receiver")
//                Toast.makeText(context, "Hello from 3rd Receiver", Toast.LENGTH_SHORT).show()
//            }
//
//        }
//
//    }

    override fun onResume() {
        super.onResume()

        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE")
//        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        registerReceiver(myFirstReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()

        unregisterReceiver(myFirstReceiver)
    }

}
