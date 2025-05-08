package product.com.products.mapper;

import org.springframework.stereotype.Component;
import product.com.products.dto.ProductDTO;
import product.com.products.dto.RatingDTO;
import product.com.products.model.Product;
import product.com.products.model.Rating;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setTitle(product.getTitle());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategory(product.getCategory());
        productDTO.setImage(product.getImage());

        if (product.getRating() != null) {
            RatingDTO ratingDTO = new RatingDTO();
            ratingDTO.setRate(product.getRating().getRate());
            ratingDTO.setCount(product.getRating().getCount());
            productDTO.setRating(ratingDTO);
        }

        return productDTO;
    }

    public Product toEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        product.setImage(productDTO.getImage());

        if (productDTO.getRating() != null) {
            Rating rating = new Rating();
            rating.setRate(productDTO.getRating().getRate());
            rating.setCount(productDTO.getRating().getCount());
            product.setRating(rating);
        }

        return product;
    }

    public List<ProductDTO> toDTOList(List<Product> products) {
        return products.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void updateProductFromDTO(ProductDTO productDTO, Product product) {
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        product.setImage(productDTO.getImage());

        if (productDTO.getRating() != null) {
            if (product.getRating() == null) {
                product.setRating(new Rating());
            }
            product.getRating().setRate(productDTO.getRating().getRate());
            product.getRating().setCount(productDTO.getRating().getCount());
        }
    }
}
