import java.util.Objects;

public abstract class Animal {
    private String family;
    private String habitat;
    private int weight;
    private static int countOfAnimals = 0;
    
    public Animal(String family, String habitat, int weight) {
        this.family = family;
        this.habitat = habitat;
        this.weight = weight;
        countOfAnimals++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return weight == animal.weight &&
                Objects.equals(family, animal.family) &&
                Objects.equals(habitat, animal.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, habitat, weight);
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getCountOfAnimals() {
        return countOfAnimals;
    }

    public static void setCountOfAnimals(int countOfAnimals) {
        Animal.countOfAnimals = countOfAnimals;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
