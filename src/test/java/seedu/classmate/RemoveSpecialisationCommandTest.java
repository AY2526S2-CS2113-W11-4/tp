package seedu.classmate;
import seedu.classmate.commands.RemoveSpecialisationCommand;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for RemoveSpecialisationCommand.
 */
public class RemoveSpecialisationCommandTest {
    private static final String TEST_MODULES_FILE = "data/testModules.txt";
    private static final String TEST_SPECS_FILE = "data/testSpecs.txt";

    private Major major;
    private SpecialisationOverview specOverview;
    private Ui ui;
    private Storage storage;
    private UserProfile userProfile;

    @BeforeEach
    public void setUp() {
        // Initialise dummy curriculum data
        major = new Major(new ArrayList<>());
        specOverview = new SpecialisationOverview(new HashMap<>());
        ui = new Ui();

        // Initialise test storage and empty profile
        storage = new Storage(TEST_MODULES_FILE, TEST_SPECS_FILE);
        userProfile = new UserProfile(new ArrayList<>(), new ArrayList<>());
    }

    @AfterEach
    void cleanup() {
        // Delete test files after each run
        new File(TEST_MODULES_FILE).delete();
        new File(TEST_SPECS_FILE).delete();
    }

    @Test
    void execute_validSpecialisation_removesSuccessfully() throws ClassMateException {
        // Add a specialisation first
        userProfile.addSpecialisation("Robotics");
        assertEquals(1, userProfile.getUserSpecialisations().size());

        // Run the remove command
        RemoveSpecialisationCommand cmd = new RemoveSpecialisationCommand("Robotics", userProfile, storage);
        assertDoesNotThrow(() -> cmd.executeCommand(major, ui, specOverview));

        // Since there was only one spec, removing the spec should make list empty
        assertTrue(userProfile.getUserSpecialisations().isEmpty());
    }
}
