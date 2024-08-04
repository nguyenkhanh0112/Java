package JavaSwing.BTVN.Bai9;

import java.io.Serializable;

public class Product  implements Serializable {
    private String id;
    private String Name;
    private Double Price;
    private int Quantity;
    private String Description;

    public Product() {
    }

    public Product(String id, String name, Double price, int quantity, String description) {
        this.id = id;
        Name = name;
        Price = price;
        Quantity = quantity;
        Description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Quantity=" + Quantity +
                ", Description='" + Description + '\'' +
                '}';
    }
}
