package ru.exampleopit777.newsclean.presentation.ui.primary;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import javax.inject.Inject;

import ru.exampleopit777.newsclean.R;
import ru.exampleopit777.newsclean.data.entities.Item;
import ru.exampleopit777.newsclean.data.system.ResourceManager;
import ru.exampleopit777.newsclean.di.app.App;
import ru.exampleopit777.newsclean.presentation.presenter.news.NewsPresenter;
import ru.exampleopit777.newsclean.presentation.ui.base.BaseFragment;
import ru.exampleopit777.newsclean.presentation.ui.common.SwipeManager;
import ru.exampleopit777.newsclean.presentation.view.NewsView;

/**
 * Created by Максим on 01.06.2018.
 */

public class NewsFragment extends BaseFragment implements NewsView {

    @InjectPresenter
    NewsPresenter presenter;

    @Inject
    ResourceManager resourceManager;

    private RecyclerView rvNews;
    private ProgressBar progressBar;
    private SwipeRefreshLayout newsSwipeRefresh;
    private SwipeManager swipeManager;

    public NewsFragment() {
    }

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_news;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        App.getAppComponent().injectNewsFragment(this);
        initComponents(view);
        createItemTouch();
    }

    private void initComponents(View view) {
        progressBar = view.findViewById(R.id.progressBar);
        newsSwipeRefresh = view.findViewById(R.id.newsSwipeRefresh);
        newsSwipeRefresh.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);
        swipeManager = new SwipeManager(newsSwipeRefresh, progressBar, () -> presenter.showNews());
        newsSwipeRefresh.setOnRefreshListener(swipeManager);
        newsSwipeRefresh.setRefreshing(false);
        rvNews = view.findViewById(R.id.rvNews);
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
        rvNews.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void showNews(List<Item> results) {
        rvNews.setAdapter(new NewsAdapter(results, item -> presenter.onItemClicked(item)));
    }

    @Override
    public void showErrorLoadingNews() {
        // showSnackMessage(getActivity().findViewById(R.id.newsCoord),resourceManager.getString(R.string.error));
        showSnackMessage(getView().findViewById(R.id.mainLinear), resourceManager.getString(R.string.error));
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeProgress() {
        progressBar.setVisibility(View.GONE);
    }

    private void createItemTouch() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvNews);
    }

    private ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();
            NewsAdapter adapter = (NewsAdapter) rvNews.getAdapter();
            adapter.adOnMove(fromPosition, toPosition);
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            NewsAdapter adapter = (NewsAdapter) rvNews.getAdapter();
            adapter.adOnSwiped(viewHolder);
        }
    };

}
