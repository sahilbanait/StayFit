package com.example.stayfit;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stayfit.databinding.FragmentTitleBinding;


public class Title extends Fragment {
private FragmentTitleBinding fragmentTitleBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTitleBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_title, container, false);
        fragmentTitleBinding.proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_title_to_exercise_Fragment);
            }
        });
        return fragmentTitleBinding.getRoot();
    }
}