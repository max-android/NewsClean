package ru.exampleopit777.newsclean.presentation.ui.primary;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.RequestManager;

import javax.inject.Inject;

import ru.exampleopit777.newsclean.R;
import ru.exampleopit777.newsclean.data.common.Constants;
import ru.exampleopit777.newsclean.data.entities.Item;
import ru.exampleopit777.newsclean.di.app.App;
import ru.exampleopit777.newsclean.presentation.presenter.news.DetailNewsPresenter;
import ru.exampleopit777.newsclean.presentation.ui.base.BaseFragment;
import ru.exampleopit777.newsclean.presentation.view.DetailNewsView;

/**
 * Created by Максим on 01.06.2018
 */

public class DetailFragment extends BaseFragment implements DetailNewsView {

    public static final String DETAIL_ITEM = "det_item";
    private TitulListener listener;

    @Inject
    RequestManager requestManager;
    @InjectPresenter
    DetailNewsPresenter presenter;

    public DetailFragment() {
    }

    public static DetailFragment newInstance(Item item) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(DETAIL_ITEM, item);
        fragment.setArguments(args);
        return fragment;
    }

    private Item getItem() {
        return (Item) getArguments().getSerializable(DETAIL_ITEM);
    }

    public void onBackPressed() {
        presenter.onBackCommandClick();
        listener.updateTitul();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_detail;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.getAppComponent().injectDetailFragment(this);
        initComponents(view);
    }

    private void initComponents(View view) {
        ImageView image = view.findViewById(R.id.image);
        TextView tvDetTitul = view.findViewById(R.id.tvDetTitul);
        TextView tvDescription = view.findViewById(R.id.tvDescription);
        if (getItem().getEnclosure() == null) {
            requestManager.load(Constants.IMAGE).into(image);
        } else {
            requestManager.load(getItem().getEnclosure().getUrl()).into(image);
        }
        tvDetTitul.setText(getItem().getTitle());
        tvDescription.setText(getItem().getFulltext());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (TitulListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface TitulListener {
        void updateTitul();
    }
}
