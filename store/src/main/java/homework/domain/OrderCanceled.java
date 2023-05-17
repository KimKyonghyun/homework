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

    public OrderCanceled(Store aggregate) {
        super(aggregate);
    }

    public OrderCanceled() {
        super();
    }
}
