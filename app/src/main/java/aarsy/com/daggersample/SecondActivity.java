package aarsy.com.daggersample;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import javax.inject.Inject;

import aarsy.com.abstraction.di.ApplicationScope;
import aarsy.com.abstraction.di.BaseAppComponent;
import aarsy.com.abstraction.di.BaseApplication;
import aarsy.com.daggersample.di.ActivityComponent;
import aarsy.com.daggersample.di.DaggerActivityComponent;
import aarsy.com.daggersample.di.ActivityModule;

public class SecondActivity extends AppCompatActivity {

    @Inject
    Gson gson;
    //
    @Inject
    Gson gson2;

    @Inject
    Context context;

    @Inject
    ActivityPresenter activityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BaseAppComponent baseAppComponent = ((BaseApplication) getApplication()).getBaseAppComponent();
        ActivityComponent activityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).baseAppComponent(baseAppComponent).build();
        activityComponent.inject(this);

        Log.d("SecondActivity", "Hash BaseAppComponent " + baseAppComponent.hashCode()
                + "\n Hash ActivityComponent " + activityComponent.hashCode()
                + "\n Hash BaseAppContext " + baseAppComponent.getContext().hashCode()
                + "\n Hash ActivityContextInjected " + context.hashCode()
                + "\n Hash AppGson1 " + gson.hashCode()
                + "\n Hash AppGson2 " + gson2.hashCode()
                + "\n Hash ActivityPresenter " + activityPresenter.hashCode());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
