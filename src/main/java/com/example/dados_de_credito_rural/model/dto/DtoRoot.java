package com.example.dados_de_credito_rural.model.dto;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class DtoRoot {
    private List<InvestMunicipiosList> value;
}
