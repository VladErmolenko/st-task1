package com.example.st_task1

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

var restore_counter = 0
val castbroad = Receiver()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        restore_counter++
        Log.w("ACTIVITY", "Activity has been restored $restore_counter times ")
        startService(
            Intent(this@MainActivity, Factorial::class.java).putExtra(
                "Counter",
                restore_counter
            )
        )
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(castbroad, IntentFilter("GET_FACTORIAL"))
    }

    override fun onStop() {
        unregisterReceiver(castbroad)
        super.onStop()
    }

}