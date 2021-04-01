import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ModelTest {
    @BeforeAll
    public static void createNormalObjects() {

    }

    @Test
    public void CrewmateCreationTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Crewmate("", "male", "role", 20));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Crewmate("Brian Griffin", "dog", "role", 7));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Crewmate("Negative Age", "male", "role", -7));
    }

    @Test
    public void EngineCreationTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Engine("", 100));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Engine("Photonic", 0));
    }

    @Test
    public void SpaceshipCreationTest() {
        Crewmate crewmate1 = new Crewmate("Crewmate 1", "male", "Pilot", 45);
        Crewmate crewmate2 = new Crewmate("Crewmate 2", "female", "Second Pilot", 34);
        Crewmate crewmate3 = new Crewmate("Crewmate 3", "female", "", 19);
        Crewmate crewmate4 = new Crewmate("Crewmate 4", "male", "Technician", 55);
        Crewmate crewmate5 = new Crewmate("Crewmate 5", "male", "Imposter", 155);
        Engine engine = new Engine("Photonic", 100);
        Coord pos = new Coord(0.0, 0.0, 0.0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Spaceship(engine, "", pos));

        ArrayList<Crewmate> crewmates = new ArrayList<Crewmate>();
        crewmates.add(crewmate1);
        crewmates.add(crewmate2);
        crewmates.add(crewmate3);
        crewmates.add(crewmate4);
        crewmates.add(crewmate5);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Spaceship(crewmates, engine, "Golden Heart", pos));
    }

    @Test
    public void EngineFuelTest() {
        Engine engine =  new Engine("Photonic", 100);

        Assertions.assertThrows(IllegalArgumentException.class, () -> engine.refuel(0.0));
        Assertions.assertThrows(UnsupportedOperationException.class, () -> engine.refuel(101.0));

        engine.refuel(50.0);

        Assertions.assertEquals(50.0, engine.getFuel());

        Assertions.assertThrows(IllegalArgumentException.class, () -> engine.spendFuel(0.0));
        Assertions.assertThrows(UnsupportedOperationException.class, () -> engine.spendFuel(51.0));

        engine.spendFuel(50.0);

        Assertions.assertEquals(0.0, engine.getFuel());
    }

    @Test
    public void MovementTest() {
        Crewmate crewmate1 = new Crewmate("Crewmate 1", "male", "Pilot", 45);
        Crewmate crewmate2 = new Crewmate("Crewmate 2", "female", "Second Pilot", 34);
        Crewmate crewmate3 = new Crewmate("Crewmate 3", "female", "", 19);
        Crewmate crewmate4 = new Crewmate("Crewmate 4", "male", "Technician", 55);
        Engine engine =  new Engine("Photonic", 100);
        Coord pos = new Coord(0.0, 0.0, 0.0);
        Spaceship spaceship = new Spaceship(engine, "Golden Heart", pos);

        Assertions.assertThrows(UnsupportedOperationException.class, () -> spaceship.move(2.0, 4.0, 4.0));

        spaceship.getEngine().refuel(50);

        Assertions.assertThrows(UnsupportedOperationException.class, () -> spaceship.move(2.0, 4.0, 4.0));

        spaceship.addCrewmate(crewmate1);
        spaceship.addCrewmate(crewmate2);
        spaceship.addCrewmate(crewmate3);
        spaceship.addCrewmate(crewmate4);

        spaceship.move(2.0, 4.0, 4.0);

        Assertions.assertEquals("Coord{x=2.0, y=4.0, z=4.0}", spaceship.getPos());
        Assertions.assertEquals(44.0, spaceship.getEngine().getFuel());
    }
}
