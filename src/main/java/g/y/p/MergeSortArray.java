package g.y.p;

import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class MergeSortArray {

//    static int[] sort(int[] ar) {
//        int m = l + (h-l)/2;
//        a[l,m]
//        a[m+1,h]
//
//    }

    static int[] sort(int[] ar) {
        if (ar.length == 1 ) {
            return ar;
        }
        int mid = ar.length / 2;
        int[] ar1 = copyOfRange(ar, 0, mid);//mid is exclusive
        int[] ar2 = copyOfRange(ar, mid, ar.length);//mid is inclusive
        return merge(sort(ar1), sort(ar2));
    }

    private static int[] merge(int[] in1, int[] in2) {
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


    public static void main(String[] args) {
        int[] a = {1,3,7,2,4,6,8,9,10,5};
        int mid = a.length /2;
        System.out.println(Arrays.toString(copyOfRange(a,0,mid)));
        System.out.println(Arrays.toString(copyOfRange(a,mid,a.length)));
        int[] m = {1,2,3,4,5};
        int[] n = {3,5,6,8};
        int[] c = merge(m,n);
        System.out.println(Arrays.toString(sort(a)));
//        System.out.println(Arrays.toString(n));
    }
}
