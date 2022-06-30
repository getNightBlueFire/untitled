import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Office {

    @XmlElement(name = "test")
    private String nameOf;

    @XmlElements({
            @XmlElement(name = "t1"),
            @XmlElement(name = "p1")
    })
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
}
