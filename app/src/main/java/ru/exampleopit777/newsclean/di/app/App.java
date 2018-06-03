package ru.exampleopit777.newsclean.di.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import ru.exampleopit777.newsclean.di.modules.ApiRepositoryModule;
import ru.exampleopit777.newsclean.di.modules.CiceroneModule;
import ru.exampleopit777.newsclean.di.modules.DataBaseRepositoryModule;
import ru.exampleopit777.newsclean.di.modules.DatabaseModule;
import ru.exampleopit777.newsclean.di.modules.GlideModule;
import ru.exampleopit777.newsclean.di.modules.NetInspectorModule;
import ru.exampleopit777.newsclean.di.modules.NewsInteractorModule;
import ru.exampleopit777.newsclean.di.modules.NewsServiceModule;
import ru.exampleopit777.newsclean.di.modules.ResourceModule;


public class App extends Application {


    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .newsServiceModule(new NewsServiceModule())
                .glideModule(new GlideModule(this))
                .databaseModule(new DatabaseModule(this))
                .netInspectorModule(new NetInspectorModule(this))
                .resourceModule(new ResourceModule(this))
                .ciceroneModule(new CiceroneModule())
                .apiRepositoryModule(new ApiRepositoryModule())
                .dataBaseRepositoryModule(new DataBaseRepositoryModule())
                .newsInteractorModule(new NewsInteractorModule())
                // .newsPresenterModule(new NewsPresenterModule())
                //.detailNewsPresenterModule(new DetailNewsPresenterModule())
                .build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
