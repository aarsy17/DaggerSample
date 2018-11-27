package aarsy.com.abstraction.di.modules;

import aarsy.com.abstraction.di.ApplicationScope;
import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;

@Module
public class InterceptorModule {

    @ApplicationScope
    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return logging;
    }

//    @ApplicationScope
//    @Provides
//    TkpdAuthInterceptor provideTkpdAuthInterceptor(@ApplicationContext Context context,
//                                                   AbstractionRouter abstractionRouter,
//                                                   UserSession userSession) {
//        return new TkpdAuthInterceptor(context, abstractionRouter, userSession);
//    }

}
