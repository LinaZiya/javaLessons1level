import java.util.Objects;

public class Dog extends Animal{
    private String name;
    private final int MAX_RUNNING_DISTANCE = 500;
    private final int MAX_SWIMMING_DISTANCE = 200;
    public static int countOfDogs = 0;

    public Dog(String family, String habitat, int weight, String name) {
        super(family, habitat, weight);
        this.name = name;
        countOfDogs++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUNNING_DISTANCE) {
            System.out.println(name + " ran " + distance + " meters");
        }
        else {
            System.out.println("Dog can't run this distance");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIMMING_DISTANCE) {
            System.out.println(name + " swam " + distance + " meters");
        }
        else {
            System.out.println("Dog can't swim this distance");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMAX_RUNNING_DISTANCE() {
        return MAX_RUNNING_DISTANCE;
    }

    public int getMAX_SWIMMING_DISTANCE() {
        return MAX_SWIMMING_DISTANCE;
    }
}
