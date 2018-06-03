package ru.exampleopit777.newsclean.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.exampleopit777.newsclean.data.system.ResourceManager;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
@Module
@Singleton
public class ResourceModule {

    private Context context;

    public ResourceModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public ResourceManager provideResourceManager() {
        return new ResourceManager(context);
    }
}

