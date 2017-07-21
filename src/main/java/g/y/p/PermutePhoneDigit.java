package g.y.p;

public class PermutePhoneDigit {

    private static char[][] keypad={
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','s','r'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    private static void combine(char[][] keypad, int [] input,String accumulate,int index){
        //P(1) = 1
        if(index == -1){
            System.out.println(accumulate);
            return;
        }

        int currentdigit = input[index];

        int len = keypad[currentdigit].length;

        //P(N+1) = COMBINE(P(N)+Ai)
        for(int i=0;i<len;i++){
            combine(keypad,input,keypad[currentdigit][i] +accumulate,index-1);
        }
    }

    public static void main(String[] args) {
        int[] input = {2,3,4};
        combine(keypad,input,"",input.length-1);
    }

}
