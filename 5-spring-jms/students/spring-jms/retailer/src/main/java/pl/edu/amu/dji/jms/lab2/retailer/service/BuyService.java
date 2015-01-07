package pl.edu.amu.dji.jms.lab2.retailer.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

public class BuyService implements MessageListener {

    private JmsTemplate jmsTemplate;

    private Double maxPrice;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public void onMessage(Message message) {

        if(message instanceof MapMessage){

            MapMessage mapMessage = (MapMessage) message;
            try {
                Double price = mapMessage.getDouble("price");
                if(maxPrice.compareTo(price)==1){

                    Destination replyTo = mapMessage.getJMSReplyTo();
                    jmsTemplate.send(replyTo, new MessageCreator() {
                        @Override
                        public Message createMessage(Session session) throws JMSException {
                            MapMessage buy = session.createMapMessage();
                            buy.setString("retailerID", getClass().getName());
                            buy.setDouble("quantity",10);

                            return buy;
                        }
                    });
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
