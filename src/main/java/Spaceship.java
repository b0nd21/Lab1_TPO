import java.util.ArrayList;

public class Spaceship {
    private ArrayList<Crewmate> crew;
    private Engine engine;
    private final String name;
    private Coord pos;

    public Spaceship(Engine engine, String name, Coord pos) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Illegal name param!");
        }

        this.engine = engine;
        this.name = name;
        this.pos = pos;

        crew = new ArrayList<Crewmate>();
    }

    public Spaceship(ArrayList<Crewmate> crew, Engine engine, String name, Coord pos) {
        if(crew.size() > 4) {
            throw new IllegalArgumentException("Too big crew array!");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Illegal name param!");
        }
        this.pos = pos;
        this.crew = crew;
        this.engine = engine;
        this.name = name;
    }

    public ArrayList<Crewmate> getCrew() {
        return crew;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getName() {
        return name;
    }

    public String getPos() {
        return pos.toString();
    }

    public void addCrewmate(Crewmate crewmate) {
        if(crew.size() == 4) {
            throw new UnsupportedOperationException("No more place!");
        }
        crew.add(crewmate);
    }

    public void move(double x, double y, double z) {
        double distance = Math.sqrt((x - pos.getX()) * (x - pos.getX()) + (y - pos.getY()) * (y - pos.getY()) + (z - pos.getZ()) * (z - pos.getZ()));
        if(distance > engine.getFuel()) {
            throw new UnsupportedOperationException("Not enough fuel!");
        }
        if(crew.size() == 0) {
            throw new UnsupportedOperationException("Empty ship!");
        }
        engine.spendFuel(distance);
        pos.setPos(x, y, z);
    }
}
