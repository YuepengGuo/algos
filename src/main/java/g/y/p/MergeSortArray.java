package g.y.p;

import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class MergeSortArray {

    /**
     * This is not in place sort_with_helper_array.
     */
    static int[] sort_with_helper_array(int[] ar) {
        if (ar.length == 1 ) {
            return ar;
        }
        int mid = ar.length / 2;
        int[] ar1 = copyOfRange(ar, 0, mid);//mid is exclusive
        int[] ar2 = copyOfRange(ar, mid, ar.length);//mid is inclusive
        return merge_with_helper_array(sort_with_helper_array(ar1), sort_with_helper_array(ar2));
    }

    /**
     * This is not in place sort_with_helper_array.
     */
    private static int[] merge_with_helper_array(int[] in1, int[] in2) {
        int[] out = new int[in1.length + in2.length];
        int i = 0, j = 0, k = 0;
        while (j < in1.length && k < in2.length) {
            if (in1[j] < in2[k]) {
                out[i++] = in1[j++];
            } else {
                out[i++] = in2[k++];
            }
        }
        while (j < in1.length) {
            out[i++] = in1[j++];
        }
        while (k < in2.length) {
            out[i++] = in2[k++];
        }
        return out;
    }

    static void mergesort(int[] array, int low, int high){
        if(low<high){
            //lower bound
            int mid = low + (high-low)/2;
            mergesort(array,low,mid);
            //since lower bound included in first part,so the second part begins with mid plus 1!
            mergesort(array,mid+1,high);
            merge(array,low,mid,high);
        }

    }

    /**
     * but it still use a helper array
     */
    static void merge(int[]array,int low, int mid, int high){
        int[] helper = new int[array.length];
        for(int i=0;i<array.length;i++){
            helper[i] = array[i];
        }
        //stupid error, always be careful about absolute index in recursive model, they should always be relative by parameters.
//      int l = 0, h= mid+1, c=0;!!!
        int l = low, h= mid+1, c=low;
        while(l<=mid && h<=high){
            //debug point, we exchange values here!!!
//            System.out.println(helper[l] +"::"+helper[h]);
            if(helper[l]<helper[h]){
                array[c++] = helper[l++];
            }else{
                array[c++] = helper[h++];
            }
        }
        while(l<=mid){
            array[c++] = helper[l++];
        }

        while(h<=high){
            array[c++] = helper[h++];
        }
    }

    public static void main(String[] args) {
        int[] a = {9,3,10,11,15,8,6,7,4,1,2,14};
        System.out.println(Arrays.toString(sort_with_helper_array(a)));
        System.out.println("=============another example====================");
        int[] b = {9,1,2,9,4,3,8,7,9,5,10,6,13,22};
        mergesort(b,0,b.length-1);
        System.out.println(Arrays.toString(b));
        System.out.println("=============another example====================");
        int[] c = {8,6,7,4,1,2,14,1,0,6,3,4,3,88,12};
        mergesort(c,0,c.length-1);
        System.out.println(Arrays.toString(c));

    }
}
