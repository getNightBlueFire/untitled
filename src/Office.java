import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Office {

    @XmlAttribute(name = "name")
    private String nameOf;

    @XmlList
    private List<Integer> ints = new ArrayList<>();


    private String type;
    private String author;

    @XmlElementWrapper(name = "storages")
    @XmlElements(
            @XmlElement(name = "storage")
    )
    private List<Storage> storages = new ArrayList<>();

    public String getNameOf() {
        return nameOf;
    }

    public void setNameOf(String nameOf) {
        this.nameOf = nameOf;
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }

    @Override
    public String toString() {
        return "Office{" +
                "nameOf='" + nameOf + '\'' +
                ", storages=" + storages +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Integer> getInts() {
        return ints;
    }

    public void setInts(List<Integer> ints) {
        this.ints = ints;
    }
}
