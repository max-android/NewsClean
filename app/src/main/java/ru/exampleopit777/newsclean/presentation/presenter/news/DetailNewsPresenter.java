package ru.exampleopit777.newsclean.presentation.presenter.news;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.exampleopit777.newsclean.di.app.App;
import ru.exampleopit777.newsclean.presentation.presenter.base.BasePresenter;
import ru.exampleopit777.newsclean.presentation.view.DetailNewsView;
import ru.terrakok.cicerone.Router;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
@InjectViewState
public class DetailNewsPresenter extends BasePresenter<DetailNewsView> {

    @Inject
    Router router;

    public DetailNewsPresenter() {
        App.getAppComponent().injectDetailNewsPresenter(this);
    }

//    public DetailNewsPresenter(Router router) {
//        this.router = router;
//    }

    public void onBackCommandClick() {
        router.exit();
    }
}
