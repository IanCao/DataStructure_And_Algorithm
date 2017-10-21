package Algorithm;

public class ArraysUtils {

    public static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void printArrays(int[] values) {
        System.out.println();
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    public static int[] createRandomArrays(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int) (Math.random() * 30);
        }
        return result;
    }
}
