import java.util.Locale;

public class Engine {
    private final String typeName;
    private final double engineCapacity;
    private double fuel;

    public Engine(String typeName, double engineCapacity) {
        if (typeName.isBlank()) {
            throw new IllegalArgumentException("Illegal name param!");
        }

        if (engineCapacity <= 0) {
            throw new IllegalArgumentException("Illegal engine capacity param!");
        }
        this.typeName = typeName;
        this.engineCapacity = engineCapacity;
        fuel = 0;
    }

    public void refuel(double fuel) {
        if(this.fuel + fuel > engineCapacity) {
            throw new UnsupportedOperationException("Too much fuel!");
        }
        if(fuel <= 0) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        this.fuel += fuel;
    }

    public void spendFuel(double fuel) {
        if(this.fuel - fuel < 0) {
            throw new UnsupportedOperationException("Not enough fuel!");
        }
        if(fuel <= 0) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        this.fuel -= fuel;
    }

    public String getTypeName() {
        return typeName;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public double getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "typeName='" + typeName + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", fuel=" + fuel +
                '}';
    }
}
