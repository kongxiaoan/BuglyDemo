package com.kpa.buglydemo.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * author: mr.kong
 * Date:2018/11/8
 * description:
 * project name:BuglyDemo
 **/
@Dao
public interface UserDao {
    @Query("SELECT * from user")
    List<User> getAll();

    @Insert
    void insterAll(User... users);

}
