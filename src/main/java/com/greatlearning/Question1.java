package com.greatlearning;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Question1 {

    public static void run() {

        System.out.print("Enter the input string of brackets: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (isValid(str)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered String does not have Balanced Brackets");
        }
    }

    private static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> openingBracket = new HashMap<>();
        openingBracket.put(')', '(');
        openingBracket.put('}', '{');
        openingBracket.put(']', '[');

        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case '(', '{', '[' -> st.push(s.charAt(i));
                default -> {
                    if (st.empty()) {
                        return false;
                    }
                    if (st.peek() != openingBracket.get(s.charAt(i))) {
                        return false;
                    }
                    st.pop();
                }
            }
        }
        return st.empty();
    }
}
