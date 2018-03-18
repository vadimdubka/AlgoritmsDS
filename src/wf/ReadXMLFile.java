package wf;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/*https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/*/
public class ReadXMLFile {
    
    public static void main(String argv[]) {
        
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            String text = "<?xml version=\"1.0\"?>\n" +
                              "<company>\n" +
                              "    <staff id=\"1001\">\n" +
                              "        <firstname>yong</firstname>\n" +
                              "        <lastname>mook kim</lastname>\n" +
                              "        <nickname>mkyong</nickname>\n" +
                              "        <salary>100000</salary>\n" +
                              "    </staff>\n" +
                              "    <staff id=\"2001\">\n" +
                              "        <firstname>low</firstname>\n" +
                              "        <lastname>yin fong</lastname>\n" +
                              "        <nickname>fong fong</nickname>\n" +
                              "        <salary>200000</salary>\n" +
                              "    </staff>\n" +
                              "</company>";
            InputStream inputStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
            Document doc = dBuilder.parse(inputStream);
            
            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            
            NodeList nList = doc.getElementsByTagName("staff");
            
            System.out.println("----------------------------");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                
                Node nNode = nList.item(temp);
                
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element eElement = (Element) nNode;
                    
                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}