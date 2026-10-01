package P200_S1_Orders;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        List<Order> orders = new ArrayList<>();

        //1.Parse .xml file
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("YOUR_ORDERS_XML_FILE");
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        for (Element element : elements) {
            Order order = new Order();
            order.setId(Integer.valueOf(element.attributeValue("id"))); //!!!attribute != elementText!!!
            order.setName(element.elementTextTrim("name"));
            order.setTime(LocalDateTime.parse(element.elementTextTrim("time"), dtf));
            order.setPrice(Double.valueOf(element.elementTextTrim("price")));

            //add into ArrayList
            orders.add(order);
        }
        System.out.println(orders);



        System.out.println("==========");



        //2.filter orders before 2023-10-01 and output, using stream
        orders.stream()
                .filter(order -> order.getTime().isBefore(LocalDateTime.parse("2023-10-01 00:00:00", dtf)))
                .forEach(System.out::println);



        System.out.println("==========");



        //3.find the most expensive order
        orders.stream()
                .sorted(((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice())))
                .limit(1)
                .forEach(System.out::println);



        System.out.println("==========");



        //4.output orders by down-order of price
        orders.stream()
                .sorted(((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice())))
                .forEach(System.out::println);
    }
}
