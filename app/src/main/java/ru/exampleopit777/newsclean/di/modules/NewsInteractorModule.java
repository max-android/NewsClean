package ru.exampleopit777.newsclean.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.exampleopit777.newsclean.data.repository.ApiRepository;
import ru.exampleopit777.newsclean.data.repository.DataBaseRepository;
import ru.exampleopit777.newsclean.domain.NewsInteractor;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
@Module
@Singleton
public class NewsInteractorModule {

    @Provides
    @Singleton
    public NewsInteractor provideNewsInteractor(@NonNull ApiRepository apiRepository,
                                                @NonNull DataBaseRepository dataBaseRepository) {
        return new NewsInteractor(apiRepository, dataBaseRepository);
    }
}
