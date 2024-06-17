package com.comunidadedevspace.taskbeats.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import com.comunidadedevspace.taskbeats.MyTasksApplication
import com.comunidadedevspace.taskbeats.data.TaskDao

class TaskListViewModel(private val taskDao: TaskDao): ViewModel() {

    companion object {

        fun create(application: Application): TaskListViewModel {
            val dataBaseInstance = (application as MyTasksApplication).getAppDataBase()
            val dao = dataBaseInstance.taskDao()
            return TaskListViewModel(dao)
        }
    }

}