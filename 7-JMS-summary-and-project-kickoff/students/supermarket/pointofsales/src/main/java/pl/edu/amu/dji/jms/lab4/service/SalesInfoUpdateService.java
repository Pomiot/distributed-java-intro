package pl.edu.amu.dji.jms.lab4.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * Created by Tomasz on 2015-01-07.
 **/
public class SalesInfoUpdateService {

    private JmsTemplate jmsTemplate;
    private Destination analysisQueue;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Destination getAnalysisQueue() {
        return analysisQueue;
    }

    public void setAnalysisQueue(Destination analysisQueue) {
        this.analysisQueue = analysisQueue;
    }

    public void sendSalesInfo(final String itemName, final Integer quantity, final Double price){
        jmsTemplate.send(analysisQueue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                MapMessage message = session.createMapMessage();
                message.setString("name",itemName);
                message.setInt("quantity",quantity);
                message.setDouble("price",price);

                return message;
            }
        });
    }



}
