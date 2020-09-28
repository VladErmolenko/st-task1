package com.example.st_task1

import android.app.Service
import android.content.Intent
import android.os.IBinder

class Factorial : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var result = 1
        val counter = intent!!.getIntExtra("Counter", 1)
        result=fuctorial(counter)
        sendBroadcast(result)
        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun fuctorial(counter: Int):Int {
        var res = 1
         for (i in 1..counter)
            res *= i
        return res

    }

    private fun sendBroadcast(res: Int) {
        val intent = Intent()
        intent.action = "GET_FACTORIAL"
        intent.putExtra("result", res)
        sendBroadcast(intent)

    }

}