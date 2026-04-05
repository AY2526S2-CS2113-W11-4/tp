package seedu.classmate.commands;

import seedu.classmate.Major;
import seedu.classmate.Module;
import seedu.classmate.SpecialisationOverview;
import seedu.classmate.Ui;
import seedu.classmate.UserProfile;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Represents a command that displays the user's academic profile.
 * This includes their selected specialization and a list of completed modules.
 */
public class CheckProfileCommand extends Command {

    // @@author Michael-coding06
    private static final Logger logger = Logger.getLogger(CheckProfileCommand.class.getName());
    private final UserProfile userProfile;

    /**
     * Constructs a {@code CheckProfileCommand} with the user's profile.
     *
     * @param userProfile The UserProfile object holding the state of academic progress.
     */
    public CheckProfileCommand(UserProfile userProfile) {
        assert userProfile != null : "UserProfile should not be null";
        this.userProfile = userProfile;
    }

    /**
     * Executes the command by printing the user's specialization and completed modules.
     *
     * @param major                   The Major instance (unused).
     * @param ui                      The Ui handler.
     * @param specialisationOverview  The overview of specialisations (unused).
     */
    @Override
    public void executeCommand(Major major, Ui ui, SpecialisationOverview specialisationOverview) {
        logger.info("Executing CheckProfileCommand");
    // @@author

        // @@author lauwn-mower
        /*
         * Review CheckProfile command:
         * command to additionally show a list of uncompleted modules.
         * implementation: import CEG module list from major.getCoreModules()
         *                 create new ArrayList of incomplete modules
         *                  create a progress tracker via Ui
         *                  pass in userprofile, remaining major and remaining spec modules
         *                  for spec elective modules, tell user how many completed
         *                      and show options as to what else they can do
         */

        // settle completed major modules first
        ArrayList<String> completedModules = userProfile.getUserCompletedModules();

        // calculate remaining modules
        ArrayList<Module> remainingMajorCore = new ArrayList<>();
        for (seedu.classmate.Module m : major.getCoreModules()) {
            if (!completedModules.contains(m.getModuleCode())) {
                remainingMajorCore.add(m);
            }
        }

        // TODO: delegate to ui to generate basic acad profile
//        System.out.println("Your Academic Profile:");
//        Ui.printLine();

        // settle spec modules
        // first check if spec is empty
        // else, show specs and modules yet to complete
        ArrayList<String> userSpecialisations = userProfile.getUserSpecialisations();
//        System.out.println("Specialisation: " + userSpecialisations);
//
//        System.out.println("Completed Modules:");
//        if (completedModules.isEmpty()) {
//            System.out.println("  - No modules marked as completed yet.");
//        } else {
//            for (String moduleCode : completedModules) {
//                System.out.println("  [DONE] " + moduleCode);
//            }
//        }
//
//        Ui.printLine();
//        System.out.println("Keep up the great work!");
    }

    // @@author
}
