package homework.domain;

import homework.domain.*;
import homework.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingStarted extends AbstractEvent {

    private Long id;
    private String orderStatus;

    public CookingStarted(Store aggregate) {
        super(aggregate);
    }

    public CookingStarted() {
        super();
    }
}
