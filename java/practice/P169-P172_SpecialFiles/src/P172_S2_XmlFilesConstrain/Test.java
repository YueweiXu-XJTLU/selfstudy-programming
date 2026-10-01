package P172_S2_XmlFilesConstrain;

public class Test {
    public static void main(String[] args) {
       //XML Files Constrain: XML文件的约束: use constrain documents

       //Documents type 1:DTD Document: .dtd:
        //inside .xml files, use <!DOCTYPE rootElementName SYSTEM "DTD.dtd"> in 2nd line to load the .dtd document
        //.dtd document can NOT constrain data_type


       //Documents type 2:Schema Document: .xsd:
        //inside .xml files, need to load the .xsd document (complex)
        //.xsd document CAN constrain data_type


    }
}
