package guru.sfg.beer.order.service.services.beer;

import guru.sfg.brewery.model.BeerDTO;

import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<BeerDTO> getBeerById(UUID beerId);

    Optional<BeerDTO> getBeerByUpc(String upc);
}
