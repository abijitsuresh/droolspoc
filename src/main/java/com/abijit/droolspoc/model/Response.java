package com.abijit.droolspoc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Integer value;
    private SubResponse subResponse;

    public void setSubResponse(int subResponseValue) {
        var subResponse1 = new SubResponse();
        subResponse1.setSubValue(subResponseValue);
        this.subResponse = subResponse1;
    }
}
