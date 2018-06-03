package ru.exampleopit777.newsclean.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;
import ru.exampleopit777.newsclean.data.database.entity.NewsDB;

/**
 * Created by Максим on 01.06.2018
 */

@Dao
public interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   public void insertNews(List<NewsDB> news);

    @Query("DELETE FROM newstable")
    public void deleteNews();

    @Query("SELECT * FROM newstable")
    Single<List<NewsDB>> getNews();

    @Query("SELECT * FROM newstable")
    public List<NewsDB> getList();
}
