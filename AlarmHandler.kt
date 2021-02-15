package com.amirhusseinsoori.AlarmHandler

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.amirhusseinsoori.broadcastreceiver

class AlarmHandler(var _Context: Context) {


    @SuppressLint("ShortAlarm")
    fun setAlarmManger() {


        val intent = Intent(_Context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(_Context, 0, intent, 0)
        val am = _Context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //repeat  task in 5 minutes
        am.setRepeating(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            10 * 100,
            1000 * 60 * 5,
            pendingIntent
        )
    }

    fun cancelAlarmManger() {
        val intent = Intent(_Context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(_Context, 2, intent, 0)
        val am = _Context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.cancel(pendingIntent)
    }


}