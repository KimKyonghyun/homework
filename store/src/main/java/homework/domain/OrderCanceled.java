package homework.domain;

import homework.domain.*;
import homework.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private String orderStatus;
    private String storeId;
    private String menuId;
    private String menuName;
    private Integer qty;
    private String userId;
    private String userName;
    private String userAddr;

    public OrderCanceled(Store aggregate) {
        super(aggregate);
    }

    public OrderCanceled() {
        super();
    }
}
