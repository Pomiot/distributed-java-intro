package pl.edu.amu.dji.jms.lab2.wholesaler.service.message;

import com.google.common.base.Preconditions;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Tomasz on 2015-01-06.
 */
@Component("offerConverter")
public class OfferConverter implements MessageConverter{


    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        Preconditions.checkArgument(object instanceof Offer);

        Offer offer = (Offer) object;

        MapMessage mapMessage = session.createMapMessage();
        mapMessage.setDouble("price",offer.getPrice());
        mapMessage.setJMSDestination(offer.getReplyTo());
        System.out.println("Reply to: "+offer.getReplyTo());

        return mapMessage;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        throw new UnsupportedOperationException();
    }
}