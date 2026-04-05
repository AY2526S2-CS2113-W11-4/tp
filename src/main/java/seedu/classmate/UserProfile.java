package seedu.classmate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserProfile {
    // @@author Michael-coding06
    private static final int MAX_SPECIALISATIONS = 2;

    // User data to be loaded from txt files via Storage
    // and initialised into ArrayLists
    private ArrayList<String> userCompletedModules;
    private ArrayList<String> userSpecialisations;
    private static final String MODULES_PATH = "data/completedModules.txt";
    private static final String SPEC_PATH = "data/specialization.txt";

    public UserProfile(ArrayList<String> loadedModules, ArrayList<String> loadedSpecs) {
        this.userCompletedModules = loadedModules != null ? loadedModules : new ArrayList<>();
        this.userSpecialisations = loadedSpecs != null ? loadedSpecs : new ArrayList<>();
    }

    /*
     * SECTION: Methods to deal with user's completedModules
     */
    public ArrayList<String> getUserCompletedModules() {
        return userCompletedModules;
    }

    public void markModuleDone(String moduleCode) throws ClassMateException {
        String code = moduleCode.toUpperCase();
        if (userCompletedModules.contains(code)) {
            throw new ClassMateException("Module " + code + " is already marked as completed!");
        }
        userCompletedModules.add(code);
    }

    /*
     * SECTION: Methods to deal with user's specialisations
     */
    public ArrayList<String> getUserSpecialisations() {
        return userSpecialisations;
    }

    public void addSpecialisation(String specName) throws ClassMateException {
        if (userSpecialisations.size() >= MAX_SPECIALISATIONS) {
            throw new ClassMateException("You can only select up to " + MAX_SPECIALISATIONS + " specialisations.");
        }
        if (userSpecialisations.contains(specName)) {
            throw new ClassMateException("You have already selected this specialisation.");
        }
        userSpecialisations.add(specName);
    }
    // @@author
//
//    private void loadData() {
//        File specFile = new File(SPEC_PATH);
//        if (specFile.exists()) {
//            try (Scanner scanner = new Scanner(specFile)) {
//                if (scanner.hasNextLine()) {
//                    this.specialization = scanner.nextLine().trim();
//                }
//            } catch (IOException e) {
//                System.out.println("Could not load user's specialization.");
//            }
//        }
//
//        File modulesFile = new File(MODULES_PATH);
//        if (modulesFile.exists()) {
//            try (Scanner scanner = new Scanner(modulesFile)) {
//                while (scanner.hasNextLine()) {
//                    String module = scanner.nextLine().trim();
//                    if (!module.isEmpty()) {
//                        this.completedModules.add(module);
//                    }
//                }
//            } catch (IOException e) {
//                System.out.println("Could not load user's completed modules.");
//            }
//        }
//    }
//
//    public void setSpecialization(String newSpecialization) {
//        this.specialization = newSpecialization;
//
//        try {
//            FileWriter writer = new FileWriter(SPEC_PATH, false);
//            writer.write(newSpecialization);
//            writer.close();
//        } catch (IOException e) {
//            System.out.println("Error saving specialization.");
//        }
//    }
}
