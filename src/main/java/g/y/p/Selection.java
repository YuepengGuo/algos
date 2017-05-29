package g.y.p;

import java.util.Arrays;

public class Selection {

    private static int[] sort(int[] in){
        for(int i =0;i<in.length;i++){
            //pivot as in[i]
            int min = i;
            for(int j=i;j<in.length;j++){
                if(in[j]<in[min]){
                    min = j;
                }
            }
            int t = in[i];
            in[i] = in[min];
            in[min] = t;

        }
        return in;
    }
    public static void main(String[] args) {
        int[] in = {6,4,2,7,9,1,3,5,8,8,100};
        System.out.println(Arrays.toString(sort(in)));
    }
}
