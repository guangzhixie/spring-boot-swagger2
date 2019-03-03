package com.frank.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {
    @ApiModelProperty(notes="This is return code", required = true)
    private String retCode;
    @ApiModelProperty(notes="This is return message", required = true)
    private String retMessage;
}
