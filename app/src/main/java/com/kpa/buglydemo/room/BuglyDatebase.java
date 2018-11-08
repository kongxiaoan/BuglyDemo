package com.kpa.buglydemo.room;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

/**
 * author: mr.kong
 * Date:2018/11/8
 * description:
 * project name:BuglyDemo
 **/
public abstract class BuglyDatebase extends RoomDatabase {
    public abstract UserDao userDao();

}
