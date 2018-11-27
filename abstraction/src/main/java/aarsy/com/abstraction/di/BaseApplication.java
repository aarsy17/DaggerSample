package aarsy.com.abstraction.di;

import android.app.Application;
import android.util.Log;

import aarsy.com.abstraction.di.modules.AppModule;

public class BaseApplication extends Application {
    private BaseAppComponent baseAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        getBaseAppComponent().inject(this);
    }

    public BaseAppComponent getBaseAppComponent(){
        if (baseAppComponent == null) {
            DaggerBaseAppComponent.Builder daggerBuilder = DaggerBaseAppComponent.builder()
                    .appModule(new AppModule(this));
            baseAppComponent = daggerBuilder.build();
//            MySubComponent mySubComponent=baseAppComponent.addMySubComponent(new MySubModule());
//            this new MySubComponent  instance is built with its own dependency graph.

        }
        Log.d("BaseApplication", "Hash BaseApp " + baseAppComponent.hashCode()
                + "\n Hash BaseAppContext " + baseAppComponent.getContext().hashCode());
        return baseAppComponent;
    }
}
