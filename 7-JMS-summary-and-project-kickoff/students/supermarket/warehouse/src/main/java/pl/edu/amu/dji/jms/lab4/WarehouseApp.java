package pl.edu.amu.dji.jms.lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.jms.JMSException;

public class WarehouseApp {

    private static WarehouseProductList warehouseProductList = new WarehouseProductList();

    public static void main(String[] args) throws JMSException, IOException {

        boolean isRunning=true;

        System.out.println("*** Warehouse System up and running ***");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(isRunning){
            System.out.println("Enter number to pick command:");
            System.out.println("1: Send product information to PoS'");
            System.out.println("2: Display current item list");
            System.out.println("3: Change item price");
            System.out.println("4: Add item to list");
            System.out.println("0: Quit");

            int choice = Integer.parseInt(reader.readLine());
            switch(choice){
                case 0:{
                    isRunning= false;
                    break;
                }
                case 1:{
                    warehouseProductList.sendList();
                    break;
                }
                case 2:{
                    warehouseProductList.displayProductList();
                    break;
                }
                case 3:{

                    warehouseProductList.changeItemPriceInterface();
                    break;
                }
                case 4:{

                    warehouseProductList.addItemToListInterface();
                    break;
                }
                default:{
                    System.out.println("Wrong command.");
                    break;
                }
            }

        }

    }
}