package ke.com.mtugo.controller;

import ke.com.mtugo.model.Meal;
import ke.com.mtugo.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MealsController {

    @Autowired
    private MealService mealService;


    @CrossOrigin("*")
    @GetMapping("/meals")
    ResponseEntity<List<Meal>> getAllDepartments() {
        List<Meal> meals = mealService.mealsList();
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }
}
