import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.productservice.model.Product;

@Repository("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, String > {
}

