package homework.domain;

import homework.domain.*;
import homework.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryRequested extends AbstractEvent {

    private Long id;
    private String storeId;
    private String userId;
    private String userName;
    private String menuId;
    private String menuName;
    private String orderStatus;
    private String userAddr;

    public DeliveryRequested(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryRequested() {
        super();
    }
}
