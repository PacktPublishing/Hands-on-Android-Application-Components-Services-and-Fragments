package vafa.mona.com.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyFirstService : Service() {

    var Tag : String = "MyFirstService"


    override fun onBind(intent: Intent): IBinder? {
        Log.i(Tag,"onBind" )
        return null
    }

    override fun onCreate() {
        Log.i(Tag,"onCreate" )
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(Tag,"onStartCommand" )

        return START_STICKY
    }

    override fun onDestroy() {
        Log.i(Tag,"onDestroy" )

        super.onDestroy()
    }
}
