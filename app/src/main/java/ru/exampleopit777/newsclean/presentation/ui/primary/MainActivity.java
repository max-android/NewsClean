package ru.exampleopit777.newsclean.presentation.ui.primary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import javax.inject.Inject;

import ru.exampleopit777.newsclean.R;
import ru.exampleopit777.newsclean.data.entities.Item;
import ru.exampleopit777.newsclean.data.system.ResourceManager;
import ru.exampleopit777.newsclean.di.app.App;
import ru.exampleopit777.newsclean.presentation.ui.base.BaseActivity;
import ru.exampleopit777.newsclean.presentation.ui.common.Screens;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;

public class MainActivity extends BaseActivity implements DetailFragment.TitulListener {

    @Inject
    Router router;
    @Inject
    ResourceManager resourceManager;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getAppComponent().injectMainActivity(this);
        initComponents();

        if (savedInstanceState == null) {
            router.replaceScreen(Screens.LIST_FRAGMENT);
        }
    }

    private void initComponents() {
        toolbar = findViewById(R.id.mainToolBar);
        attachToolbar(resourceManager.getString(R.string.news), false);
    }

    public static Intent createIntent(@NonNull final Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.container);

        if (fragment != null) {

            if (fragment instanceof DetailFragment) {
                Log.d("Pressed", "DetailFragment");
                ((DetailFragment) fragment).onBackPressed();
            }

            if (fragment instanceof NewsFragment) {
                Log.d("Pressed", "NewsFragment");
                super.onBackPressed();
            }
        }
    }

    public void attachToolbar(String caption, boolean arrows) {
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(caption);
            ab.setDisplayHomeAsUpEnabled(arrows);
        }
    }

    @Override
    protected Navigator getNavigator() {
        return navigator;
    }

    private final Navigator navigator = new SupportAppNavigator(this, R.id.container) {
        /**
         * Фабрика интентов для запуска других активностей из текущей
         *
         * @param screenKey идентификатор экрана активити
         * @param data      объект с данными, который приводится к нужному типу и передается в createIntent() активности
         * @return интент для запуска активности; null если не будет перехода на другую активность
         */
        @Override
        protected Intent createActivityIntent(
                @NonNull final Context context,
                @NonNull final String screenKey,
                @Nullable final Object data
        ) {
            return null;
        }

        /**
         * Фабрика фрагментов для текущей активности
         * @param screenKey идентификатор фрагментов
         * @param data объект с данными, который приводится к нужному типу и передается в newInstance() фрагмента
         * @return фрагмент, соответствующий {@code screenKey}
         */
        @Override
        protected Fragment createFragment(@NonNull final String screenKey, @Nullable final Object data) {
            final Fragment fragment;
            switch (screenKey) {
                case Screens.LIST_FRAGMENT:
                    fragment = NewsFragment.newInstance();
                    break;
                case Screens.DETAIL_FRAGMENT:
                    fragment = DetailFragment.newInstance((Item) data);
                    attachToolbar(resourceManager.getString(R.string.detail), true);
                    toolbar.setNavigationOnClickListener(exit -> ((DetailFragment) fragment).onBackPressed());
                    break;
                default:
                    fragment = NewsFragment.newInstance();
            }
            return fragment;
        }

        @Override
        public void applyCommands(Command[] commands) {
            super.applyCommands(commands);
        }
    };

    @Override
    public void updateTitul() {
        attachToolbar(resourceManager.getString(R.string.news), false);
    }
}
