package vafa.mona.com.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var Tag: String = "MyFirstService"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun startService(view: View) {
        val intent = Intent(this
            , MyAIDLService::class.java)
        intent.action = IMyAidlInterface::class.java.name
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)

    }
    var MyAidlInterface : IMyAidlInterface? = null

    val mConnection = object : ServiceConnection {

        // Called when the connection with the service is established
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            MyAidlInterface = IMyAidlInterface.Stub.asInterface(service)
        }

        // Called when the connection with the service disconnects unexpectedly
        override fun onServiceDisconnected(className: ComponentName) {
            Log.e(Tag, "Service has unexpectedly disconnected")
            MyAidlInterface = null
        }
    }

}
