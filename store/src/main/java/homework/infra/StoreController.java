package homework.infra;

import homework.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/stores")
@Transactional
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @RequestMapping(
        value = "stores/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store accept(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/accept  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.accept();

        storeRepository.save(store);
        return store;
    }

    @RequestMapping(
        value = "stores/{id}/reject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store reject(
        @PathVariable(value = "id") Long id,
        @RequestBody RejectCommand rejectCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/reject  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.reject(rejectCommand);

        storeRepository.save(store);
        return store;
    }

    @RequestMapping(
        value = "stores/{id}/startcooking",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store startCooking(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/startCooking  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.startCooking();

        storeRepository.save(store);
        return store;
    }

    @RequestMapping(
        value = "stores/{id}/endcooking",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store endCooking(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/endCooking  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.endCooking();

        storeRepository.save(store);
        return store;
    }
}
