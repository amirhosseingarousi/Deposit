package ir.dotin;

import ir.dotin.deposit.Deposit;
import ir.dotin.deposit.DepositFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

//        Deposit qarze = DepositFactory.createDeposit("48483", "Qarz", new BigDecimal("145000"), 38);
//        Deposit shortTerm = DepositFactory.createDeposit("534900", "ShortTerm", new BigDecimal("200000"), 25);
//        Deposit longTerm = DepositFactory.createDeposit("658951", "LongTerm", new BigDecimal("545966600000"), 1000);

//        System.out.println(qarze);
//        System.out.println(shortTerm);
//        System.out.println(longTerm);

        File file = new File("src\\ir\\dotin\\deposits.xml");
        NodeList nodeList = readXMLFile(file);

        List<Deposit> deposits = createDepositObject(nodeList);
        createOutputFile(deposits);
    }

    private static void createOutputFile(List<Deposit> deposits) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (Deposit deposit : deposits) {
                String customerNumber = deposit.getCustomerNumber();
                double payedInterest = deposit.calcPayedInterest();
                writer.write("\n" + customerNumber + "#" + payedInterest);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static List createDepositObject(NodeList nodeList) {
        List<Deposit> deposits = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;

            String number = element.getElementsByTagName("customerNumber").item(0).getTextContent();
            String type = element.getElementsByTagName("depositType").item(0).getTextContent();
            BigDecimal balance = new BigDecimal(element.getElementsByTagName("depositBalance").item(0).getTextContent());
            int days = Integer.parseInt(element.getElementsByTagName("durationInDays").item(0).getTextContent());

            Deposit deposit = DepositFactory.createDeposit(number, type, balance, days);
            deposits.add(deposit);
        }
        return deposits;
    }

    private static NodeList readXMLFile(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName("deposit");
    }

}
