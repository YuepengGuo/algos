package g.y.p;


import java.util.Stack;

public class TwoStackExpr {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        "(1+((2+3)*(4*5)))".chars().forEach(c->{
            if(c=='('){
                //ignore (
            }else if(c=='+' ||c=='-'||c=='*'||c=='/'){
                ops.push(Character.toString((char)c));
            }else if(c==')'){
                String op = ops.pop();
                double v = vals.pop();
                if(op.equals("+")){
                    v = vals.pop() + v;
                }else if(op.equals("-")){
                    v = vals.pop() - v;
                }else if(op.equals("*")){
                    v = vals.pop() * v;
                }else if(op.equals("/")){
                    v = vals.pop() / v;
                }
//                System.out.println(v);
                vals.push(v);
            }else{
                vals.push((double)Character.getNumericValue(c));
            }
        });

        System.out.println(vals.pop());

    }
}
