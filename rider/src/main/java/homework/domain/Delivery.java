package homework.domain;

import homework.RiderApplication;
import homework.domain.DeliveryRequested;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String storeId;

    private String userId;

    private String userName;

    private String menuId;

    private String menuName;

    private String orderStatus;

    private String userAddr;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        DeliveryRequested deliveryRequested = new DeliveryRequested(this);
        deliveryRequested.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void startDelivery() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    public void completeDelivery() {
        DeliveryEnded deliveryEnded = new DeliveryEnded(this);
        deliveryEnded.publishAfterCommit();
    }

    public static void searchDelivery(CookingEnded cookingEnded) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        DeliveryRequested deliveryRequested = new DeliveryRequested(delivery);
        deliveryRequested.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookingEnded.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            DeliveryRequested deliveryRequested = new DeliveryRequested(delivery);
            deliveryRequested.publishAfterCommit();

         });
        */

    }
}
