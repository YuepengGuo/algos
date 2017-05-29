package g.y.p;

import java.util.Arrays;

public class Insertion {
    private static void exchange(int[] a, int from,int to){
        int t = a[from];
        a[from] = a[to];
        a[to] = t;
    }
    private static void sort(int[] in){
        for(int i =1;i<in.length;i++){
            //pivot as in[i]
            for(int j=0;j<i;j++){
                //check until end of sorted subsection
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
