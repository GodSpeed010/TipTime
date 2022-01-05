package com.example.tiptimepractice

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.hamcrest.Matchers.containsString

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CalculatorTests {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip() {
        //type 50 into the cost EditText
        Espresso.onView(withId(R.id.et_cost))
            .perform(ViewActions.typeText("50.00"))

        //press 20% radio button
        Espresso.onView(withId(R.id.rb_amazing))
            .perform(ViewActions.click())

        //Press calculate button
        Espresso.onView(withId(R.id.bt_calculate))
            .perform(ViewActions.click())

        //Assert calculated tip
        Espresso.onView(withId(R.id.tv_tip_amount))
            .check(ViewAssertions.matches(ViewMatchers.withText(containsString("10.0"))))
    }

    @Test
    fun calculate_18_percent_tip() {
        //type 50 into cost EditText
        Espresso.onView(withId(R.id.et_cost))
            .perform(ViewActions.typeText("50.00"))

        //press 18% radio button
        Espresso.onView(withId(R.id.rb_good))
            .perform(ViewActions.click())

        //press calculate button
        Espresso.onView(withId(R.id.bt_calculate))
            .perform(ViewActions.click())

        //Assert calculated tip
        Espresso.onView(withId(R.id.tv_tip_amount))
            .check(ViewAssertions.matches(ViewMatchers.withText(containsString("9.0"))))
    }
}