package ru.exampleopit777.newsclean.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.exampleopit777.newsclean.data.network.NewsService;
import ru.exampleopit777.newsclean.data.repository.ApiRepository;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */

@Module
@Singleton
public class ApiRepositoryModule {

    @Provides
    @Singleton
    public ApiRepository provideApiRepository(@NonNull NewsService newsService) {
        return new ApiRepository(newsService);
    }
}
