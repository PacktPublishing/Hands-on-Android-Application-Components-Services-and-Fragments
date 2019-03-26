package vafa.mona.com.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // var mService: MyFirstService? = null
    var mService: Messenger? = null

    var isBound: Boolean = false
    var Tag: String = "MyFirstService"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, MyMessengerService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)

    }

    fun startService(view: View) {

        if (!isBound) return
        val txt_recieved = edt_main.text.toString()
        val msg = Message.obtain()
        val bundle = Bundle()
        bundle.putString(Tag, txt_recieved)
        msg.data = bundle

        try {
            mService?.send(msg)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(
            className: ComponentName,
            service: IBinder
        ) {
            //  val binder = service as MyFirstService.MyBinder
            //  mService = binder.getService()
            mService = Messenger(service)
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mService = null
            isBound = false
        }
    }

}
