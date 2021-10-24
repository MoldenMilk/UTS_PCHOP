package com.example.pchop.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.pchop.Model.User;
import com.example.pchop.DAO.UserDao;

@Database(entities = {User.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract UserDao userDao();
}
