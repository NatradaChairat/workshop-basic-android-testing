package workshop.testing.ui.recipe;



import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.security.Key;

import workshop.testing.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import static workshop.testing.ui.recipe.RecipeActivity.KEY_ID;

public class RecipeActivityTest {

    @Rule
    public ActivityTestRule<RecipeActivity> activity
            = new ActivityTestRule(RecipeActivity.class, true, false);

    @Test
    public void openActivityByDefaultShouldShowRecipenotfound() {
        activity.launchActivity(new Intent());
        onView(withId(R.id.description)).check(matches(withText("Recipe not found.")));
    }

    @Test
    public void success(){
        Intent intent = new Intent();
        intent.putExtra(KEY_ID, "chocolate_pudding");
        activity.launchActivity(intent);
        onView(withId(R.id.title)).check(matches(withText("Chocolate Pudding")));
       /* onView(withId(R.id.description)).check(matches(withText("2 tablespoons chocolate\n" +
                "yolks of 4 eggs\n" +
                "1 cup sugar\n" +
                "1 quart milk\n" +
                "1 whole egg\n" +
                "2 tablespoons corn starch\n" +
                "\n" +
                "Cook until it thickens, beat whites of eggs and put on top, put in oven to brown. Serve with cream, if preferred.")));*/
    }

    @Test
    public void show_chocolate_pudding(){
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID,"chocolate_pudding");
        activity.launchActivity(intent);

        onView(withId(R.id.title)).check(matches(withText("Chocolate Pudding")));

    }


    @Test
    public void show_creamed_carrots(){
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID,"creamed_carrots");
        activity.launchActivity(intent);

        onView(withId(R.id.title)).check(matches(withText("Creamed Carrots")));

    }

    @Test
    public void show_deviled_eggs(){
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID,"deviled_eggs");
        activity.launchActivity(intent);

        onView(withId(R.id.title)).check(matches(withText("Deviled Eggs")));

    }

    @Test
    public void show_fried_tomatoes(){
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID,"fried_tomatoes");
        activity.launchActivity(intent);

        onView(withId(R.id.title)).check(matches(withText("Fried Tomatoes")));

    }


    @Test
    public void show_blueberry_muffin(){
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID,"blueberry_muffin");
        activity.launchActivity(intent);

        onView(withId(R.id.title)).check(matches(withText("Blueberry Muffin")));

    }
}