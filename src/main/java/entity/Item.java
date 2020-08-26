package entity;

public class Item {
    // {"id":"5f42c0c88bc1bb00066cd826","itemId":"03fef6ac-1896-4ce8-bd69-b798f85c6e0b","quantity":1,"unitPrice":99.99}
    private String id;
    private String itemId;
    private int quantity;
    private float unitPrice;

    public Item(String id, String itemId, int quantity, float unitPrice) {
        this.id = id;
        this.itemId = itemId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }
}
