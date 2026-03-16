package seedu.classmate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Contains unit tests for the Parser class.
 * Tests whether user input is correctly parsed into Command objects,
 * such as valid commands and invalid or empty inputs.
 */
class ParserTest {

    @Test
    public void testHelpCommand() {
        String result = Parser.parseCommand("help");

        assertEquals("Viewing help", result);
    }

    @Test
    public void testViewGradReqCommand() {
        String result = Parser.parseCommand("viewGradReq");

        assertEquals("Print CEG graduation requirements", result);
    }

    @Test
    public void testEmptyCommand() {
        String result = Parser.parseCommand("");
        assertEquals("Unknown Command. Enter 'help' for available commands.", result);
    }
}
