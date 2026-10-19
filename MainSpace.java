package com.example.mainspacers;

import java.util.Scanner;

public class MainSpace{
    private static Scanner space = new Scanner(System.in);

    private static Mission[] missions = new Mission[100];
    private static Spacecraft[] spacecrafts = new Spacecraft[100];
    private static Resource[] resources = new Resource[100];
    private static ResearchProject[] researchProj = new ResearchProject[100];
    private static int spacecraftCount = 0;
    private static int resourceCount = 0;
    private static int missionCount = 0;
    private static int researchCount = 0;

    public static void main(String[] args){
        System.out.println("\n=+=+= SPACE AGENCY MANAGEMENT SYSTEM =+=+=");

        while (true){
            String userRole = userLogin();

            switch (userRole){
                case "Admin":
                    adminMenu();
                    break;

                case "Mission Planner":
                    manageMissionsMenu();
                    break;

                case "Spacecraft Engineer":
                    manageSpacecraftMenu();
                    break;

                case "Resource Manager":
                    manageResourcesMenu();
                    break;

                case "Scientist/Researcher":
                    manageResearchProjsMenu();
                    break;

                default:
                    System.out.println("You are not authorized to take any action.");
            }
        }
    }

    public static void progExit(){
        System.out.println("\nExiting... Thank you!");
        System.exit(0);
    }

    private static String userLogin(){
        System.out.println("\n==== LOG IN ====\n");
        System.out.println("1. Admin");
        System.out.println("2. Mission Planner");
        System.out.println("3. Spacecraft Engineer");
        System.out.println("4. Resource Manager");
        System.out.println("5. Scientist/Researcher");
        System.out.println("6. Exit Program");

        System.out.print("\nSelect option (enter 1-6): ");
        int roleChoice = space.nextInt();
        space.nextLine();

        switch (roleChoice){
            case 1:
                return "Admin";

            case 2:
                return "Mission Planner";

            case 3:
                return "Spacecraft Engineer";

            case 4:
                return "Resource Manager";

            case 5:
                return "Scientist/Researcher";

            case 6:
                progExit();

            default:
                System.out.println("Invalid input. Please enter an integer from 1 to 6 only.");
                return userLogin();
        }
    }

    private static void adminMenu(){
        while (true){
            System.out.println("\n==== ADMIN MENU ====");
            System.out.println("1. Manage Missions");
            System.out.println("2. Manage Spacecraft");
            System.out.println("3. Manage Resources");
            System.out.println("4. Manage Research Projects");
            System.out.println("5. Back to Main Login Page");

            System.out.print("\nEnter choice number (1-5): ");
            int choice = space.nextInt();
            space.nextLine();

            switch (choice){
                case 1:
                    manageMissionsMenu();
                    break;

                case 2:
                    manageSpacecraftMenu();
                    break;

                case 3:
                    manageResourcesMenu();
                    break;

                case 4:
                    manageResearchProjsMenu();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid input. Please enter an integer from 1 to 5 only.");
            }
        }
    }

    //RESEARCH MANAGEMENT
    public static void manageResearchProjsMenu(){
        while (true) {
            System.out.println("\n==== Manage Research Projects ====\n");
            System.out.println("1. Create New Research Project");
            System.out.println("2. Assign Mission to Research Project");
            System.out.println("3. Display All Research Projects");
            System.out.println("4. Back to Main Login Page");

            System.out.print("\nEnter menu number (1-4): ");
            int projectChoice = space.nextInt();
            space.nextLine();

            switch (projectChoice){
                case 1:
                    createNewResearchProject();
                    break;

                case 2:
                    assignMissionToResearchProject();
                    break;

                case 3:
                    displayAllResearchProjects();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid input. Please enter an integer from 1 to 4 only.");
            }
        }
    }

    public static void createNewResearchProject(){
        System.out.println("\nChoose type of research project to create:");
        System.out.println("1. Astronomy Research");
        System.out.println("2. Biology Research");
        System.out.println("3. Technology Development Research");

        System.out.print("\nEnter choice number (1-3): ");
        int researchChoice = space.nextInt();
        space.nextLine();

        System.out.print("\nEnter project name: ");
        String projectName = space.nextLine();

        System.out.print("Enter project details: ");
        String projectDetails = space.nextLine();

        ResearchProject newResearchProject = null;

        //Research type options
        switch (researchChoice){
            //Astronomy Research
            case 1:
                System.out.print("Enter celestial object to study: ");
                String celestialObject = space.nextLine();
                newResearchProject = new AstronomyResearch(projectName, projectDetails, celestialObject);
                break;

            //Biology Research
            case 2:
                System.out.print("Enter organism to study: ");
                String organism = space.nextLine();
                newResearchProject = new BiologyResearch(projectName, projectDetails, organism);
                break;

            //Technology Development Research
            case 3:
                System.out.print("Enter technology to develop: ");
                String technology = space.nextLine();
                newResearchProject = new TechnologyDevelopmentResearch(projectName, projectDetails, technology);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (newResearchProject != null){
            researchProj[researchCount++] = newResearchProject;
            System.out.println("\nSResearch project " + projectName.toUpperCase() + " created successfully.");
        }
    }

    public static void assignMissionToResearchProject(){
        System.out.print("\nEnter project name to assign a mission: ");
        String projectName = space.nextLine();

        //find research project by name
        ResearchProject selectedProject = null;
        for (int i = 0; i < researchCount; i++){
            if (researchProj[i].getName().equalsIgnoreCase(projectName)){
                selectedProject = researchProj[i];
                break;
            }
        }

        if (selectedProject == null){
            System.out.println("Research project not found.");
            return;
        }

        //check if there are available missions
        if (missionCount == 0){
            System.out.println("No available missions to assign.");
            return;
        }

        //display all available missions
        System.out.println("\nList of Available Missions:");
        displayAllMissions();

        //prompt user to select a mission to assign
        System.out.print("\nEnter mission name to assign: ");
        String missionName = space.nextLine();

        //find the mission by name
        Mission selectedMission = null;
        for (int i = 0; i < missionCount; i++){
            if (missions[i].getName().equalsIgnoreCase(missionName)){
                selectedMission = missions[i];
                break;
            }
        }

        if (selectedMission == null){
            System.out.println("Mission not found.");
            return;
        }

        //assign mission to research project using polymorphism
        selectedProject.assignProjMission(selectedMission);
    }

    public static void displayAllResearchProjects(){
        System.out.println("\n==== All Research Projects ====\n");
        if (researchCount > 0){
            for (int i = 0; i < researchCount; i++){
                researchProj[i].displayDetails();           //polymorphic call
                System.out.println("--------------------------------------");
            }
        } else{
            System.out.println("Research Project List Empty.");
        }
    }
}
