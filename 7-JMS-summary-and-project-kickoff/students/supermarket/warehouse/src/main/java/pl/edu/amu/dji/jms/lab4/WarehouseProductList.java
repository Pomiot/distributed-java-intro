package pl.edu.amu.dji.jms.lab4;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import pl.edu.amu.dji.jms.lab4.Service.ProductsListService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Tomasz on 2015-01-06.
 */
public class WarehouseProductList {

    private ArrayList<Item> productList;

    public WarehouseProductList(){
        generateProductList();
    }

    public ArrayList<Item> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Item> productList) {
        this.productList = productList;
    }

    public void addItemToList(Item item){
        productList.add(item);
        sendList();
    }

    private void generateProductList(){
        productList = new ArrayList<Item>();
        productList.add(new Item("Papuga",12.4));
        productList.add(new Item("Wiertarka",33.9));
        productList.add(new Item("Gramofon",99.99));
    }

    public void displayProductList(){
        System.out.println("Current product list:");
        for(Item item : productList){
            System.out.println("Name: "+item.getName() + " Price: "+item.getPrice());
        }
    }

    private void changeItemPrice(String itemName, Double newPrice){
        for(Item i : productList){
            if(i.getName().equals(itemName)){
                i.setPrice(newPrice);
            }
        }
        sendList();
    }

    public void changeItemPriceInterface(){

        Double newPrice = new Double(0);
        String itemName = "";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of item which price is to be changed:");
        try {
            itemName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("What the hell did you just enter?");
            return;
        }
        System.out.println("Enter name of item which price is to be changed:");
        try {
            newPrice = Double.parseDouble(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("What the hell did you just enter?");
            return;
        }

        changeItemPrice(itemName, newPrice);
        System.out.println(itemName+" price changed to "+newPrice);

    }

    public void addItemToListInterface(){

        Double price = new Double(0);
        String itemName = "";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of item you want to add:");
        try {
            itemName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("What the hell did you just enter?");
            return;
        }
        System.out.println("Enter price for "+itemName+":");
        try {
            price = Double.parseDouble(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("What the hell did you just enter?");
            return;
        }

        addItemToList(new Item(itemName,price));
        System.out.println(itemName+" with price "+price+"added to list");
    }

    public void sendList(){
        ApplicationContext context = new ClassPathXmlApplicationContext("Context.xml");
        ProductsListService productsListService = (ProductsListService) context.getBean("productsListService");
        productsListService.sendProductList(productList);
    }
}
