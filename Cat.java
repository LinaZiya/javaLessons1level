import java.util.Objects;

public class Cat extends Animal{
    private String name;
    private final int MAX_RUNNING_DISTANCE = 200;
    public static int countOfCats = 0;


    public Cat(String family, String habitat, int weight, String name) {
        super(family, habitat, weight);
        this.name = name;
        countOfCats++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name);
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
            System.out.println("Cat can't run this distance");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cat can't swim");
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
}
