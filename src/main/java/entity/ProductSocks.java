package entity;

import lombok.Data;

@Data
public class ProductSocks {
    private String itemId;
    private String id;

    public ProductSocks(String itemId, String id) {
        this.itemId = itemId;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductSocks{" +
                "itemId='" + itemId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
