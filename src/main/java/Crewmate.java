import java.util.Locale;

public class Crewmate {
    private final String name, gender, role;
    private int age;

    public Crewmate(String name, String gender, String role, int age) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Illegal name param!");
        }

        if (!(gender.toLowerCase(Locale.ROOT).equals("male") || gender.toLowerCase(Locale.ROOT).equals("female"))) {
            throw new IllegalArgumentException("Illegal gender param!");
        }

        if (age < 0) {
            throw new IllegalArgumentException("Illegal age param!");
        }

        this.name = name;
        this.gender = gender.toLowerCase(Locale.ROOT);
        this.role = role;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getGender() {
        return role;
    }

    public int getAge() {
        return age;
    }

    public void makeOlder() {
        age++;
    }

    @Override
    public String toString() {
        return "Crewmate{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", age=" + age +
                '}';
    }
}
