package com.abijit.droolspoc.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ConstantsTest {
    @Test
    void testConstants() {
        assertThrows(UnsupportedOperationException.class, Constants::new);
    }
}