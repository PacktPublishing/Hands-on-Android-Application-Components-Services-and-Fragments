package vafa.mona.com.service

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun startService(view: View){
        var intent = Intent(this, MyFirstService::class.java)
        startService(intent)
       // stopService(intent)
    }
    fun startIntentService(view: View){
        var intent = Intent(this, MyIntentService::class.java)
        startService(intent)

    }
}
