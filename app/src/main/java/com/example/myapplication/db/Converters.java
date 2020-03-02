package com.example.myapplication.db;

import androidx.room.TypeConverter;

import com.example.myapplication.entity.TaskStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Converters {

    private static final ZoneOffset ZONE_OFFSET = ZoneOffset.ofHoursMinutes(5, 30);

    @TypeConverter
    public static TaskStatus fromOrdinal(int value) {
        return TaskStatus.values()[value];
    }

    @TypeConverter
    public static int toOrdinal(TaskStatus taskStatus) {
        return taskStatus.ordinal();
    }

    @TypeConverter
    public static LocalDateTime fromTimestamp(Long value) {
        return value == null ? null : LocalDateTime.ofEpochSecond(value, 0, ZONE_OFFSET);
    }

    @TypeConverter
    public static Long dateToTimestamp(LocalDateTime dateTime) {
        return dateTime == null ? null : dateTime.toEpochSecond(ZONE_OFFSET);
    }
}
