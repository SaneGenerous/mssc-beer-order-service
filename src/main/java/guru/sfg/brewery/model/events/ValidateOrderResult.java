package guru.sfg.brewery.model.events;

import guru.sfg.brewery.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidateOrderResult {
    private UUID orderId;
    private Boolean isValid;
}
