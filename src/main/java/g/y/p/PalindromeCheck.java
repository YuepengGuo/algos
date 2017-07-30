package g.y.p;


public class PalindromeCheck {
    //two cursors
    public static boolean isPalindrome(String src){
        for(int i=0,j=src.length()-1;i<=j;i++,j--){
            if(src.charAt(i)!=src.charAt(j)){
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abaaba"));
    }
}
