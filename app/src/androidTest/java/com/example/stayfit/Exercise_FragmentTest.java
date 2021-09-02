package com.example.stayfit;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasImeAction;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.Instrumentation;
import android.view.View;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class Exercise_FragmentTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void emailValidatorTest() {

        onView(withId(R.id.text_email)).perform(typeText("sahil.saini526@gmail.com"));
        onView(withId(R.id.proceed_button)).perform(click()).check(matches(isDisplayed()));

    }
    @Test
    public void testUpNavigation(){
        TestNavHostController navHostController = new TestNavHostController( ApplicationProvider.getApplicationContext());
        FragmentScenario<Exercise_Fragment> scenario = FragmentScenario.launch(Exercise_Fragment.class);
        scenario.onFragment( exercise_fragment -> {
             navHostController.setGraph(R.navigation.navigation);
             Navigation.setViewNavController(exercise_fragment.requireView(), navHostController);
                });

        onView(withId(R.id.proceed_button)).perform(click());




    }

    @After
    public void tearDown() throws Exception {
    }
}