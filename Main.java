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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for ElectricCar// //This program was written by [Jannatul Khanam]//
        System.out.println("Enter details for ElectricCar :");
        System.out.print("Name: ");
        String electricCarName = scanner.nextLine();
        System.out.print("Model: ");
        String electricCarModel = scanner.nextLine();
        System.out.print("Year: ");
        int electricCarYear = scanner.nextInt();
        System.out.print("Battery Capacity (kWh): ");
        int electricCarBatteryCapacity = scanner.nextInt();

        ElectricCar myElectricCar = new ElectricCar(electricCarName, electricCarModel, electricCarYear, electricCarBatteryCapacity);
        myElectricCar.displayElectricInfo();

        // Input for GasCar// //This program was written by [Jannatul Khanam]//
        System.out.println("\nEnter details for GasCar:");
        System.out.print("Name: ");
        scanner.nextLine(); // Consume the newline character
        String gasCarName = scanner.nextLine();
        System.out.print("Model: ");
        String gasCarModel = scanner.nextLine();
        System.out.print("Year: ");
        int gasCarYear = scanner.nextInt();
        System.out.print("Fuel Efficiency (miles per gallon): ");
        double gasCarFuelEfficiency = scanner.nextDouble();

        GasCar myGasCar = new GasCar(gasCarName, gasCarModel, gasCarYear, gasCarFuelEfficiency);
        myGasCar.displayGasInfo();

        scanner.close();
    }
}
