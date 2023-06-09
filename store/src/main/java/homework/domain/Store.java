package homework.domain;

import homework.StoreApplication;
import homework.domain.OrderCanceled;
import homework.domain.OrderReceived;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Store_table")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String storeId;

    private String menuId;

    private String menuName;

    private Integer qty;

    private String userId;

    private String userName;

    private String userAddr;

    private String orderStatus;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        //OrderReceived orderReceived = new OrderReceived(this);
        //orderReceived.publishAfterCommit();

        //OrderCanceled orderCanceled = new OrderCanceled(this);
        //orderCanceled.publishAfterCommit();
    }

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }

    public void accept() {
        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.setOrderStatus("Order Accepted");
        orderAccepted.publishAfterCommit();
    }

    public void reject(RejectCommand rejectCommand) {
        OrderRejectd orderRejectd = new OrderRejectd(this);
        orderRejectd.setOrderStatus("Order Rejected");
        orderRejectd.publishAfterCommit();
    }

    public void startCooking() {
        CookingStarted cookingStarted = new CookingStarted(this);
        cookingStarted.setOrderStatus("Cooking Started");
        cookingStarted.publishAfterCommit();
    }

    public void endCooking() {
        CookingEnded cookingEnded = new CookingEnded(this);
        cookingEnded.setOrderStatus("Cooking Ended");
        cookingEnded.publishAfterCommit();
    }

    public static void receiveOrder(OrderPlaced orderPlaced) {
        // Example 1:  new item 
        Store store = new Store();
        store.setUserId(orderPlaced.getUserId());
        store.setUserName(orderPlaced.getUserName());
        store.setUserAddr(orderPlaced.getUserAddr());
        store.setStoreId(orderPlaced.getStoreId());
        store.setMenuId(orderPlaced.getMenuId());
        store.setMenuName(orderPlaced.getMenuName());
        store.setQty(orderPlaced.getQty());
        store.setOrderStatus("Order Received");
        repository().save(store);

        OrderReceived orderReceived = new OrderReceived(store);
        orderReceived.publishAfterCommit();


        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);

            OrderReceived orderReceived = new OrderReceived(store);
            orderReceived.publishAfterCommit();

         });
        */

    }

    public static void receiveOrderCancel(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        OrderCanceled orderCanceled = new OrderCanceled(store);
        orderCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);

            OrderCanceled orderCanceled = new OrderCanceled(store);
            orderCanceled.publishAfterCommit();

         });
        */

    }
}
