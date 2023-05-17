package homework.domain;

import homework.domain.*;
import homework.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userId;
    private String userName;
    private String userAddr;
    private String storeId;
    private String menuId;
    private Integer qty;
    private String menuName;
    private String orderStatus;
}
