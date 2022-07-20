package ke.com.mtugo.model;


import javax.persistence.*;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @Column(name = "meal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "meal_name", length = 45)
    private String mealName;

    @Column(name = "meal_image", length = 45)
    private String mealImage;

    @Column(name = "meal_price", length = 45)
    private double mealPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealImage() {
        return mealImage;
    }

    public void setMealImage(String mealImage) {
        this.mealImage = mealImage;
    }

    public double getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(double mealPrice) {
        this.mealPrice = mealPrice;
    }
}
