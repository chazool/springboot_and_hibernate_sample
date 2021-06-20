package com.chazool.sample.customerservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Response {

    private Object data;
    private Status status;
    private boolean action;

    private enum Status {
        SUCCESS, FAIL
    }

    private Response(Status status, boolean action, Object data) {
        this.status = status;
        this.action = action;
        this.data = data;
    }

    public static Response success(Object data) {
        return new Response(Status.SUCCESS, true, data);
    }

    public static Response fail(Object data) {
        return new Response(Status.FAIL, false, data);
    }

}
