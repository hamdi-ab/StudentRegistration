package studentRegistration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private InputStream originalSystemIn;

    @BeforeEach
    void setUp() {
        originalSystemIn = System.in;
    }

    @Test
    void yearInput_ValidInputUndergraduate_ReturnsValidYear() {
        setInput("4");
        int result = Main.yearInput("Undergraduate");
        assertEquals(4, result);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void tearDown() {
        // Clean up resources and restore original System.in
        System.setIn(originalSystemIn);
    }
}
