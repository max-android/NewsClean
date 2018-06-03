package ru.exampleopit777.newsclean.presentation.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

public abstract class BaseFragment extends MvpAppCompatFragment {

    /**
     * @return id разметки для фрагмента
     */
    @LayoutRes
    protected abstract int getLayoutRes();

    @Nullable
    @Override
    public View onCreateView(
            @NonNull final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState
    ) {
        return inflater.inflate(getLayoutRes(), container, false);
    }

    protected void showSnackMessage(@NonNull View view, @NonNull String text) {
        if (getView() != null) {
            Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
        }
    }
}
