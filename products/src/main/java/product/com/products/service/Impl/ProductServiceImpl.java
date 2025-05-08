package product.com.products.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import product.com.products.dto.ProductDTO;
import product.com.products.exception.ResourceNotFoundException;
import product.com.products.mapper.ProductMapper;
import product.com.products.model.Product;
import product.com.products.repository.ProductRepository;
import product.com.products.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, MongoTemplate mongoTemplate) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDTOList(products);
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        productMapper.updateProductFromDTO(productDTO, existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        productRepository.delete(product);
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
        List<Product> products = productRepository.findByCategory(category);
        return productMapper.toDTOList(products);
    }
}
