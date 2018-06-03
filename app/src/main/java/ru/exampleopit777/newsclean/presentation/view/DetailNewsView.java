package ru.exampleopit777.newsclean.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface DetailNewsView extends MvpView {
}
