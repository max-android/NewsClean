package ru.exampleopit777.newsclean.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.exampleopit777.newsclean.data.common.Constants;
import ru.exampleopit777.newsclean.data.network.NewsService;

/**
 * Created by Максим on 01.06.2018.
 */
@Module
@Singleton
public class NewsServiceModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public NewsService provideNewsService(@NonNull Retrofit retrofit) {
        return retrofit.create(NewsService.class);
    }

}
