import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    @XmlAttribute(name = "name")
    private String name;

    @XmlElementWrapper(name = "lines")
    @XmlElements(
            @XmlElement(name = "line")
    )
    private List<String> quests = new ArrayList<>();

    public Product() {
    }

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public List<String> getQuests() {
        return quests;
    }

    public void setQuests(List<String> quests) {
        this.quests = quests;
    }
}
