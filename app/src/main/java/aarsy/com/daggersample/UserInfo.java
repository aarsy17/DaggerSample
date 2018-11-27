package aarsy.com.daggersample;

import android.content.Context;

import javax.inject.Inject;

import aarsy.com.daggersample.di.ActivityScope;

@ActivityScope          //to make singleton in the binding
public class UserInfo {

    private Context context;
    private String userId;

    @Inject
    public UserInfo(Context context) {
        this.context=context;
    }

    public UserInfo(Context context, String userId){
        this.context=context;
        this.userId=userId;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
