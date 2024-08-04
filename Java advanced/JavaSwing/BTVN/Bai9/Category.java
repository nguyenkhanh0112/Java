package JavaSwing.BTVN.Bai9;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private String categoryName;
    private ArrayList<Product>products;

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.products = new ArrayList<>();
    }
    public Category(){

    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return null;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void updateProduct(Product product,int i) {
        this.products.set(i,product);
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public void removeProduct(Product product){
        this.products.remove(product);
    }

    @Override
    public String toString() {
        return  categoryName;
    }

    public Category(String categoryName, ArrayList<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
