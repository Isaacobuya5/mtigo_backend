package ke.com.mtugo.repositories;

import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    
}
