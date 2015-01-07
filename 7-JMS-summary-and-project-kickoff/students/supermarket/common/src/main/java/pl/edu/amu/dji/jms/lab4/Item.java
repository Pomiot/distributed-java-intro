package pl.edu.amu.dji.jms.lab4;

import java.io.Serializable;

/**
 * Created by Tomasz on 2015-01-06.
 */
public class Item implements Serializable {

    private final String name;
    private Double price;

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
