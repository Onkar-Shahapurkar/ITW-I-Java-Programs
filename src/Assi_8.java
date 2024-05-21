class Vehicle {
    private String brand;
    private int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }

    public static void honk() {
        System.out.println("Vehicle honks!");
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
    }

    public static void honk() {
        System.out.println("Car honks!");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasFairing;

    public Motorcycle(String brand, int year, boolean hasFairing) {
        super(brand, year);
        this.hasFairing = hasFairing;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Fairing: " + hasFairing);
    }

    public static void honk() {
        System.out.println("Motorcycle honks!");
    }
}

class Assi_8{
  public static void main(String args[])
  {
    Car c = new Car("Tesla", 2004, 4);
    Motorcycle m = new Motorcycle("Harley Davidson", 1990, false);
    
    c.displayInfo();
    c.honk();
    m.displayInfo();
    m.honk();
  }
}
