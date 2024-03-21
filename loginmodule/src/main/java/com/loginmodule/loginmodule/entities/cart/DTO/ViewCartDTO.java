package com.loginmodule.loginmodule.entities.cart.DTO;

import com.loginmodule.loginmodule.entities.products.DTO.ViewVariationDTO;
import lombok.Data;

@Data
public class ViewCartDTO {
    private Long quantity;
    private ViewVariationDTO variation;
    }
