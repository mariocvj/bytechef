package com.bytechef.component.xero.util;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;

public class XeroUtilsTest {

    @Test
    public void testGetMapFilterNull() {
        // Act
        Map<String, Object> result = XeroUtils.getMapFilterNull("key1", "value1", "key2", null, null, "value3");

        // Assert
        assertEquals(2, result.size());
        assertEquals("value1", result.get("key1"));
        assertNull(result.get("key2"));
        assertEquals("value3", result.get(null));
    }
}
