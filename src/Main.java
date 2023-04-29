import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        extract_xml();
    }

    private static void extract_xml() {
        try {
            File inputFile = new File("src\\input2.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("book");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Book id : "
                            + eElement.getAttribute("id"));
                    System.out.println("Title : "
                            + eElement
                            .getElementsByTagName("author")
                            .item(0)
                            .getTextContent());
                    System.out.println("Genre : "
                            + eElement
                            .getElementsByTagName("genre")
                            .item(0)
                            .getTextContent());
                    System.out.println("Price : "
                            + eElement
                            .getElementsByTagName("price")
                            .item(0)
                            .getTextContent());
                    System.out.println("Publish Date : "
                            + eElement
                            .getElementsByTagName("publish_date")
                            .item(0)
                            .getTextContent());
                    System.out.println("Description : "
                            + eElement
                            .getElementsByTagName("description")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}