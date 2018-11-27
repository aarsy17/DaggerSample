package aarsy.com.abstraction.di.modules;

import dagger.Module;

@Module(includes = {OkHttpClientModule.class, RetrofitModule.class})
public class NetModule {

}