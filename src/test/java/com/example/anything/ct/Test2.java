package com.example.anything.ct;

public class Test2 {

    public static void main(String[] args) {


        System.out.println(solution("ohouse", "oohoussse"));
        System.out.println(solution("bucketplace", "buckeeeetplaaaadce"));
    }

    public static boolean solution(String target, String typed) {

        return removeDuplicateWords(target).equals(removeDuplicateWords(typed));
    }

    public static String removeDuplicateWords(String str) {
        StringBuilder complete = new StringBuilder();
        char beforeChar = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != beforeChar) {
                complete.append(str.charAt(i));
            }
            beforeChar = str.charAt(i);

        }

        return complete.toString();
    }

}
