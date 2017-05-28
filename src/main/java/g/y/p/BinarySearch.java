package g.y.p;

import java.util.Arrays;

public class BinarySearch {
    public static int rank(int key, int[] a){
        int l = 0;
        int h = a.length-1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(key < a[m]) h = m -1;
            else if (key > a[m]) l = m+1;
            else return m;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] list = {2,3,6,1,4,9,8,7,5};

        Arrays.sort(list);

        System.out.println(rank(1,list));
    }
}
