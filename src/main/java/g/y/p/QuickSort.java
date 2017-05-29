package g.y.p;


import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
//        System.out.println(Arrays.toString(array));
        if (low < high) {
            int q = partition(array, low, high);
            quickSort(array, low, q-1);
            quickSort(array, q+1, high);
        }
    }

    public static void swap(int[] a,int from, int to){
//        System.out.println("swap between " + a[from] +" and "+a[to]);
        int t = a[from];
        a[from] = a[to];
        a[to] = t;
    }

    /**
    during partition, we have changed the order of the origin array to [[low],pivot,[high]]
     init states [] array -> [[low],pivot,[high]]
     */
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
//        System.out.println("partition round for "+ pivot);
        //EMPTY SUBSET FOR LESS THAN
        int less = low - 1;
        for (int cursor = low; cursor <= high - 1; cursor++) {
            if (array[cursor] <= pivot) {
                //advance to ocuppy
                less++;
                swap(array,less,cursor);
            }
        }
        swap(array,less+1,high);
        //pivot position found
        return less+1;
    }


    public static void main(String[] args) {
        int arr[] = {8, 9, 1, 6, 7, 2, 3, 4, 5, 0};
        QuickSort.quickSort(arr,0, 9);
        System.out.println(Arrays.toString(arr));
    }
}
