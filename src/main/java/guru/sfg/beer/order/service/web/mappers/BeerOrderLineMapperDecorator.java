package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.beer.BeerService;
import guru.sfg.brewery.model.BeerDTO;
import guru.sfg.brewery.model.BeerOrderLineDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;

@Mapper
public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper{

    private BeerService beerService;
    private BeerOrderLineMapper beerOrderLineMapper;

    @Autowired
    public void setBeerService(BeerService beerService) {
        this.beerService = beerService;
    }

    @Autowired
    @Qualifier("delegate")
    public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
        this.beerOrderLineMapper = beerOrderLineMapper;
    }

    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        BeerOrderLineDto orderLineDto = beerOrderLineMapper.beerOrderLineToDto(line);
        Optional<BeerDTO> beerDTOOptional = beerService.getBeerByUpc(line.getUpc());

        beerDTOOptional.ifPresent(beerDTO -> {
            orderLineDto.setBeerName(beerDTO.getBeerName());
            orderLineDto.setBeerStyle(beerDTO.getBeerStyle());
            orderLineDto.setPrice(beerDTO.getPrice());
            orderLineDto.setId(beerDTO.getId());
        });
        return orderLineDto;
    }
}
