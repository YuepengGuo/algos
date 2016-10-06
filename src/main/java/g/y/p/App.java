package g.y.p;

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
        
    }
}
