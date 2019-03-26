package vafa.mona.com.myapplication

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun startService(view: View) {
        var intent = Intent(this, MyForegroundService::class.java)
        startService(intent)
    }

}
