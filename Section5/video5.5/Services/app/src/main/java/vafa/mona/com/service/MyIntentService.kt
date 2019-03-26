package vafa.mona.com.service

import android.app.IntentService
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
    var Tag: String = "MyFirstService"

    override fun onHandleIntent(intent: Intent?) {
        Log.i(Tag, "onHandleIntent")
        try {
            Thread.sleep(10000)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.i(Tag, "onBind")
        return null
    }

    override fun onCreate() {
        Log.i(Tag, "onCreate")
        super.onCreate()

    }

    override fun onDestroy() {
        Log.i(Tag, "onDestroy")

        super.onDestroy()
    }
}
