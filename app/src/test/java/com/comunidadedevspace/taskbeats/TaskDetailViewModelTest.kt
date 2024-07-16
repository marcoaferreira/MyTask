package com.comunidadedevspace.taskbeats

import com.comunidadedevspace.taskbeats.data.Task
import com.comunidadedevspace.taskbeats.data.TaskDao
import com.comunidadedevspace.taskbeats.presentation.ActionType
import com.comunidadedevspace.taskbeats.presentation.TaskAction
import com.comunidadedevspace.taskbeats.presentation.TaskDetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class TaskDetailViewModelTest {

    private val taskDao: TaskDao = mock()


    private val underTest: TaskDetailViewModel by lazy {
        TaskDetailViewModel(
            taskDao,
            UnconfinedTestDispatcher()
        )
    }

    @Test
    fun update_task() = runTest {
        // given
        val task = Task(
            id = 1,
            title = "title",
            description = "description"
        )

        val taskAction = TaskAction(
            task = task,
            actionType = ActionType.UPDATE.name
        )

        // when
        underTest.execute(taskAction)

        // then
        verify(taskDao).update(task)
    }

    @Test
    fun delete_task() = runTest {
        // given
        val task = Task(
            id = 1,
            title = "title",
            description = "description"
        )

        val taskAction = TaskAction(
            task = task,
            actionType = ActionType.DELETE.name
        )

        // when
        underTest.execute(taskAction)

        // then
        verify(taskDao).deleteById(task.id)
    }

    @Test
    fun create_task() = runTest {
        // given
        val task = Task(
            id = 1,
            title = "title",
            description = "description"
        )

        val taskAction = TaskAction(
            task = task,
            actionType = ActionType.CREATE.name
        )

        // when
        underTest.execute(taskAction)

        // then
        verify(taskDao).insert(task)
    }
}