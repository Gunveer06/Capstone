package Day2.String;

import java.util.*;

public class ValidPalinderome {
    public static boolean palinderome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(palinderome(s));
    }
}
