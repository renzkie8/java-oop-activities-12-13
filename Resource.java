package com.example.mainspacers;

// Abstract class representing a generic resource
abstract class Resource {
    private String name; // Encapsulation: Private field to restrict direct access
    private int quantity; // Encapsulation: Private field to restrict direct access

    // Constructor to initialize resource attributes
    public Resource(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    // Public getter for resource name (Encapsulation: Controlled access)
    public String getName() {
        return name;
    }

    // Public getter for resource quantity (Encapsulation: Controlled access)
    public int getQuantity() {
        return quantity;
    }

    // Public setter for resource quantity (Encapsulation: Controlled access)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to increment the resource quantity
    public void incrementQuantity(int amount) {
        this.quantity += amount;
    }

    // Method to decrement the resource quantity
    public void decrementQuantity(int amount) {
        this.quantity -= amount;
    }

    // Abstract method for displaying resource information
    // Abstraction: Forces subclasses to provide specific implementation
    public abstract void displayInfo();
}

// Subclass representing fuel resources
class FuelResource extends Resource {
    private String fuelType; // Encapsulation: Private field specific to FuelResource

    // Constructor to initialize fuel resource attributes
    public FuelResource(String name, int quantity, String fuelType) {
        super(name, quantity); // Inheritance: Reuses Resource's constructor
        this.fuelType = fuelType;
    }

    // Getter for fuel type
    public String getFuelType() {
        return fuelType;
    }

    // Overridden method to display fuel resource information
    @Override
    public void displayInfo() {
        // Polymorphism: Provides specific behavior for fuel resources
        System.out.println("Resource Name: " + getName());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass representing equipment resources
class EquipmentResource extends Resource {
    private String equipmentType; // Encapsulation: Private field specific to EquipmentResource

    // Constructor to initialize equipment resource attributes
    public EquipmentResource(String name, int quantity, String equipmentType) {
        super(name, quantity); // Inheritance: Reuses Resource's constructor
        this.equipmentType = equipmentType;
    }

    // Getter for equipment type
    public String getEquipmentType() {
        return equipmentType;
    }

    // Overridden method to display equipment resource information
    @Override
    public void displayInfo() {
        // Polymorphism: Provides specific behavior for equipment resources
        System.out.println("Resource Name: " + getName());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Equipment Type: " + equipmentType);
    }
}

// Subclass representing food resources
class FoodResource extends Resource {
    private String expiryDate; // Encapsulation: Private field specific to FoodResource

    // Constructor to initialize food resource attributes
    public FoodResource(String name, int quantity, String expiryDate) {
        super(name, quantity); // Inheritance: Reuses Resource's constructor
        this.expiryDate = expiryDate;
    }

    // Getter for expiry date
    public String getExpiryDate() {
        return expiryDate;
    }

    // Overridden method to display food resource information
    @Override
    public void displayInfo() {
        // Polymorphism: Provides specific behavior for food resources
        System.out.println("Resource Name: " + getName());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Expiry Date: " + expiryDate);
    }
}
