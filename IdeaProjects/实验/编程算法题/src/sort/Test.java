package sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3, 1, 34, 133, 5, 0, 12, 1, 1341, 0, 66};
        long start = System.nanoTime();
        //binaryInsertSort(arr);
        //shellSort(arr, 3);
        //quickSort(arr, 0, arr.length - 1);
        long end = System.nanoTime();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n" + (end - start) + "ns");
    }

    @MyTest
    public static void quickSort(int[] a, int left, int right) {
    }

    public static int sort(int[] a, int left, int right) {
        return left;
    }

    public static void shellSort(int[] a, int n) {
    }

    public static void sort(int[] a, int step) {
    }

    public static void binaryInsertSort(int[] a) {
    }
}