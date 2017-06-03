package g.y.p;

import java.util.Arrays;

/**
 * we maintain that the k smallest of the elements are sorted in a list.
 * The larger element are in a set on the side.
 * Initially, with k=0, all elements are in the set. sorted list are empty set.
 * Progress is made by finding the smallest element in the remaining set of large elements
 * and adding the selected element at the end of the sorted list of elements.
 * This increases k by one.
 * Stop with k = n.
 * At this point, all the elements have been selected and the listed is sorted.
 */
public class Selection {

    private static void sort(int[] in){
        for(int i =0;i<in.length;i++){
            //pivot as in[i], in[0..i-1] already sorted
            int min = i;
            //find the kth smallest element
            for(int j=i;j<in.length;j++){
                if(in[j]<in[min]){
                    min = j;
                }
            }
            int t = in[i];
            in[i] = in[min];
            in[min] = t;

        }
    }
    public static void main(String[] args) {
        int[] in = {6,4,2,7,9,1,3,5,8,8,100};
        sort(in);
        System.out.println(Arrays.toString((in)));
    }
}
