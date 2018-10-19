package com.example.jetpacktest.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jetpacktest.R;
import com.example.jetpacktest.model.User;
import com.example.jetpacktest.service.MainPresenter;
import com.example.jetpacktest.viewmodel.MainViewModel;
import com.example.jetpacktest.viewmodel.MainViewModelFactory;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {


    private MainPresenter mainPresenter;



    @BindView(R.id.users_tv)
    TextView usersTv;
    @BindView(R.id.username_btn)
    Button usernameBtn;
    @BindView(R.id.userage_btn)
    Button userageBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, MainFragment.newInstance())
//                    .commitNow();
//        }

//        SqlScoutServer.create(this, getPackageName());


        MainPresenter mainPresenter = new MainPresenter(this);

        MainViewModel mainViewModel = ViewModelProviders.of(this, new MainViewModelFactory(this.getApplication(), "aaaaa")).get(MainViewModel.class);
        mainViewModel.getUsers().observe(this, users -> usersTv.setText(users.toString()));

        userageBtn.setOnClickListener(view -> mainViewModel.onAddAgeClick());

    }


    @MainThread
    public void addObserver(@NonNull LifecycleObserver observer) {
        getLifecycle().addObserver(observer);
    }

    @MainThread
    public void removeObserver(@NonNull LifecycleObserver observer) {
        getLifecycle().removeObserver(observer);
    }

    @MainThread
    @NonNull
    public Lifecycle.State getCurrentState() {
        return getLifecycle().getCurrentState();
    }



//  equals  app:defaultNavHost="true"
    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.main_fragment).navigateUp();
    }
}


//
//    ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
//    // or
//    ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);