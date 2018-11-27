package aarsy.com.abstraction.di.modules;
import aarsy.com.abstraction.di.ApplicationScope;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = {InterceptorModule.class})
public class OkHttpClientModule {

    @ApplicationScope
    @Provides
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder okHttpClientBuilder) {
        return okHttpClientBuilder.build();
    }

}
