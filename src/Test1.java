
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class Test1 {
    public static void main(String[] args) throws Exception {
//        try {
//            toXml();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

            toXml();
    }
    public static void toXml() throws Exception {
        JAXBContext contextObj = JAXBContext.newInstance(Office.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        List<Office> offices = getOffices();
        for (Office of: offices) {
            String name = of.getNameOf();
            marshallerObj.marshal(of, new FileOutputStream(name+"_report.xml"));

        }

    }

    private static List<Office> getOffices() {
        Office office1 = new Office();
        Office office2 = new Office();
        Office office3 = new Office();
        Storage storage1 = new Storage();
        Storage storage2 = new Storage();
        Storage storage3 = new Storage();
        Storage storage4 = new Storage();
        Storage storage5 = new Storage();
        Product product1 = new Product("test1", 100);
        Product product2 = new Product("test2", 143);
        Product product3 = new Product("test3", 134);
        Product product4 = new Product("test4", 124);
        Product product5 = new Product("test5", 112);

        storage1.getProducts().add(product1);
        storage2.getProducts().add(product2);
        storage3.getProducts().add(product3);
        storage4.getProducts().add(product4);
        storage5.getProducts().add(product5);

        office1.setNameOf("office1");
        office2.setNameOf("office2");
        office3.setNameOf("office3");
        office1.getStorages().add(storage1);
        office1.getStorages().add(storage2);
        office1.getStorages().add(storage3);

        office2.getStorages().add(storage4);
        office2.getStorages().add(storage5);
        List<Office> offices = new ArrayList<>();
        offices.add(office1);
        offices.add(office2);
        offices.add(office3);
        return offices;
    }


    public static Office toObj() {

        try {

            File file0 = new File("office1_report.xml");
            File file1 = new File("office2_report.xml");
            File file2 = new File("office3_report.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Office.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Office unmarshal = (Office)jaxbUnmarshaller.unmarshal(file0);
            return unmarshal;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static void toJSONString() {
        JSONObject obj = new JSONObject();
       // List<Office> offices = getOffices();
        obj.put("name", "Pankaj Kumar");
        obj.put("age", 32);
        JSONArray cities = new JSONArray();
        obj.put("cities", cities);

        cities.add("New York");
        cities.add("Bangalore");
        cities.add("San Francisco");


        try {

            FileWriter file = new FileWriter("data.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj.toJSONString());

    }

    public static void fromJson() throws ParseException, FileNotFoundException, IOException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("data.json");

        Object jsonObj = parser.parse(reader);

        JSONObject jsonObject = (JSONObject) jsonObj;

        String name = (String) jsonObject.get("name");
        System.out.println("Name = " + name);

        long age = (Long) jsonObject.get("age");
        System.out.println("Age = " + age);

        JSONArray cities = (JSONArray) jsonObject.get("cities");

        Iterator<String> it = cities.iterator();
        while (it.hasNext()) {
            System.out.println("City = " + it.next());
        }
        reader.close();
    }

    public static void test() throws ParserConfigurationException, IOException, SAXException {
        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

//Build Document
        Document document = builder.parse(new File("office1_report.xml"));

//Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

//Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

//Get all employees
        NodeList nList = document.getElementsByTagName("office");
        System.out.println("============================");

        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            System.out.println("");    //Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                //Print each employee's detail
                Element eElement = (Element) node;
                System.out.println("Employee id : "    + eElement.getAttribute("id"));
                System.out.println("First Name : "  + eElement.getElementsByTagName("").item(0).getTextContent());
                System.out.println("Last Name : "   + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                System.out.println("Location : "    + eElement.getElementsByTagName("location").item(0).getTextContent());
            }
        }
    }





}
