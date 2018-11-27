package aarsy.com.daggersample.di;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import aarsy.com.daggersample.UserInfo;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityQualifier
//    @Named("activityGson")
    public Gson provideGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }

    @Provides
    @UserQualifier
//    @Named("userGson")
    public Gson provideGsonForUser() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
    }

    @Provides
    @ActivityScope
    public UserInfo userInfo(Context context){
        return new UserInfo(context, "12345");
    }

    @Provides
    public Context provideActivityContext() {
        return context;
    }

}
