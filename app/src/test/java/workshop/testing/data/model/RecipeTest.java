package workshop.testing.data.model;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class RecipeTest {
    @Test
    public void i_can_read_data_from_water(){
        //Call file
        InputStream inputStream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
        //Call Recipe class to read the file
        Recipe recipe = Recipe.readFromStream(inputStream);

        assertNotNull(recipe);

    }

}