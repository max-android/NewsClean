package ru.exampleopit777.newsclean.data.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by Максим on 01.06.2018.
 */

@Entity(tableName = "newstable")
public class NewsDB implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String date;

    private String url;

    private  String description;


    public NewsDB(String title, String date, String url, String description) {
        this.title = title;
        this.date = date;
        this.url = url;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
