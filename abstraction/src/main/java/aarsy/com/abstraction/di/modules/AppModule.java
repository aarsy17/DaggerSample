package aarsy.com.abstraction.di.modules;

import android.content.Context;

import aarsy.com.abstraction.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;


/**
 * @author kulomady on 1/9/17.
 */
@Module(includes = {NetModule.class})
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationContext
    public Context provideContext() {
        return context.getApplicationContext();
    }


//    protected UserSession realProvideUserSession(AbstractionRouter abstractionRouter){
//
//    }

}
