package ru.exampleopit777.newsclean.di.app;


import javax.inject.Singleton;

import dagger.Component;
import ru.exampleopit777.newsclean.di.modules.ApiRepositoryModule;
import ru.exampleopit777.newsclean.di.modules.CiceroneModule;
import ru.exampleopit777.newsclean.di.modules.DataBaseRepositoryModule;
import ru.exampleopit777.newsclean.di.modules.DatabaseModule;
import ru.exampleopit777.newsclean.di.modules.GlideModule;
import ru.exampleopit777.newsclean.di.modules.NetInspectorModule;
import ru.exampleopit777.newsclean.di.modules.NewsInteractorModule;
import ru.exampleopit777.newsclean.di.modules.NewsServiceModule;
import ru.exampleopit777.newsclean.di.modules.ResourceModule;
import ru.exampleopit777.newsclean.presentation.presenter.news.DetailNewsPresenter;
import ru.exampleopit777.newsclean.presentation.presenter.news.NewsPresenter;
import ru.exampleopit777.newsclean.presentation.ui.base.BaseActivity;
import ru.exampleopit777.newsclean.presentation.ui.primary.DetailFragment;
import ru.exampleopit777.newsclean.presentation.ui.primary.MainActivity;
import ru.exampleopit777.newsclean.presentation.ui.primary.NewsFragment;


@Singleton
@Component(modules = {
        NewsServiceModule.class,
        GlideModule.class,
        DatabaseModule.class,
        NetInspectorModule.class,
        ResourceModule.class,
        ApiRepositoryModule.class,
        DataBaseRepositoryModule.class,
        NewsInteractorModule.class,
        // NewsPresenterModule.class,
        //DetailNewsPresenterModule.class,
        CiceroneModule.class
})

public interface AppComponent {
    void injectBaseActivity(BaseActivity baseActivity);

    void injectMainActivity(MainActivity mainActivity);

    void injectNewsFragment(NewsFragment newsFragment);

    void injectDetailFragment(DetailFragment detailFragment);

    void injectNewsPresenter(NewsPresenter newsPresenter);

    void injectDetailNewsPresenter(DetailNewsPresenter detailNewsPresenter);
}
