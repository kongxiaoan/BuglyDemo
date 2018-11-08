package com.kpa.buglydemo.room;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * author: mr.kong
 * Date:2018/11/8
 * description:
 * project name:BuglyDemo
 **/
public class RoomDatabaseHelper {
    private static final RoomDatabaseHelper ourInstance = new RoomDatabaseHelper();
    private BuglyDatebase buglyDatebase;


    public static RoomDatabaseHelper getInstance() {
        return ourInstance;
    }

    private RoomDatabaseHelper() {
    }

    public void init(Context applicationContext) {
        if (buglyDatebase == null) {
            buglyDatebase = Room.databaseBuilder(applicationContext, BuglyDatebase.class, "user.db")
                    .allowMainThreadQueries()
                    .build();
        }
    }
}
