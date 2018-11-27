package aarsy.com.abstraction.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MySubModule {

    @Provides
    MyRepo provideMyRepo(@ApplicationContext Context context){
        return new MyRepo(context);
    }
}
