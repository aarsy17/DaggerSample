package aarsy.com.daggersample.ui.main;

import android.arch.lifecycle.ViewModel;
import android.content.Context;

import javax.inject.Inject;

import aarsy.com.abstraction.di.ApplicationContext;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    @Inject
    public MainViewModel(@ApplicationContext Context context) {
    }
}
