package pl.edu.amu.dji.jms.lab4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.JMSException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PointOfSalesApp {
    public static void main(String[] args) throws JMSException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("Context.xml");
        boolean isRunning = true;

        System.out.println("*** Point of Sales System up and running ***");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PosProductList posProductList = (PosProductList) context.getBean("posProductList");

        while (isRunning) {
            System.out.println("Enter number to pick command:");
            System.out.println("1: Make Sale");
            System.out.println("2: Display current item list");
            System.out.println("0: Quit");

            int choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 0: {
                    isRunning = false;
                    break;
                }
                case 1: {
                    posProductList.makeSaleInterface();
                    break;
                }
                case 2: {
                    posProductList.displayProductList();
                    break;
                }
                default: {
                    System.out.println("Wrong command.");
                    break;
                }
            }
        }
    }
}
