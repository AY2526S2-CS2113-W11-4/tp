package seedu.classmate.commands;

import seedu.classmate.Major;
import seedu.classmate.SpecialisationOverview;
import seedu.classmate.Ui;

/**
 * Represents a Command that terminates the program after displaying a goodbye message.
 */
public class ByeCommand extends Command {

    public static Ui ui;
    boolean isExit = false;

    public ByeCommand() {
        isExit = true;
    }

    /**
     * Displays the goodbye message to the user.
     *
     * @param major The {@code Major} instance (unused).
     * @param ui The {@code Ui} handler used to show messages.
     * @param specialisationOverview The overview of specialisations (unused).
     */
    @Override
    public void executeCommand(Major major, Ui ui, SpecialisationOverview specialisationOverview) {
        ui.showGoodbye();
    }
}
