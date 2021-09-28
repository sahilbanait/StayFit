package com.example.stayfit;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.hasImeAction;
import static androidx.test.espresso.matcher.ViewMatchers.hasTextColor;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.app.Instrumentation;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Exercise_FragmentTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
    }

//  Email validation testing
    @Test
    public void emailValidatorTest() {
        onView(withId(R.id.text_email)).perform(typeText("xyz@gmail.com")).check(matches(isDisplayed()));
//

    }
    @Test
    public void floatingButtonTest(){
        onView(withId(R.id.floating_button)).perform(click()).check(matches(isDisplayed()));

    }

//    Up navigation testing
    @Test
    public void testUpNavigation(){
        @IdRes final int theme = R.style.Theme_AppCompat_DayNight;

        Bundle args = new Bundle();
        FragmentScenario<Exercise_Fragment> navhostScenario = FragmentScenario.launchInContainer(Exercise_Fragment.class, args, theme, Lifecycle.State.STARTED);

        navhostScenario.onFragment(fragment -> {

            // Create a NavController and set the NavController property on the fragment
            assertNotNull(fragment.getActivity());
            TestNavHostController navController = new TestNavHostController(fragment.getActivity());
            fragment.getActivity().runOnUiThread(() -> navController.setGraph(R.navigation.navigation));
            Navigation.setViewNavController(fragment.requireView(), navController);

            // Then navigate
            navController.navigate(R.id.action_title_to_exercise_Fragment);
            NavDestination destination = navController.getCurrentDestination();
            assertNotNull(destination);
            assertEquals(destination.getId(), R.id.exercise_Fragment);
        });
    }

    @After
    public void tearDown() throws Exception {
    }
}