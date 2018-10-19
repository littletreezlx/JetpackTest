package com.example.jetpacktest.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jetpacktest.R;
import com.example.jetpacktest.viewmodel.MainViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainFragment extends Fragment {


    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.tosettings_btn)
    Button tosettingsBtn;
    private MainViewModel mViewModel;

    private Unbinder unbinder;


    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tosettings_btn)
    public void onToSettingsClicked(View view) {

        Bundle bundle = new Bundle();
        bundle.putString("amount", "abcde");



        Navigation.findNavController(view).navigate(R.id.action_main_fragment_to_settings_activity);
//        button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.next_fragment, null));

    }


    @OnClick(R.id.toblank_btn)
    public void onToBlankClicked(View view) {


//        MainFragmentDirections.ActionMainFragmentToBlankFragment action = MainFragmentDirections.actionMainFragmentToBlankFragment();

//        Navigation.findNavController(view).addOnNavigatedListener(new NavController.OnNavigatedListener() {
//            @Override
//            public void onNavigated(@NonNull NavController controller, @NonNull NavDestination destination) {
//
//            }
//        });

        MainFragmentDirections.BlankAction action = MainFragmentDirections.blankAction();

//        action.setUser("apple");

//        Navigation.findNavController(view).navigate(R.id.blank_action);
        Navigation.findNavController(view).navigate(action);

    }


}
