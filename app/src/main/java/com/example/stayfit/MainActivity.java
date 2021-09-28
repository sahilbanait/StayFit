package com.example.stayfit;



import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewbinding.ViewBinding;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.stayfit.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding mainBinding;
    AppBarConfiguration appBarConfiguration;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        //Declaring navhostfragment for navigation
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        NavController navController = navHostFragment.getNavController();

        //Setting up toolbar with up navigation
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);


    }
// This method is used to hide the keyboard when user touches the screen anywhere
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() ==
                MotionEvent.ACTION_MOVE) && view instanceof EditText &&
                !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((
                        this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }


}
