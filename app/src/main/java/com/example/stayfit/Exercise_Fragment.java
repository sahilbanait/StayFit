package com.example.stayfit;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.stayfit.databinding.FragmentExerciseBinding;


public class Exercise_Fragment extends Fragment {
    private static final String TAG = "ExerciseFragment";
    private FragmentExerciseBinding fragmentExerciseBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentExerciseBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_exercise_, container, false);

        //Every exercise button is set with OnClickListener to navigate back to Exercise screen

        fragmentExerciseBinding.chestButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d(TAG,"Chest Button Clicked");
               Navigation.findNavController(v).navigate(R.id.action_exercise_Fragment_to_chest_Fragment2);
           }
       });
        fragmentExerciseBinding.absButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"AbsButton Clicked");
                Navigation.findNavController(v).navigate(R.id.action_exercise_Fragment_to_abs_Fragment);
            }
        });
        fragmentExerciseBinding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Back Button Clicked");
                Navigation.findNavController(v).navigate(R.id.action_exercise_Fragment_to_back_Fragment);
            }
        });
        fragmentExerciseBinding.legsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Legs Button Clicked");
                Navigation.findNavController(v).navigate(R.id.action_exercise_Fragment_to_legs_Fragment);
            }
        });
        fragmentExerciseBinding.shoulderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Shoulder Button Clicked");
                Navigation.findNavController(v).navigate(R.id.action_exercise_Fragment_to_shoulder_Fragment);
            }
        });
        fragmentExerciseBinding.armsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Arms Button Clicked");
                Navigation.findNavController(v).navigate(R.id.action_exercise_Fragment_to_arms_Fragment);
            }
        });

        return fragmentExerciseBinding.getRoot();
    }


}

