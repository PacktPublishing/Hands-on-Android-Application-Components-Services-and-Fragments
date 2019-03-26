


package vafa.mona.com.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Process

class MyAIDLService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
    private val binder = object : IMyAidlInterface.Stub() {

        override fun getProcessId(): Int {
            return Process.myPid()
        }

        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String
        ) {
            // Does nothing
        }
    }
}
