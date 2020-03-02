package com.example.myapplication;

import android.content.Context;

import androidx.room.Room;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.myapplication.dao.TaskDao;
import com.example.myapplication.db.AppDatabase;
import com.example.myapplication.entity.Task;
import com.example.myapplication.entity.TaskStatus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4ClassRunner.class)
public class TestAppDatabase {
    private TaskDao taskDao;
    private AppDatabase db;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        db = Room
                .inMemoryDatabaseBuilder(context, AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        taskDao = db.taskDao();
    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void writeAndRead() {
        assertEquals(0, taskDao.getNumberOfTasks());

        Task task = new Task();
        task.setCreatedAt(LocalDateTime.now());
        task.setDeadLine(LocalDateTime.now().plusDays(2));
        task.setFinishedAt(null);
        task.setTaskStatus(TaskStatus.NOT_COMPLETED);
        task.setName("name");
        task.setCategory("category");

        taskDao.insert(task);
        assertEquals(1, taskDao.getNumberOfTasks());
    }
}
