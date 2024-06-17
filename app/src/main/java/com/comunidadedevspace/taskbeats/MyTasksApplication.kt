package com.comunidadedevspace.taskbeats

import android.app.Application
import androidx.room.Room
import com.comunidadedevspace.taskbeats.data.AppDataBase

class MyTasksApplication: Application() {

    private lateinit var dataBase: AppDataBase
    override fun onCreate() {
        super.onCreate()

        dataBase = Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java, "myTasks-database"
        ).build()
    }

    fun getAppDataBase(): AppDataBase{
        return dataBase
    }
}