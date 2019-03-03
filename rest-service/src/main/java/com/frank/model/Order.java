package com.frank.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @ApiModelProperty(notes="This is unique order ID", required = true)
    private String id;
    @ApiModelProperty(notes="This is order amount", required = true)
    private BigDecimal amount;

}
