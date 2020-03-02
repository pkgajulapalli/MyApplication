package com.example.myapplication.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.entity.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    public void insert(Task task);

    @Update
    public void update(Task task);

    @Delete
    public void clear(Task task);

    @Query("select * from Task where name like :searchString or description like :searchString")
    public List<Task> search(String searchString);

    @Query("select count(*) from Task")
    public int getNumberOfTasks();
}
