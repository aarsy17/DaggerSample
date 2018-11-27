package aarsy.com.daggersample.di;


import aarsy.com.abstraction.di.BaseAppComponent;
import aarsy.com.abstraction.di.MySubComponent;
import aarsy.com.abstraction.di.MySubModule;
import aarsy.com.daggersample.FirstActivity;
import aarsy.com.daggersample.SecondActivity;
import aarsy.com.daggersample.ui.main.MainFragment;
import dagger.Component;

@ActivityScope
@Component(modules =  ActivityModule.class, dependencies = BaseAppComponent.class)
public interface ActivityComponent {

    MySubComponent addMySubComponent(MySubModule mySubModule);

    void inject(FirstActivity firstActivity);

    void inject(SecondActivity secondActivity);

    void inject(MainFragment mainFragment);
}
