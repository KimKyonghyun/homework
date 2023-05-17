package homework.domain;

import homework.domain.*;
import homework.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderRejectd extends AbstractEvent {

    private Long id;
    private String orderStatus;

    public OrderRejectd(Store aggregate) {
        super(aggregate);
    }

    public OrderRejectd() {
        super();
    }
}
