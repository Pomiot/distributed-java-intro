package pl.edu.amu.dji.jms.lab4.service;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pl.edu.amu.dji.jms.lab4.Item;
import pl.edu.amu.dji.jms.lab4.PosProductList;

import javax.jms.*;
import java.util.ArrayList;

/**
 * Created by Tomasz on 2015-01-06.
 **/
public class ProductInfoUpdateService implements MessageListener {

    private PosProductList posProductList;

    public PosProductList getPosProductList() {
        return posProductList;
    }

    @Autowired
    @Qualifier("posProductList")
    public void setPosProductList(PosProductList posProductList) {
        this.posProductList = posProductList;
    }

    @Override
    public void onMessage(Message message) {
        Preconditions.checkArgument(message instanceof ObjectMessage);

        ObjectMessage objectMessage = (ObjectMessage) message;

        try {
            ArrayList<Item> list = (ArrayList<Item>) objectMessage.getObject();
            posProductList.setProductList(list);
            System.out.println("Received item list");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
