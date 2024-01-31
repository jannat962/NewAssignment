//This program was written by [Jannatul Khanam]//

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
    private String name;
    private String model;
    private int year;

    public Car(String name, String model, int year) {
        this.name = name;
        this.model = model;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println(year + " " + name + " " + model);
    }
}

class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(String name, String model, int year, int batteryCapacity) {
        super(name, model, year);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void displayElectricInfo() {
        displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class GasCar extends Car {
    private double fuelEfficiency;

    public GasCar(String name, String model, int year, double fuelEfficiency) {
        super(name, model, year);
        this.fuelEfficiency = fuelEfficiency;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void displayGasInfo() {
        displayInfo();
        System.out.println("Fuel Efficiency: " + fuelEfficiency + " miles per gallon");
    }
}

public class CarInventorySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> carInventory = new ArrayList<>();

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Electric Car");
            System.out.println("2. Add Gas Car");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addElectricCar(scanner, carInventory);
                    break;
                case 2:
                    addGasCar(scanner, carInventory);
                    break;
                case 3:
                    displayInventory(carInventory);
                    break;
                case 4:
                    System.out.println("Exiting Car Inventory System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addElectricCar(Scanner scanner, List<Car> carInventory) {
        System.out.println("Enter details for ElectricCar:");
        System.out.print("Name: ");
        String electricCarName = scanner.next();
        System.out.print("Model: ");
        String electricCarModel = scanner.next();
        System.out.print("Year: ");
        int electricCarYear = scanner.nextInt();
        System.out.print("Battery Capacity (kWh): ");
        int electricCarBatteryCapacity = scanner.nextInt();

        ElectricCar electricCar = new ElectricCar(electricCarName, electricCarModel, electricCarYear, electricCarBatteryCapacity);
        carInventory.add(electricCar);

        System.out.println("Electric Car added to inventory!");
    }

    
    //This program was written by [Jannatul Khanam]//
    private static void addGasCar(Scanner scanner, List<Car> carInventory) {
        System.out.println("Enter details for GasCar:");
        System.out.print("Name: ");
        String gasCarName = scanner.next();
        System.out.print("Model: ");
        String gasCarModel = scanner.next();
        System.out.print("Year: ");
        int gasCarYear = scanner.nextInt();
        System.out.print("Fuel Efficiency (miles per gallon): ");
        double gasCarFuelEfficiency = scanner.nextDouble();

        GasCar gasCar = new GasCar(gasCarName, gasCarModel, gasCarYear, gasCarFuelEfficiency);
        carInventory.add(gasCar);

        System.out.println("Gas Car added to inventory!");
    }

    private static void displayInventory(List<Car> carInventory) {
        System.out.println("\nCar Inventory:");
        for (Car car : carInventory) {
            if (car instanceof ElectricCar) {
                ((ElectricCar) car).displayElectricInfo();
            } else if (car instanceof GasCar) {
                ((GasCar) car).displayGasInfo();
            }
        }
    }
}
