package aarsy.com.abstraction.di;

import android.content.Context;

import com.google.gson.Gson;

import aarsy.com.abstraction.di.modules.AppModule;
import dagger.Component;
import dagger.Subcomponent;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@ApplicationScope
@Component(modules = {
        AppModule.class
})
public interface BaseAppComponent {

    @ApplicationContext
    Context getContext();

    MySubComponent addMySubComponent(MySubModule mySubModule);

    Retrofit.Builder retrofitBuilder();

    Gson gson();

    HttpLoggingInterceptor httpLoggingInterceptor();

    void inject(BaseApplication baseApplication);

    //TkpdAuthInterceptor tkpdAuthInterceptor();

}
