package com.example.mainspacers;

abstract class ResearchProject {//Abstraction
    //This abstract for class ResearchProject provides a base for specific research projects.
    private String name;//Encapsulation
    private String details;//Encapsulation
    private Mission assignedMission;//Encapsulation
    //The above attributes is field as private to estrict direct access.
    public ResearchProject(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public Mission getAssignedMission() {
        return assignedMission;
    }

    public void setAssignedMission(Mission mission) {
        this.assignedMission = mission;
    }

    // Abstract method for specific assignment rules
    public abstract void assignProjMission(Mission mission);

    public void displayDetails() {
        System.out.println("Research Project Name: " + name);
        System.out.println("Details: " + details);
        if (assignedMission != null) {
            System.out.println("Assigned Mission: " + assignedMission.getName());
        } else {
            System.out.println("No mission assigned.");
        }
    }
}

class AstronomyResearch extends ResearchProject {//Inheritance
    //This subclass inherits specific implementation from ResearchProject class.
    private String celestialObject;//Encapsulation: this field is restricted for direct access

    public AstronomyResearch(String name, String details, String celestialObject) {
        super(name, details);
        this.celestialObject = celestialObject;// tells us if what is the details of the celestial obj/s found.
    }

    @Override//Polymorphism
    //This method overrides the parent class implementation
    public void assignProjMission(Mission mission) {
        if (mission.getMissionType().equalsIgnoreCase("Manned") || mission.getMissionType().equalsIgnoreCase("Unmanned")) {
            setAssignedMission(mission);
            System.out.println("Mission assigned successfully to Biology Research project.");// display the mission has been succesfully assigned
        } else {
            System.out.println("Error: Biology Research can only be assigned Manned or Unmanned missions.");
        }
    }

    @Override//Polymorphism
    //This method overrides the parent class implementation
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Celestial Object: " + celestialObject);
    }
}

class BiologyResearch extends ResearchProject {// Inheritance
    //This subclass inherits specific implementation form ResearchProject class.
    private String organism;
    public BiologyResearch(String name, String details, String organism) {
        super(name, details);
        this.organism = organism;// this field display the details for the organism included in Researh Project.
    }

    @Override//Polymorphism
    ////This method overrides the parent class implementation
    public void assignProjMission(Mission mission) {
        if (mission.getMissionType().equalsIgnoreCase("Exploration")) {
            setAssignedMission(mission);
            System.out.println("Mission assigned successfully to Astronomy Research project.");// tells us the Res.Proj has been succesfully assigned to Mission.
        } else {
            System.out.println("Error: Astronomy Research can only be assigned Exploration missions.");
        }
    }


    @Override//Polymorphism
    //This method overrides the parent class implementation
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Organism: " + organism);
    }
}

class TechnologyDevelopmentResearch extends ResearchProject {//Inheritance
    //This subclass inherits specific implementation form ResearchProject class.
    private String technology;//Encapsulation.
    //This string attribute is private to restrict direct access for it is only use in details of the technology.
    public TechnologyDevelopmentResearch(String name, String details, String technology) {
        super(name, details);
        this.technology = technology;
    }

    @Override//Polymorphism
    //This method overrides the parent class implementation
    public void assignProjMission(Mission mission) {
        setAssignedMission(mission);//tells us to set or assigned this new mission to research project tech dev.
        System.out.println("Mission assigned successfully to Technology Development Research project.");
    }

    @Override//Polymorphism
     //This method overrides the parent class implementation
    public void displayDetails() {
        super.displayDetails();//confirmation output
        System.out.println("Technology: " + technology);
    }
}

