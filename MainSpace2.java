package com.example.mainspacers;

import java.util.Scanner;

public class MainSpace{
    private static Scanner space = new Scanner(System.in);

    private static Mission[] missions = new Mission[100];
    private static Spacecraft[] spacecrafts = new Spacecraft[100];
    private static Resource[] resources = new Resource[100];    //polymorphic array
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

    //RESOURCE
    public static void manageResourcesMenu(){
        while (true){
            System.out.println("\n==== Manage Resources ====\n");
            System.out.println("1. Add New Resource");
            System.out.println("2. Display All Resources");
            System.out.println("3. Back to Main Login Page");

            System.out.print("\nEnter choice number (1-3): ");
            int resourceChoice = space.nextInt();
            space.nextLine();

            switch (resourceChoice){
                case 1:
                    addNewResource();
                    break;

                case 2:
                    displayAllResources();
                    break;

                case 3:
                    return;
                default:
                    System.out.println("Invalid input. Please enter an integer from 1 to 3 only.");
            }
        }
    }

    public static void addNewResource(){
        System.out.println("\nChoose type of resource to add:");
        System.out.println("1. Fuel Resource");
        System.out.println("2. Equipment Resource");
        System.out.println("3. Food Resource");

        System.out.print("\nEnter choice number (1-3): ");
        int resourceChoice = space.nextInt();
        space.nextLine();

        System.out.print("\nEnter resource name: ");
        String resourceName = space.nextLine();

        System.out.print("Enter quantity: ");
        int resourceQuantity = space.nextInt();
        space.nextLine();

        switch (resourceChoice){
            //fuel resource
            case 1:
                System.out.print("Enter fuel type: ");
                String fuelType = space.nextLine();
                resources[resourceCount++] = new FuelResource(resourceName, resourceQuantity, fuelType);
                break;

            //equipment resource
            case 2:
                System.out.print("Enter equipment type: ");
                String equipmentType = space.nextLine();
                resources[resourceCount++] = new EquipmentResource(resourceName, resourceQuantity, equipmentType);
                break;

            //food resource
            case 3:
                System.out.print("Enter expiry date (YYYY-MM-DD): ");
                String expiryDate = space.nextLine();
                resources[resourceCount++] = new FoodResource(resourceName, resourceQuantity, expiryDate);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("\nResource " + resourceName.toUpperCase() + " added successfully.");
    }


    public static void displayAllResources(){
        System.out.println("\n==== All Resources ====");
        if (resourceCount > 0){
            for (int i = 0; i < resourceCount; i++){
                resources[i].displayInfo();             //polymorphic call
                System.out.println("------------------------------------------------");
            }
        } else{
            System.out.println("\nResource List Empty.");
        }
    }
}