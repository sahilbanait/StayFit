package com.example.stayfit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.stayfit.databinding.FragmentExerciseBinding;


public class Exercise_Fragment extends Fragment {

    private FragmentExerciseBinding fragmentExerciseBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentExerciseBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_exercise_, container, false);
        fragmentExerciseBinding.chestButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Navigation.findNavController(v).navigate(R.id.action_exercise_Fragment_to_chest_Fragment2);
           }
       });

        return fragmentExerciseBinding.getRoot();
    }


}

