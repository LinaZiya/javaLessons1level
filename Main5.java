public class Main5 {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        int k = 0;
        employees[k++] = new Employee("Paul Stamets", "Lieutenant Commander, doctor, astromycologistr", "paulstamets@fmail.com",
                "", 1000000, 39);
        employees[k++] = new Employee("Michael Burnham", "Captain of USS Discovery", "michaelburnham@fmail.com",
                "", 1500000, 35);
        employees[k++] = new Employee("Sylvia Tilly", "Ensign, theoretical engineer", "sylviatilly@fmail.com",
                "", 900000, 33);
        employees[k++] = new Employee("Philippa Georgiou", "Captain of  USS Shenzhou", "philippageorgiou@fmail.com",
                "", 1500000, 54);
        employees[k++] = new Employee("Katrina Cornwell", "Vice Admiral", "katrinacornwell@fmail.com",
                "", 2000000, 58);

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].printInformation();
            }
        }
    }
}
