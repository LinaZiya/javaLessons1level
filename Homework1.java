public class Homework1 {
    public static void main(String[] args) {
        byte a = 12;
        short b = 345;
        int c = 12345;
        long d = 120000000;
        float e = 12.45f;
        double f = 234.455;
        char n = 't';
        boolean flag = true;
        String name = "Polina";
        System.out.println(belongToInterval(34,67));
        System.out.println(evaluateExpression(1, 5, 34.5f, 45.6f));
        determineSign5(-5);
        System.out.println(determineSign(7));
        printGreeting("Полина");
        defineLeapYear(1820);
    }

    public static double evaluateExpression(float a, float b, float c, float d){
        return a*(b + c/d);
    }

    public static boolean belongToInterval(int a, int b){
        int sum = a + b;
        return (sum >= 10) && (sum <=20);
    }

    public static void determineSign5(int a) {
        String sign = a >= 0 ? "positive" : "negative";
        System.out.println("Number is " + sign);
    }

    public static boolean determineSign(int a) {
        return a < 0;
    }

    public static void printGreeting(String name) {
        System.out.println("Привет, " + name);
    }

    public static void defineLeapYear(int year) {
        boolean isLeapYear;
        if (year % 4 == 0 && year % 100 != 0) {
            isLeapYear = true;
        }
        else {
            isLeapYear = year % 400 == 0;
        }
        String leapYear = isLeapYear ? "" : "not";
        System.out.println("It is " + leapYear + " a leap year");
    }
}
