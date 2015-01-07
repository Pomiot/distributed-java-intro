package pl.edu.amu.dji.jms.lab4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import pl.edu.amu.dji.jms.lab4.service.SalesInfoUpdateService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Tomasz on 2015-01-06.
 **/

public class PosProductList implements ApplicationContextAware {

    ApplicationContext context;

    private ArrayList<Item> productList = null;

    public ArrayList<Item> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Item> newProductList) {
        this.productList = newProductList;
    }

    public void makeSale(String itemName, Integer quantity, Double price){

        SalesInfoUpdateService salesInfoUpdateService = (SalesInfoUpdateService) context.getBean("salesInfoUpdateService");
        salesInfoUpdateService.sendSalesInfo(itemName,quantity,price);
    }

    public void makeSaleInterface(){

        if(productList == null){
            System.out.println("No current item list\n");
            return;
        }

        Integer quantity = new Integer(0);
        String itemName = "";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name of item you want to sell:");
        try {
            itemName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("What the hell did you just enter?");
            return;
        }
        System.out.println("Enter quantity for "+itemName+":");
        try {
            quantity = Integer.parseInt(bufferedReader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("What the hell did you just enter?");
            return;
        }

        Item itemToBeSold = getItemFromList(itemName);

        makeSale(itemToBeSold.getName(),quantity, itemToBeSold.getPrice());
        System.out.println("Sold "+ itemToBeSold.getName() +" x"+quantity+ " for "+(quantity*itemToBeSold.getPrice())+"\n");
    }

    private Item getItemFromList(String name){

        Item item = null;
        for(Item i : productList){
            if(i.getName().equals(name)){
                item = i;
            }
        }
        return item;
    }

    public void displayProductList(){
        if(productList == null){
            System.out.println("No current item list\n");
            return;
        }
        System.out.println("Current product list:\n");
        for(Item item : productList){
            System.out.println("Name: "+item.getName() + " Price: "+item.getPrice());
        }
        System.out.println();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=applicationContext;
    }
}
