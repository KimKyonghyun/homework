package homework.domain;

import homework.domain.*;
import homework.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingEnded extends AbstractEvent {

    private Long id;
    private String orderStatus;
}
