package guru.sfg.beer.order.service.services;

import guru.sfg.beer.order.service.domain.BeerOrder;

public interface BeerOrderManger {
    BeerOrder newBeerOrder(BeerOrder beerOrder);
}
