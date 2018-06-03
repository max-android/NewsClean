package ru.exampleopit777.newsclean.presentation.presenter.base;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
public abstract class BasePresenter<V extends MvpView> extends MvpPresenter<V> {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void addDisposable(@NonNull final Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }
}
