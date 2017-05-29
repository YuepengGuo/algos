package g.y.p;

import java.util.Arrays;

/**
 *
 * We maintain a subset of elements sorted within a list, the remaining elements are off to the side somewhere.
 * Initially, think of the first element in the array as a sorted list of length one.
 * Once at a time, we take one of the elements that is off to the side
 * and we insert it into the sorted list where it belongs.
 * This gives a sorted list that is one element longer that it was before.
 * When the last element has been inserted, the array is completely sorted.
 */
public class Insertion {
    private static void exchange(int[] a, int from,int to){
        int t = a[from];
        a[from] = a[to];
        a[to] = t;
    }
    private static void sort(int[] in){
        //unsorted set
        for(int i =1;i<in.length;i++){
            //pivot as in[i]
            //sorted subset, init state is in[0]
            //we will insert next item into this sorted sublist
            for(int j=0;j<i;j++){
                //check until end of sorted subsection, performance can be improved by binary-search target insert location
                if(in[j]>in[i]){
                    exchange(in,j,i);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] in = {6,4,2,7,9,1,3,5,8,100,100};
        sort(in);
        System.out.println(Arrays.toString(in));
    }
}
