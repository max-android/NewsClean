package ru.exampleopit777.newsclean.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.exampleopit777.newsclean.data.database.AppBase;
import ru.exampleopit777.newsclean.data.repository.DataBaseRepository;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
@Module
@Singleton
public class DataBaseRepositoryModule {

    @Provides
    @Singleton
    public DataBaseRepository provideDBRepository(@NonNull AppBase database) {
        return new DataBaseRepository(database);
    }
}
