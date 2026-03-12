package seedu.classmate;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Represents the CEG specialisation details.
 */
public class Specialisation {

    private String specialisationName;
    private ArrayList<Module> specialisationCoreModules;
    private ArrayList<Module> specialisationElectiveModules;
    private String electiveRequirements;


    public Specialisation(String name) {
        this.specialisationName = name;
        this.specialisationCoreModules = new ArrayList<>();
        this.specialisationElectiveModules = new ArrayList<>();
        setupCEGSpecialisationModules();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(specialisationName);

        if (!specialisationCoreModules.isEmpty()) {
            sb.append("Core Specialisation Modules:\n");
            sb.append(specialisationCoreModules.stream()
            .map(Module::toString).collect(Collectors.joining("\n")));

            sb.append("\n\n");
        }

        sb.append("Elective Modules (").append(electiveRequirements).append(")\n");

        sb.append(specialisationElectiveModules.stream()
                .map(Module::toString).collect(Collectors.joining("\n")));

        return sb.toString();
    }

    private void setupCEGSpecialisationModules() {
        switch (specialisationName) {
        case "Internet-Of-Things":
            electiveRequirements = "Choose any two courses, or totaling at least 8 units, from the list below:";
            specialisationCoreModules.add(new Module("CS3237", "Introduction to Internet of Things"));
            specialisationCoreModules.add(new Module("EE4211", "Data Science for the Internet of Things"));
            specialisationCoreModules.add(new Module("EE4409", "Modern Microelectronics Devices and Sensors"));

            specialisationElectiveModules.add(new Module("CG4002", "Computer Engineering Capstone Project"));
            specialisationElectiveModules.add(new Module("CS4222", "Wireless Networking"));
            specialisationElectiveModules.add(new Module("EE4204", "Computer Networks"));
            specialisationElectiveModules.add(new Module("EE4216", "Hardware for Internet of Things"));
            specialisationElectiveModules.add(new Module("EE4218", "Embedded Hardware System Design"));
            specialisationElectiveModules.add(new Module("CS3244", "Machine Learning"));
            specialisationElectiveModules.add(new Module("EE4002D/R", "Design/Research Capstone"));
            specialisationElectiveModules.add(new Module("CP4106", "Computing Project - IOT related"));
            break;

        case "Advanced Electronics":
            electiveRequirements = "Choose any three courses, or totaling at least 12 units, from the list below:";
            specialisationCoreModules.add(new Module("EE3408C", "Integrated Analog Design"));
            specialisationCoreModules.add(new Module("EE4211", "Microelectronic Materials and Devices"));

            specialisationElectiveModules.add(new Module("EE4218", "Embedded Hardware System Design"));
            specialisationElectiveModules.add(new Module("EE4407", "Analog Electronics"));
            specialisationElectiveModules.add(new Module("EE4415", "Integrated Digital Design"));
            specialisationElectiveModules.add(new Module("EE5507", "Analog IC Design"));
            specialisationElectiveModules.add(new Module("CG3207", "Computer Architecture"));
            specialisationElectiveModules.add(new Module("EE4409", "Modern Microelectronics Devices and Sensors"));
            specialisationElectiveModules.add(new Module("EE4435", "Modern Transistors and Memory Devices"));
            specialisationElectiveModules.add(new Module("EE4436", "Fabrication Process Technology"));
            specialisationElectiveModules.add(new Module("EE4437", "Photonics - Principles and Applications"));
            specialisationElectiveModules.add(new Module("EE4438", "Solar Cells and Modules"));
            break;

        case "Space Technology":
            electiveRequirements = "Choose any two courses, or totaling at least 8 units, from the list below:";
            specialisationCoreModules.add(new Module("EE3105", "Beyond Sky - New Space Technology and Application"));
            specialisationCoreModules.add(new Module("EE4002D/R", "Design/Research Capstone on satellite related project"));

            specialisationElectiveModules.add(new Module("EE3131C", "Communication Systems"));
            specialisationElectiveModules.add(new Module("EE3104C", "Introduction to RF and Microwave Systems"));
            specialisationElectiveModules.add(new Module("EE3331C", "Feedback Control Systems"));
            specialisationElectiveModules.add(new Module("EE4115", "Remote Sensing and Analysis with Deep Learning Technique"));
            specialisationElectiveModules.add(new Module("EE4218", "Embedded Hardware System Design"));
            specialisationElectiveModules.add(new Module("EE4314", "Eyes from above: Guidance, Navigation and Control"));
            specialisationElectiveModules.add(new Module("EE4503", "Power Electronics for Sustainable Energy Technologies"));
            specialisationElectiveModules.add(new Module("EE4101", "RF Communications"));
            break;
        case "Industry 4.0":
            electiveRequirements = "Choose any three courses, or totaling at least 12 units, from the list below:";
            specialisationCoreModules.add(new Module("EE3331C/ME2142/ME3142", "Feedback Control Systems"));
            specialisationCoreModules.add(new Module("EE3306/ME3163", "Introduction to Cyber Physical Systems"));

            specialisationElectiveModules.add(new Module("EE4211", "Data Science for the Internet of Things"));
            specialisationElectiveModules.add(new Module("CS4212", "Computer Vision"));
            specialisationElectiveModules.add(new Module("EE4302", "Advanced Control Systems"));
            specialisationElectiveModules.add(new Module("EE4307", "Control System Design and Simulation"));
            specialisationElectiveModules.add(new Module("EE4311", "Fuzzy Logic and Neuro Fuzzy Systems"));
            specialisationElectiveModules.add(new Module("EE4312", "Artificial Neural Networks"));
            specialisationElectiveModules.add(new Module("EE4314", "Eyes from above: Guidance, Navigation and Control"));
            specialisationElectiveModules.add(new Module("EE4315", "Intelligent Industrial Control Systems"));
            specialisationElectiveModules.add(new Module("ME3242", "Automation"));
            specialisationElectiveModules.add(new Module("ME4262", "Automation in Manufacturing"));
            specialisationElectiveModules.add(new Module("ME4248", "Manufacturing Simulation and Data Communication"));
            specialisationElectiveModules.add(new Module("ME4246", "Modern Control System"));
            specialisationElectiveModules.add(new Module("ME5405", "Machine Vision"));
            specialisationElectiveModules.add(new Module("CN4227R", "Advanced Process Control"));
            specialisationElectiveModules.add(new Module("CN4221R", "Control of Industrial Processes"));
            specialisationElectiveModules.add(new Module("RB4301", "Robot Learning"));
            break;

        case "Robotics":
            electiveRequirements = "12 Units from electives AND a Capstone (8 Units) in Robotics OR, 20 Units from electives:";

            specialisationElectiveModules.add(new Module("BN3203", "Robotics in Rehabilitation"));
            specialisationElectiveModules.add(new Module("BN4207", "Microrobotics"));
            specialisationElectiveModules.add(new Module("BN4601", "Intelligent Medical Robotics"));
            specialisationElectiveModules.add(new Module("EE3305/ME3243", "Robotic System Design"));
            specialisationElectiveModules.add(new Module("EE4115", "Remote Sensing & Analysis with Deep Learning Technique"));
            specialisationElectiveModules.add(new Module("EE4305", "Fuzzy/Neural Systems for Intelligent Robotics"));
            specialisationElectiveModules.add(new Module("EE4308", "Autonomous Robot Systems"));
            specialisationElectiveModules.add(new Module("EE4309", "Robot Perception"));
            specialisationElectiveModules.add(new Module("EE4311", "Fuzzy Logic and Neuro Fuzzy Systems"));
            specialisationElectiveModules.add(new Module("EE4312", "Artificial Neural Networks"));
            specialisationElectiveModules.add(new Module("EE4314", "Eyes from above: Guidance, Navigation and Control"));
            specialisationElectiveModules.add(new Module("EE4705", "Human-Robot Interaction"));
            specialisationElectiveModules.add(new Module("ME2143", "Sensors and Actuators"));
            specialisationElectiveModules.add(new Module("ME4242", "Soft Robotics"));
            specialisationElectiveModules.add(new Module("ME4245", "Robot Mechanics and Control"));
            specialisationElectiveModules.add(new Module("ME5406", "Deep Learning for Robotics"));
            specialisationElectiveModules.add(new Module("MLE4228", "Materials for Robotic Sensing and Actuation"));
            specialisationElectiveModules.add(new Module("RB4301", "Robot Learning"));
            break;

        default:
            throw new ClassMateException("This is not a CEG specialisation");
        }
    }
}
