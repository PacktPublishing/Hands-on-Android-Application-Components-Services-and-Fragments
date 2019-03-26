package vafa.mona.com.service

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log

class MyFirstService : Service() {

    var Tag: String = "MyFirstService"
    private var serviceLooper: Looper? = null
    private var serviceHandler: ServiceHandler? = null

    override fun onBind(intent: Intent): IBinder? {
        Log.i(Tag, "onBind")
        return null
    }

    override fun onCreate() {
        Log.i(Tag, "onCreate")
        super.onCreate()
        HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND).apply {
            start()
            serviceLooper = looper
            serviceHandler = ServiceHandler(looper)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(Tag, "onStartCommand")
        serviceHandler?.obtainMessage()?.also { msg ->
            msg.arg1 = startId
            serviceHandler?.sendMessage(msg)
        }
        return START_STICKY
    }

    override fun onDestroy() {
        Log.i(Tag, "onDestroy")

        super.onDestroy()
    }


    private inner class ServiceHandler(looper: Looper) : Handler(looper) {

        override fun handleMessage(msg: Message) {
            try {
                Thread.sleep(10000)
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
            stopSelf(msg.arg1)
        }
    }

}
