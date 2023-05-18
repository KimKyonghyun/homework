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

    private Integer qty;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        //DeliveryRequested deliveryRequested = new DeliveryRequested(this);
        //deliveryRequested.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void startDelivery() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.setOrderStatus("Delivery Started");
        deliveryStarted.publishAfterCommit();
    }

    public void completeDelivery() {
        DeliveryEnded deliveryEnded = new DeliveryEnded(this);
        deliveryEnded.setOrderStatus("Delivery Completed");
        deliveryEnded.publishAfterCommit();
    }

    public static void searchDelivery(CookingEnded cookingEnded) {
        // Example 1:  new item 
        Delivery delivery = new Delivery();
        delivery.setUserId(cookingEnded.getUserId());
        delivery.setUserName(cookingEnded.getUserName());
        delivery.setUserAddr(cookingEnded.getUserAddr());
        delivery.setStoreId(cookingEnded.getStoreId());
        delivery.setMenuId(cookingEnded.getMenuId());
        delivery.setMenuName(cookingEnded.getMenuName());
        delivery.setQty(cookingEnded.getQty());
        delivery.setOrderStatus("Delivery Started");
        repository().save(delivery);

        DeliveryRequested deliveryRequested = new DeliveryRequested(delivery);
        deliveryRequested.publishAfterCommit();
        

        /** Example 2:  finding and process
        
        repository().findById(cookingEnded.getId()).ifPresent(delivery->{
            
            delivery.setOrderStatus("Delivery Started"); // do something
            repository().save(delivery);

            DeliveryRequested deliveryRequested = new DeliveryRequested(delivery);
            deliveryRequested.publishAfterCommit();

         });
        */

    }
}
