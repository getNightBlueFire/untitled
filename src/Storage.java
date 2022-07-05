import com.sun.xml.bind.XmlAccessorFactory;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Storage {

    @XmlElementWrapper(name = "products")
    @XmlElements(
            @XmlElement(name = "product")
    )
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
