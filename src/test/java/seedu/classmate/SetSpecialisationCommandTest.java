package seedu.classmate;
import seedu.classmate.commands.SetSpecialisationCommand;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetSpecialisationCommandTest {

    private static final String TEST_MODULES_FILE = "data/testModules.txt";
    private static final String TEST_SPECS_FILE = "data/testSpecs.txt";

    private Major major;
    private SpecialisationOverview specOverview;
    private Ui ui;
    private Storage storage;
    private UserProfile userProfile;

    @BeforeEach
    public void setUp() {
        // Initialize dummy curriculum data
        major = new Major(new ArrayList<>());
        specOverview = new SpecialisationOverview(new HashMap<>());
        ui = new Ui();

        // Initialize test storage and empty profile
        storage = new Storage(TEST_MODULES_FILE, TEST_SPECS_FILE);
        userProfile = new UserProfile(new ArrayList<>(), new ArrayList<>());
    }

    @AfterEach
    void cleanup() {
        // Delete test files after each run so tests don't interfere with each other
        new File(TEST_MODULES_FILE).delete();
        new File(TEST_SPECS_FILE).delete();
    }

    // Boundary values: 0, 1, 2, 3

    // Test if user can successfully add one specialisation
    @Test
    void execute_validSpecialisation_addsSuccessfully() {
        SetSpecialisationCommand cmd = new SetSpecialisationCommand("Robotics", userProfile, storage);

        assertDoesNotThrow(() -> cmd.executeCommand(major, ui, specOverview));

        ArrayList<String> specs = userProfile.getUserSpecialisations();
        assertEquals(1, specs.size());
        assertTrue(specs.contains("Robotics"));
    }

    // Test if user can successfully add two specialisations
    @Test
    void execute_twoValidSpecialisations_addsBothSuccessfully() {
        SetSpecialisationCommand cmd1 = new SetSpecialisationCommand("Robotics", userProfile, storage);
        SetSpecialisationCommand cmd2 = new SetSpecialisationCommand("Internet of Things", userProfile, storage);

        assertDoesNotThrow(() -> {
            cmd1.executeCommand(major, ui, specOverview);
            cmd2.executeCommand(major, ui, specOverview);
        });

        ArrayList<String> specs = userProfile.getUserSpecialisations();
        assertEquals(2, specs.size());
        assertTrue(specs.contains("Robotics"));
        assertTrue(specs.contains("Internet of Things"));
    }

}
