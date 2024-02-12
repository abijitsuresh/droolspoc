package com.abijit.droolspoc.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SubResponseTest {
    @Test
    void testSubResponse() {
        var subResponse = new SubResponse();
        subResponse.setSubValue(0);
        subResponse.setText("text");

        assertEquals(0, subResponse.getSubValue());
        assertEquals("text", subResponse.getText());
        assertNotNull(subResponse.toString());
    }
}