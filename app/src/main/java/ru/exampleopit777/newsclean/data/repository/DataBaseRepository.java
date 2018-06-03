package ru.exampleopit777.newsclean.data.repository;

import javax.inject.Inject;

import ru.exampleopit777.newsclean.data.database.AppBase;
import ru.exampleopit777.newsclean.data.database.NewsDAO;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
public class DataBaseRepository {

    @Inject
    AppBase database;

    public DataBaseRepository(AppBase database) {
        this.database = database;
    }

    public NewsDAO newsDAO() {
        return database.getNewsDAO();
    }
}
