package product.com.products.service;

import product.com.products.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Integer id);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Integer id, ProductDTO productDTO);

    void deleteProduct(Integer id);

    List<ProductDTO> getProductsByCategory(String category);
}