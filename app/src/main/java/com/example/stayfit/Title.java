package com.example.stayfit;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stayfit.databinding.FragmentTitleBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;


public class Title extends Fragment {

    private FragmentTitleBinding fragmentTitleBinding;
    LinearLayout layout;
    Boolean color = false;
    EditText editText;
    FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //binding the view using databinding method
        fragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false);

        layout = fragmentTitleBinding.titleLinearLayout;
        floatingActionButton = fragmentTitleBinding.floatingButton;


        //This method is used to change the color of screen
        fragmentTitleBinding.floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random ranNum = new Random();
                if (color == false) {
                    int myNum = Color.argb(255, ranNum.nextInt(256), ranNum.nextInt(256), ranNum.nextInt(256));
                    layout.setBackgroundColor(myNum);
                    color = true;
                } else {
                    layout.setBackgroundColor(Color.WHITE);
                    color = false;
                }
            }
        });
        editText = fragmentTitleBinding.textEmail;

        // This method is used to set the email validator

        fragmentTitleBinding.proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailToText = editText.getText().toString();

                if(!emailToText.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailToText).matches()){
                    Snackbar.make(v,"Email verified", Snackbar.LENGTH_LONG).show();
                    Navigation.findNavController(v).navigate(R.id.action_title_to_exercise_Fragment);
                }else {
                    Snackbar.make(v,"Enter valid email", Snackbar.LENGTH_LONG).show();

                }

            }
        });


        return fragmentTitleBinding.getRoot();
    }


}



