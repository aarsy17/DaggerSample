package aarsy.com.daggersample.module1.di;


import aarsy.com.abstraction.di.BaseAppComponent;
import dagger.Component;


@Module1Scope
@Component(modules = Module1DaggerModule.class, dependencies = BaseAppComponent.class)
public interface Module1DaggerComponent {
}
