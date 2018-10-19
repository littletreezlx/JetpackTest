package com.example.jetpacktest.ui;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jetpacktest.R;
import com.example.jetpacktest.viewmodel.MainViewModel;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.setting_tv)
    TextView settingTv;
    @BindView(R.id.main)
    RelativeLayout main;
    private MainViewModel mViewModel;

    public static SettingActivity newInstance() {
        return new SettingActivity();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        ButterKnife.bind(this);



//        settingTv.setText();
    }

}
