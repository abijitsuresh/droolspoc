package com.abijit.droolspoc.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SubResponseTest {
    @Test
    void testSubResponse() {
        var subResponse = new SubResponse();
        subResponse.setSubValue(0);

        assertEquals(0, subResponse.getSubValue());
        assertNotNull(subResponse.toString());
    }
}