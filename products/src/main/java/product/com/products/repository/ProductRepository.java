package product.com.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import product.com.products.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Optional<Product> findById(Integer id);

    void deleteById(Integer id);

    List<Product> findByCategory(String category);
}

