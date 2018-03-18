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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/*https://www.testdome.com/d/java-interview-questions/4 #5*/
public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        Document doc = builder.parse(inputStream);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("folder");
        Set<String> map = new HashSet<>();
        for (int nodeInd = 0; nodeInd < nList.getLength(); nodeInd++) {
            Node nNode = nList.item(nodeInd);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                String folderName = element.getAttribute("name");
                if (folderName.charAt(0) == startingLetter) {
                    map.add(folderName);
                }
            }
        }
        return map;
    }
    
    public static void main(String[] args) throws Exception {
        String xml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                "<folder name=\"program files\">" +
                "<folder name=\"uninstall information\" />" +
                "</folder>" +
                "<folder name=\"users\" />" +
                "</folder>";
        
        Collection<String> names = folderNames(xml, 'u');
        for (String name : names) {
            System.out.println(name);
        }
    }
}