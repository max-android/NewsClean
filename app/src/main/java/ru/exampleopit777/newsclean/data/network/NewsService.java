package ru.exampleopit777.newsclean.data.network;


import io.reactivex.Single;
import retrofit2.http.GET;
import ru.exampleopit777.newsclean.data.common.Constants;
import ru.exampleopit777.newsclean.data.entities.Rss;

/**
 * Created by Максим on 01.06.2018.
 */

public interface NewsService {
    @GET(Constants.REQUEST)
    Single<Rss> rss();
}
