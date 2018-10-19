package com.example.jetpacktest.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jetpacktest.R;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class BlankFragment2 extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_blank2, container, false);
        TextView blankTv  = view.findViewById(R.id.blank_tv);


//        blankTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Navigation.findNavController(getView()).navigate(R.id.action_global_main_fragment);
//            }
//        });

        blankTv.setOnClickListener(view0 -> Navigation.findNavController(getView()).navigateUp());

//        blankTv.setOnClickListener(view0 -> Navigation.findNavController(getView()).navigate(R.id.action_global_main_fragment));
//        blankTv.setText(user);

        return view;
    }

}
