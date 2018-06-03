package ru.exampleopit777.newsclean.presentation.presenter.news;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.exampleopit777.newsclean.data.entities.Item;
import ru.exampleopit777.newsclean.data.mapper.ItemMapper;
import ru.exampleopit777.newsclean.di.app.App;
import ru.exampleopit777.newsclean.domain.NewsInteractor;
import ru.exampleopit777.newsclean.presentation.presenter.base.BasePresenter;
import ru.exampleopit777.newsclean.presentation.ui.common.NetInspector;
import ru.exampleopit777.newsclean.presentation.ui.common.Screens;
import ru.exampleopit777.newsclean.presentation.view.NewsView;
import ru.terrakok.cicerone.Router;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
@InjectViewState
public class NewsPresenter extends BasePresenter<NewsView> {

    @Inject
    NewsInteractor newsInteractor;

    @Inject
    NetInspector netInspector;

    @Inject
    Router router;

    public NewsPresenter() {
        App.getAppComponent().injectNewsPresenter(this);
    }

//    public NewsPresenter(NewsInteractor newsInteractor, NetInspector netInspector,Router router) {
//        this.newsInteractor = newsInteractor;
//        this.netInspector = netInspector;
//        this.router = router;
//    }

    @Override
    protected void onFirstViewAttach() {
        showNews();
    }

    public void showNews() {
        if (netInspector.isOnline()) {
            addDisposable(newsInteractor.netNews()
                    .doOnSubscribe(disposable -> getViewState().showProgress())
                    .doFinally(() -> getViewState().removeProgress())
                    .subscribe(rss -> getViewState().showNews(rss.getChannel().getItem())
                            , error -> getViewState().showErrorLoadingNews()));
        } else {
            addDisposable(newsInteractor.dbNews()
                    .doOnSubscribe(disposable -> getViewState().showProgress())
                    .doFinally(() -> getViewState().removeProgress())
                    .subscribe(newsDBS -> getViewState().showNews(ItemMapper.transform(newsDBS))
                            , error -> getViewState().showErrorLoadingNews()));
        }
    }

    public void onItemClicked(Item item) {
        router.navigateTo(Screens.DETAIL_FRAGMENT, item);
    }
}
