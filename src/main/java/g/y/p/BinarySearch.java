package g.y.p;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <pre>
 * low+1,
 * low<high
 * converge to low == high
 * duplicated!!!
 * the other direction first!!!
 * </pre>
 */
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


    /**
     * low+1,
     * low<high
     * converge to low == high
     * the other direction first
     *
     */
    public static int leftMost_desc(int[]a,int l,int h,int x){
        int m ;
        while(l<h){
            m = l +(h-l)/2;
            if(a[m]>x){// right half first
                l = m+1;
            }else{
                h = m;
            }
        }
        System.out.println("left at "+l+ " right at " +h);
        return l;
    }


    /**
     * low+1,
     * low<high
     * converge to low == high
     * the other direction first
     *
     */
    public static int leftMost_asc(int[]a,int l,int h,int x){
        int m ;
        while(l<h){
            m = l +(h-l)/2;
            if(a[m]<x){// right half first
                l = m+1;
            }else{
                h = m;
            }
        }
        System.out.println("left at "+l+ " right at " +h);
        return l;
    }
    /**
     * low+1,
     * low<high
     * converge to low == high
     * the other direction first
     *
     */
    public static int rightMost_desc(int[]a,int l,int h,int x){
        int m ;
        while(l<h){
            m = l +(h-l)/2;
            if(a[m]<x){//left part first
                h = m;
            }else{
                l = m+1;
            }
        }
        System.out.println("left at "+l+ " right at " +h);
        return l;
    }

    /**
     * low+1,
     * low<high
     * converge to low == high
     * the other direction first
     *
     */
    public static int rightMost_asc(int[]a,int l,int h,int x){
        int m ;
        while(l<h){
            m = l +(h-l)/2;
            if(a[m]>x){//left part first
                h = m;
            }else{
                l = m+1;
            }
        }
        System.out.println("left at "+l+ " right at " +h);
        return l;
    }

    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        // option 1
        Integer[] array = new Integer[]{1, 24, 4, 4, 23,4,12};
        Arrays.sort(array, comparator);

//        System.out.println(Arrays.toString(array));
        //         0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21
        int[] d = {5,5,5,5,4,4,4,3,3,3,2 ,1 ,1 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 };

        //         0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21
        int[] a = {0,0,0,0,0,0,0,1,1,1,1 ,2 ,3 ,3 ,3 ,4 ,4 ,4 ,5 ,5 ,5 ,5 };

//        System.out.println(leftMost(d,0,d.length-1,2));

        System.out.println(leftMost_desc(d,0,d.length-1,1));

        System.out.println(rightMost_desc(d,0,d.length-1,1));

        System.out.println(leftMost_asc(a,0,a.length-1,3));

        System.out.println(rightMost_asc(a,0,a.length-1,3));

    }
}
