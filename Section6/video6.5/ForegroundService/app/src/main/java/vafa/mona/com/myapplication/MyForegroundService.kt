package vafa.mona.com.myapplication

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.support.annotation.RequiresApi

class MyForegroundService : Service() {
    lateinit var notification: Notification

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel("my_service", "My Background Service")

            } else {
                // If earlier version channel ID is not used
                ""
            }

        showNotification(applicationContext,channelId)

        return Service.START_STICKY
    }
    fun showNotification(context: Context,ChannelId : String){


        val pendingIntent: PendingIntent =
            Intent(this, MainActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(this, 0, notificationIntent, 0)
            }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

             notification = Notification.Builder(this, ChannelId)
                .setContentTitle("the notification Title")
                .setContentText("the notification Messege")
                .setSmallIcon(R.drawable.icon)
                .setContentIntent(pendingIntent)
                .setTicker("Ticker Text")
                .build()
        }else{
            notification = Notification.Builder(this)
                .setContentTitle("the notification Title")
                .setContentText("the notification Messege")
                .setSmallIcon(R.drawable.icon)
                .setContentIntent(pendingIntent)
                .setTicker("Ticker Text")
                .build()
        }
        startForeground(999, notification)

    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String{
        val chan = NotificationChannel(channelId,
            channelName, NotificationManager.IMPORTANCE_NONE)
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return channelId
    }

}
