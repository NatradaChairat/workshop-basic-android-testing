package workshop.testing.data.model;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class RecipeTest {
    @Test
    public void test_ioexception() throws IOException{
        InputStream inputStream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
        inputStream.close();
        //Call Recipe class to read the file
        Recipe recipe = Recipe.readFromStream(inputStream);

        assertNull(recipe);
    }

    @Test
    public void i_can_read_data_from_water(){
        //Call file
        InputStream inputStream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
        //Call Recipe class to read the file
        Recipe recipe = Recipe.readFromStream(inputStream);


        assertNotNull(recipe);
        assertEquals("water", recipe.id);
        assertEquals("Water", recipe.title);
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description);

    }

    @Test
    public void i_can_read_data_from_noId(){
        //Call file
        InputStream inputStream = RecipeTest.class.getResourceAsStream("/recipes/no_id.txt");
        //Call Recipe class to read the file
        Recipe recipe = Recipe.readFromStream(inputStream);


        assertNotNull(recipe);
        assertEquals(null, recipe.id);
        assertEquals("Water", recipe.title);
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description);

    }

    @Test
    public void i_can_read_data_from_mixed(){
        //Call file
        InputStream inputStream = RecipeTest.class.getResourceAsStream("/recipes/mixed.txt");
        //Call Recipe class to read the file
        Recipe recipe = Recipe.readFromStream(inputStream);


        assertNotNull(recipe);
        assertEquals("punch", recipe.id);
        assertEquals("Punch", recipe.title);
        assertEquals("Juice of 3 lemons\n" +
                "1 orange\n" +
                "1 pint grape juice\n" +
                "1 cup sugar\n" +
                "1 cup water\n" +
                "1 pine apple juice\n" +
                "Mix all together and strain. Add large piece of ice.", recipe.description);

    }




}