package ru.exampleopit777.newsclean.presentation.ui.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import ru.exampleopit777.newsclean.di.app.App;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;


public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;

    /**
     * @return навигатор, реализуемый конкретной активностью
     */
    protected abstract Navigator getNavigator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getAppComponent().injectBaseActivity(this);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(getNavigator());
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }
}
