package vafa.mona.com.service

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class MyFirstService : Service() {



    var Tag: String = "MyFirstService"
  private val myBinder = MyBinder()

  override fun onBind(intent: Intent): IBinder? {
        Log.i(Tag, "onBind")
        return myBinder
    }
    fun getResult(Counter: Int): Int {
        return Counter * 10
    }
    inner class MyBinder : Binder() {
        fun getService() : MyFirstService {
            return this@MyFirstService
        }
    }

    override fun onDestroy() {
        Log.i(Tag, "onDestroy")
        super.onDestroy()


    }
}
