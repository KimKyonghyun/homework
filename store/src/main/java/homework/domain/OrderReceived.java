package homework.domain;

import homework.domain.*;
import homework.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderReceived extends AbstractEvent {

    private Long id;
    private String storeId;
    private String menuId;
    private String menuName;
    private Integer qty;
    private String userId;
    private String userName;
    private String userAddr;
    private String orderStatus;

    public OrderReceived(Store aggregate) {
        super(aggregate);
    }

    public OrderReceived() {
        super();
    }
}
