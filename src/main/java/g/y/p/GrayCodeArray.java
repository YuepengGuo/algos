package g.y.p;

/**
 <pre>
 The n bit binary reflected Gray code is defined recursively as follows:

 the n−1 bit code, with 0 prepended to each word, followed by
 the n−1 bit code in reverse order, with 1 prepended to each word.
 </pre>
 */
public class GrayCodeArray {


    public static void show(boolean[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i]) System.out.print(1);
            else      System.out.print(0);
        System.out.println();
    }

    public static void yarg(int n, boolean[] a) {
        if (n == 0) show(a);
        else {
            a[n] = true;
            gray(n-1, a);
            a[n] = false;
            yarg(n-1, a);
        }
    }

    public static void gray(int n, boolean[] a) {
        if (n == 0) show(a);
        else {
            a[n] = false;
            gray(n-1, a);
            a[n] = true;
            yarg(n-1, a);
        }
    }


    public static void main(String[] args) {
//        int n = Integer.parseInt(args[0]);
        int n = 3;
        boolean[] a = new boolean[n+1];

        gray(n, a);

    }

}
