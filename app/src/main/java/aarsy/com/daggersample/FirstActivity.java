package aarsy.com.daggersample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import javax.inject.Inject;

import aarsy.com.abstraction.di.ApplicationScope;
import aarsy.com.abstraction.di.BaseAppComponent;
import aarsy.com.abstraction.di.BaseApplication;
import aarsy.com.daggersample.di.ActivityComponent;
import aarsy.com.daggersample.di.ActivityModule;
import aarsy.com.daggersample.di.ActivityQualifier;
import aarsy.com.daggersample.di.ActivityScope;
import aarsy.com.daggersample.di.DaggerActivityComponent;
import aarsy.com.daggersample.ui.main.MainFragment;

public class FirstActivity extends AppCompatActivity {


    @Inject
    @ActivityQualifier
    Gson gson;

    @Inject
    Gson gson2;

    @Inject
    Context context;

    @Inject
    ActivityPresenter activityPresenter;

    @Inject
    UserInfo userInfo;

    @Inject
    UserInfo userInfo2;
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        BaseAppComponent baseAppComponent = ((BaseApplication) getApplication()).getBaseAppComponent();
        activityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).baseAppComponent(baseAppComponent).build();
        activityComponent.inject(this);

        Log.d("FirstActivity", "Hash BaseAppComponent " + baseAppComponent.hashCode()
                + "\n Hash ActivityComponent " + activityComponent.hashCode()
                + "\n Hash BaseAppContext " + baseAppComponent.getContext().hashCode()
                + "\n Hash ActivityContextInjected " + context.hashCode()
                + "\n Hash ActivityGson1 " + gson.hashCode()
                + "\n Hash AppGson2 " + gson2.hashCode()
                + "\n Hash ActivityPresenter " + activityPresenter.hashCode()
                + "\n Hash userInfo1 " + userInfo.hashCode()+" "+userInfo.getUserId()
                + "\n Hash userInfo2 " + userInfo2.hashCode()+" "+userInfo2.getUserId());

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

    }
    public ActivityComponent getComponent(){
        return activityComponent;
    }



}




