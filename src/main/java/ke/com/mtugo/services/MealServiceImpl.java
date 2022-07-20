package ke.com.mtugo.services;

import ke.com.mtugo.model.Meal;
import ke.com.mtugo.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Override
    public List<Meal> mealsList() {
        return mealRepository.findAll();
    }
}
