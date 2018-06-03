package ru.exampleopit777.newsclean.data.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.exampleopit777.newsclean.data.entities.Rss;
import ru.exampleopit777.newsclean.data.network.NewsService;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
public class ApiRepository {
    @Inject
    NewsService newsService;

    public ApiRepository(NewsService newsService) {
        this.newsService = newsService;
    }

    public Single<Rss> news() {
        return newsService.rss();
    }
}
