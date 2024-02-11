package com.abijit.droolspoc.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RequestTest {
    @Test
    void testRequest() {
        var request = new Request();
        request.setId(0);
        request.setName("name");

        assertEquals(0, request.getId());
        assertEquals("name", request.getName());
        assertNotNull(request.toString());
    }
}