package homework.domain;

import homework.domain.*;
import homework.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    private Long id;
    private String orderStatus;

    public OrderAccepted(Store aggregate) {
        super(aggregate);
    }

    public OrderAccepted() {
        super();
    }
}
