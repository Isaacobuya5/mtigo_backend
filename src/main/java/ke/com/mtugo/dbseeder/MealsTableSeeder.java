package ke.com.mtugo.dbseeder;

import ke.com.mtugo.model.Meal;
import ke.com.mtugo.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.List;

public class MealsTableSeeder {

    @Autowired
    private MealService mealService;

    private void seedMealsSeeder() {
        List<Meal> meals = mealService.mealsList();
        // if no meals exist
        if (meals == null || meals.size() <= 0) {
            // seed the database
//            Meal meal = new Meal();
//            meal.setMealName("Beef");
//            meal.setMealImage("https://www.themealdb.com/images/category/beef.png");
//            meal.setMealPrice(1.0);
            //List<Meal> mealList =
        }
    }
}

