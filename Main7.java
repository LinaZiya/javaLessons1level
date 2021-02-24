public class Main7 {
    public static void main(String[] args) {
        int k = 0;
        Cat7[] cats = new Cat7[5];
        cats[k++] = new Cat7("Barsik", 10);
        cats[k++] = new Cat7("Mursik", 12);
        cats[k++] = new Cat7("Lariska", 23);
        cats[k++] = new Cat7("Pushok", 10);
        cats[k++] = new Cat7("Kot", 24);

        Plate plate = new Plate(60);
        plate.addFood(2);
        plate.info();

        for (Cat7 cat : cats) {
            cat.eat(plate);
        }

        for (Cat7 cat : cats) {
            System.out.println(cat.getName() + " is full: " + cat.isSatiety());
        }
    }
}
