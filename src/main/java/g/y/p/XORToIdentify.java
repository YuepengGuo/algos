package g.y.p;

public class XORToIdentify {
    public static void main( String[] args ){
        Integer i = new Integer(1^2^3^4^5^6^7^7);
        System.out.println(i);
        Integer ii = new Integer(1^2^3^4^5^6^7^4);
        System.out.println(ii);

        System.out.println(4^7);
    }
}
