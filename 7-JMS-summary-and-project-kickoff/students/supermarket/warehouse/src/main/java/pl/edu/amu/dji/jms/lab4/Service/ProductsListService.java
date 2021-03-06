package pl.edu.amu.dji.jms.lab4.Service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import pl.edu.amu.dji.jms.lab4.Item;

import javax.jms.*;
import java.util.ArrayList;

/**
 * Created by Tomasz on 2015-01-06.
 **/
public class ProductsListService {


    private JmsTemplate jmsTemplate;
    private Destination productsListTopic;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Destination getProductsListTopic() {
        return productsListTopic;
    }

    public void setProductsListTopic(Destination productsListTopic) {
        this.productsListTopic = productsListTopic;
    }

    public void sendProductList(final ArrayList<Item> items){
        jmsTemplate.send(productsListTopic, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {

                ObjectMessage message = session.createObjectMessage();
                message.setObject(items);

                return message;
            }
        });
    }
}
