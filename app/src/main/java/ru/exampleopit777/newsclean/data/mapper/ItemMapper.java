package ru.exampleopit777.newsclean.data.mapper;


import java.util.ArrayList;
import java.util.List;

import ru.exampleopit777.newsclean.data.database.entity.NewsDB;
import ru.exampleopit777.newsclean.data.entities.Enclosure;
import ru.exampleopit777.newsclean.data.entities.Item;

/**
 * Created by Максим on 01.06.2018.
 */

public class ItemMapper {

    public static List<Item> transform(List<NewsDB> news) {

        List<Item> newList = new ArrayList<>();

        for (NewsDB newsDB : news) {
            Enclosure enclosure = new Enclosure(newsDB.getUrl());
            newList.add(new Item(newsDB.getTitle(), newsDB.getDate(), enclosure, newsDB.getDescription()));
        }
        return newList;
    }
}
