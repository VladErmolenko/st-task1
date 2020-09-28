package com.example.st_task1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val result= intent?.getIntExtra("result",1).toString()
        Toast.makeText(context,"Factorial: $result",Toast.LENGTH_LONG).show()
    }
}