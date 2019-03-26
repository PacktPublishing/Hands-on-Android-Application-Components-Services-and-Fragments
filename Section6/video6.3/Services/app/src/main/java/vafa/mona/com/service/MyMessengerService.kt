package vafa.mona.com.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import android.widget.Toast


class MyMessengerService : Service() {



    var Tag: String = "MyFirstService"
    private lateinit var mMessenger : Messenger

    override fun onBind(intent: Intent): IBinder? {
        Log.i(Tag, "onBind")
        mMessenger  = Messenger(mMessengerBinder())
        return mMessenger.binder
    }
    override fun onDestroy() {
        Log.i(Tag, "onDestroy")
        super.onDestroy()
    }

     inner class mMessengerBinder : Handler() {

        override fun handleMessage(msg: Message) {

            val data = msg.data
            val dataRecieved = data.getString(Tag)
            Toast.makeText(applicationContext,
                dataRecieved, Toast.LENGTH_SHORT).show()
        }
    }
}
