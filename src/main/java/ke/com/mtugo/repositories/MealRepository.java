package ke.com.mtugo.repositories;

import ke.com.mtugo.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
