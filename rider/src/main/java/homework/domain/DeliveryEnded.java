package homework.domain;

import homework.domain.*;
import homework.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryEnded extends AbstractEvent {

    private Long id;
    private String orderStatus;

    public DeliveryEnded(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryEnded() {
        super();
    }
}
