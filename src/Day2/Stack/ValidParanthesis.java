package Day2.Stack;

import java.util.Stack;

public class ValidParanthesis {
    public static boolean paranthesis(String s){
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }
            else {
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if((c==')' && top!='(') || (c=='}' && top!='{') || (c==']' && top!='[')){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{()[]}";
        System.out.println(paranthesis(s));
    }
}
