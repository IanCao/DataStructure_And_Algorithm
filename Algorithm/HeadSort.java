package Algorithm;

public class HeadSort {
    public static void main(String[] args) {
        HeadSort(ArraysUtils.createRandomArrays(10));
    }

    private static void HeadSort(int[] values) {

        //创建大顶堆，即最上面的节点是里面最大的，然后在将最上面的跟最后一位元素交换，然后排除最后一位元素再进行下一轮排序，依次递推
        for (int i = values.length / 2; i >= 0; i--) {
            HeadAdjust(values, values.length, i);
        }

        ArraysUtils.printArrays(values);

        for (int j = values.length - 1; j > 0; j--) {
            ArraysUtils.swap(values, 0, j);
            HeadAdjust(values, j, 0);
        }
        ArraysUtils.printArrays(values);
    }

    private static void HeadAdjust(int[] values, int size, int index) {
        int rightChild = index * 2 + 2;
        int leftChild = index * 2 + 1;
        int maxIndex = index;

        if (rightChild < size && values[maxIndex] < values[rightChild]) {
            maxIndex = rightChild;
        }

        if (leftChild < size && values[maxIndex] < values[leftChild]) {
            maxIndex = leftChild;
        }

        if (maxIndex != index) {
            ArraysUtils.printArrays(values);
            ArraysUtils.swap(values, index, maxIndex);
            HeadAdjust(values, size, maxIndex);
        }
    }

}
