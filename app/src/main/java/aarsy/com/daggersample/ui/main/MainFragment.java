package aarsy.com.daggersample.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import javax.inject.Inject;

import aarsy.com.abstraction.di.BaseAppComponent;
import aarsy.com.abstraction.di.BaseApplication;
import aarsy.com.daggersample.FirstActivity;
import aarsy.com.daggersample.R;
import aarsy.com.daggersample.SecondActivity;
import aarsy.com.daggersample.UserInfo;
import aarsy.com.daggersample.di.ActivityComponent;
import aarsy.com.daggersample.di.ActivityModule;
import aarsy.com.daggersample.di.ActivityQualifier;
import aarsy.com.daggersample.di.DaggerActivityComponent;

public class MainFragment extends Fragment {

//    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Inject
    UserInfo userInfo;
    @Inject
    @ActivityQualifier
    Gson gson;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });
        BaseAppComponent baseAppComponent = ((BaseApplication) getActivity().getApplication()).getBaseAppComponent();
        ActivityComponent activityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(getContext())).baseAppComponent(baseAppComponent).build();
        activityComponent.inject(this);
        Log.d("MainFragment", userInfo.hashCode() + " " + userInfo.getUserId()+"  "+gson.hashCode());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    public void openSecondActivity() {
        Intent main2Activity = new Intent(getContext(), SecondActivity.class);
        startActivity(main2Activity);

    }

}
