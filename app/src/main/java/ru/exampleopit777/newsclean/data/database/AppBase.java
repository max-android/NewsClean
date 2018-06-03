package ru.exampleopit777.newsclean.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.exampleopit777.newsclean.data.database.entity.NewsDB;


/**
 * Created by Максим on 01.06.2018.
 */


@Database(entities = {NewsDB.class}, version = 1)
public abstract class AppBase extends RoomDatabase {
    public abstract NewsDAO getNewsDAO();
}