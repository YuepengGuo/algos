package g.y.p;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int x = 1;
    	int y = 2;
    	System.out.println(x+" : "+y);
    	System.out.println(Integer.toBinaryString(x));
    	System.out.println(Integer.toBinaryString(y));
    	
    	System.out.println((x&y) + " : "+Integer.toBinaryString(x&y));
    	System.out.println((x|y)+" : "+Integer.toBinaryString(x|y));
    	System.out.println((x^y) +" : "+Integer.toBinaryString(x^y));


		Queue<Integer> q = new LinkedList<>();

        q.offer(3);
        q.offer(1);

        q.add(2);

        System.out.println(q);
    }
}
