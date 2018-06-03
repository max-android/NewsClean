package ru.exampleopit777.newsclean.data.system;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * Created Максим on 01.06.2018.
 * Copyright © Max
 */
public class ResourceManager {
    private Context context;

    public ResourceManager(@NonNull Context context) {
        this.context = context;
    }

    public String getString(@StringRes int id) {
        return context.getString(id);
    }
}
