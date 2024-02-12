package com.abijit.droolspoc.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ResponseTest {
    @Test
    void testResponse() {
        var response = new Response();
        response.setValue(0);
        var subResponse = new SubResponse();
        subResponse.setSubValue(0);
        subResponse.setText("text");
        response.setSubResponse(subResponse);

        assertEquals(0, response.getValue());
        assertNotNull(response.getSubResponse());
        assertEquals(0, response.getSubResponse().getSubValue());
        assertEquals("text", response.getSubResponse().getText());
        assertNotNull(response.toString());
    }
}