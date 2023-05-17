package homework.infra;

import homework.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class StoreHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Store>> {

    @Override
    public EntityModel<Store> process(EntityModel<Store> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/accept")
                .withRel("accept")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/reject")
                .withRel("reject")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/startcooking")
                .withRel("startcooking")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/endcooking")
                .withRel("endcooking")
        );

        return model;
    }
}
