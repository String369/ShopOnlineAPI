package product.com.products.dto;

public class RatingDTO {

    private Double rate;
    private Integer count;

    public RatingDTO() {
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
