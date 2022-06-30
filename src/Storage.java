import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "products=" + products +
                '}';
    }
}
