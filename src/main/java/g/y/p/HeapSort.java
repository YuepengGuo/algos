package g.y.p;


import java.util.Arrays;

public class HeapSort {
    private static void heapify(int[] arr,int size, int i){
        //for most heapsort, we will use 1-based array, but since this array is 0 based.
        int l = 2*i +1;
        int r = 2*i +2;
        int smallest = i;
        if(l<size && arr[l] < arr[smallest]){
            smallest = l;
        }
        if(r<size && arr[r]<arr[smallest]){
            smallest = r;
        }
        if(smallest!=i){
            //swap
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
            heapify(arr,size,smallest);

        }


    }
    public static void sort(int[] arr){
        int n = arr.length;

        //build heap
        for(int i=n/2-1; i>=0;i--){
            heapify(arr,n,i);
        }

        // extract smallest from heap one by one
        for(int i=n-1;i>=0;i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr,i,0);
        }
    }

    public static void main(String[] args) {
        int a[] = {4,7,6,3,9,8,0,2,1,5,4,4};
        sort(a);
        Arrays.stream(a).forEach(System.out::println);

    }
}
