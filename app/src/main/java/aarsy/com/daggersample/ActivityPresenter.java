package aarsy.com.daggersample;

import android.content.Context;

import javax.inject.Inject;

public class ActivityPresenter {

    Context context;
    @Inject
    public ActivityPresenter(Context context){
        this.context=context;
    }
}
