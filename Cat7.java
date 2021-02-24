public class Cat7 {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat7(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            satiety = true;
        }
        else {
            System.out.println("Not enough food for " + name + " on the plate!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
