package ru.exampleopit777.newsclean.data.mapper;


import java.util.ArrayList;
import java.util.List;

import ru.exampleopit777.newsclean.data.common.Constants;
import ru.exampleopit777.newsclean.data.database.entity.NewsDB;
import ru.exampleopit777.newsclean.data.entities.Item;

/**
 * Created by Максим on 01.06.2018.
 */

public class ItemMapperDB {

    public static List<NewsDB> transform(List<Item> items) {

        List<NewsDB> newList = new ArrayList<>();
        for (Item item : items) {
            String url = " ";
            if (item.getEnclosure() == null) {
                url = Constants.IMAGE;
            } else {
                url = item.getEnclosure().getUrl();
            }
            newList.add(new NewsDB(item.getTitle(), item.getPubDate(), url, item.getFulltext()));
        }
        return newList;
    }
}
