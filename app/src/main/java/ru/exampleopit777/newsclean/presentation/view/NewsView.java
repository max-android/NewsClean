package ru.exampleopit777.newsclean.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.exampleopit777.newsclean.data.entities.Item;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface NewsView extends MvpView {

    void showNews(List<Item> results);

    void showErrorLoadingNews();

    void showProgress();

    void removeProgress();
}
