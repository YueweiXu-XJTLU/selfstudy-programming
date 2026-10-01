package P171_XmlFilesParse;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        //.xml file (Extensible Markup Language 可扩展标记语言)
        //<tag> are extensible (can be defined by users), must be nested correctly
        //<tag> appear in pairs
        //<tag> can have attributes (<tag name="tag1">)
        //only ONE root-tag is available

        //Parse/Read: use 3rd-party(第三方的) frameworks: eg. Dom4j

        //第三方框架使用步骤：
        //1.官网下载框架
        //2.在项目中创建一个文件夹:lib
        //3.将.jar文件复制到lib文件夹
        //4.在jar文件上点右键，选择 Add as Library -> 点击OK
        //5.在类中导包使用

        //Dom4j use SAXReader to parse xml to a Document, then further read the file

        //1.create a SAXReader Object
        SAXReader saxReader = new SAXReader();

        //2.parse xml to a Document Object
        //public Document read(String systemId) OR public Document read(InputStream is)
        Document document = saxReader.read("YOUR_XML_FILE");

        //3.parse information from the Document Object

        //3.1.parse root_element object
        //public Element getRootElement()
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());

        //3.2.further parse
        //3.2.1.public String getName()



        //3.2.2.1.public List<Element> elements():get all immediate child elements(一级子元素)
                //OR get immediate child elements with certain name using "public List<Element> elements(String name)"
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println(element.getName());
        }
        //3.2.2.2.public Element element(String name): get ONE CERTAIN immediate child element (the FIRST by default)
        Element element = rootElement.element("user1");
        System.out.println(element.getName());



        //3.2.3.1.public List<Attribute> attributes()
        List<Attribute> attributes = element.attributes();
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName() + ": " + attribute.getValue());
        }
        //3.2.3.2.1.public String attributeValue(String name)
        System.out.println(element.attributeValue("id"));
        //3.2.3.2.2.public Attribute attribute(String name) + public String getName() + public String getValue()
        Attribute userId = element.attribute("id");
        System.out.println(userId.getName() + ": " + userId.getValue());



        //3.2.4.1.public String elementText(子元素名)
        System.out.println(element.elementText("gender"));
        //3.2.4.2.public String getText()
        Element name = element.element("name");
        System.out.println(name.getText());
        //3.2.4.3.use elementTextTrim & getTextTrim() to remove space(" ") before & after the text
        Element user2 = rootElement.element("user2");
        Element data1 = user2.element("data1");
        System.out.println(data1.getTextTrim());
    }
}
