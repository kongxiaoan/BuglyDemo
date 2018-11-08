package com.kpa.buglydemo.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * author: mr.kong
 * Date:2018/11/8
 * description:
 * project name:BuglyDemo
 **/
@Entity
public class User {
    @PrimaryKey
    private int id;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
}
