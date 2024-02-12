import java.util.Stack;

public class StringReverse {
    public static void main(String[] args) {
    String st = "Dodovlski";
        System.out.println(reverse(st));


    }
    public static String reverse(String st){
        Stack<Character> stack = new Stack<>();
        char[] chars = st.toCharArray();

        for(char c : chars){
            stack.push(c);
        }
        for(int i =0; i < st.length();i++){
            chars[i] = stack.pop();
        }
        return new String(chars);
    }
}
