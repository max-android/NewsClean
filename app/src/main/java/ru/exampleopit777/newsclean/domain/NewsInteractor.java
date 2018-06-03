package ru.exampleopit777.newsclean.domain;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.exampleopit777.newsclean.data.database.entity.NewsDB;
import ru.exampleopit777.newsclean.data.entities.Rss;
import ru.exampleopit777.newsclean.data.mapper.ItemMapperDB;
import ru.exampleopit777.newsclean.data.repository.ApiRepository;
import ru.exampleopit777.newsclean.data.repository.DataBaseRepository;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
public class NewsInteractor {

    @Inject
    ApiRepository apiRepository;
    @Inject
    DataBaseRepository dataBaseRepository;

    public NewsInteractor(ApiRepository apiRepository,
                          DataBaseRepository dataBaseRepository) {
        this.apiRepository = apiRepository;
        this.dataBaseRepository = dataBaseRepository;
    }

    public Single<Rss> netNews() {
        Single<Rss> single = apiRepository.news()
                .doOnSuccess(rss -> {

                    if (!dataBaseRepository.newsDAO().getList().isEmpty()) {
                        dataBaseRepository.newsDAO().deleteNews();
                    }
                    dataBaseRepository.newsDAO()
                            .insertNews(ItemMapperDB.transform(rss.getChannel().getItem()));
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        return single;
    }

    public Single<List<NewsDB>> dbNews() {
        Single<List<NewsDB>> single = dataBaseRepository.newsDAO().getNews()
                .doOnSuccess(list -> {
                    Log.d("SIZE_DB", String.valueOf(dataBaseRepository.newsDAO().getList().size()));
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        return single;
    }
}




