package pl.edu.amu.dji.jms.lab4.analysis.service;

import com.google.common.base.Preconditions;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by Tomasz on 2015-01-06.
 **/
public class AnalysisService implements MessageListener {

    @Override
    public void onMessage(Message message) {

        Preconditions.checkArgument(message instanceof MapMessage);

        MapMessage mapMessage = (MapMessage) message;

        try {
            String itemName = mapMessage.getString("name");
            Integer quantity = mapMessage.getInt("quantity");
            Double price = mapMessage.getDouble("price");

            System.out.println("Sold "+quantity+" "+itemName+"(s) for "+(price*quantity));

        } catch (JMSException e) {
            e.printStackTrace();
        }




    }
}
