package homework.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import homework.config.kafka.KafkaProcessor;
import homework.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingEnded'"
    )
    public void wheneverCookingEnded_SearchDelivery(
        @Payload CookingEnded cookingEnded
    ) {
        CookingEnded event = cookingEnded;
        System.out.println(
            "\n\n##### listener SearchDelivery : " + cookingEnded + "\n\n"
        );

        // Sample Logic //
        Delivery.searchDelivery(event);
    }
}
