package P172_S1_XmlFilesGeneration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        //Generation/Output a xml file: just append as a String and write out using IO_Stream

        /*
        <?xml version="1.0" encoding="UTF-8" ?>
<bookstore>
    <book category="fiction">
        <title lang="en">The Great Gatsby</title>
        <author>F. Scott Fitzgerald</author>
        <year>1925</year>
        <price>10.99</price>
    </book>
</bookstore>
        */

        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
        sb.append("<bookstore>\n");
        sb.append("\t\t<book category=\"fiction\">\n");
        sb.append("\t\t<title lang=\"en\">The Great Gatsby</title>\n");
        sb.append("\t\t<author>F. Scott Fitzgerald</author>\n");
        sb.append("\t\t<year>1925</year>\n");
        sb.append("\t\t<price>10.99</price>\n");
        sb.append("\t</book>\n");
        sb.append("</bookstore>\n");



        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("YOUR_OUTPUT_XML_FILE"));
                ){
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
