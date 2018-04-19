package workshop.testing.data.local;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import workshop.testing.data.model.Recipe;

public class RecipeStore {
    public final List<Recipe> recipes = new ArrayList<>();
    private final Map<String, Recipe> map = new HashMap<>();

    public RecipeStore(Context context, String directory) {

        //Homework: can call every file in assets/recipes folder
        String[] recipeName  = {"chocolate_pudding","creamed_carrots", "deviled_eggs", "fried_tomatoes", "blueberry_muffin"};
        for(int i =0; i<= recipeName.length-1 ; i++ ){
            File file1 = new File(directory, ""+recipeName[i]+".txt");
            InputStream stream1 = null;
            try {
                stream1 = context.getAssets().open(file1.getPath());
                Recipe recipe = Recipe.readFromStream(stream1);
                recipes.add(recipe);
                map.put(recipe.id, recipe);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public Recipe getRecipe(String id) {
        return map.get(id);
    }
}
