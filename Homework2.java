public class Homework2 {
    public static void main(String[] args) {

        int[] arr1 = {1, 1, 0, 1, 1, 1, 0, 1, 1, 0};
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1[i] == 1 ? 0 : 1;
        }
        printArray(arr1);

        int[] arr2 = new int[8];
        int k = 3;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * k;
        }
        printArray(arr2);

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        printArray(arr3);

        int[][] arr4 = new int[10][10];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = arr4[i][arr4.length - 1 - i] = 1;
        }
        printArray(arr4);

        int[] arr5 = {6, 3, 56, 67, 54, 21, 44};
        System.out.println(findMax(arr5) + " " + findMin(arr5));

        int[] arr6 = {2,2,2,1,2,2,10,1};
        int[] arr7 = {1,1,1,2,1};
        System.out.println(checkBalance(arr6));
        System.out.println(checkBalance(arr7));

        int[] arr8 = {1,2,3,4,5,6,7};
        printArray(shiftElements(arr8, 4));
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static boolean checkBalance(int[] arr) {
        int i = 1;
        int leftSum = 0;
        int rightSum = 0;
        while (i < arr.length) {
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                return true;
            }
            leftSum = rightSum = 0;
            i++;
        }
        return false;
    }

    public static int[] shiftElements(int[] arr, int n) {
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int s = i + n;
            if (s < arr.length && s >= 0 ) {
                arr1[s] = arr[i];
            }
            else {
                int k = s >= arr.length ? -1 : 1;
                arr1[s + k * arr.length] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr1[i];
        }
        return arr;
    }

    public static void printArray(int[][] arr) {
        for (int[] el : arr) {
            for (int j = 0; j < el.length; j++) {
                System.out.print(el[j] + " ");
            }
            System.out.println();
        }
    }
    public static void printArray(int[] arr) {
        for (int el : arr) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

}
