package product.com.products.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private RatingDTO rating;

    public ProductDTO() {
    }

}
