package com.example.anything.ct;

import java.util.Arrays;

public class Test5 {

    public static void main(String[] args) {

        int[] happiness = {10,3,9,4,10,3,9,3,10,6};

        System.out.println(solution(happiness));

    }

    public static int solution(int[] happiness) {
        for (int lizDays = happiness.length; lizDays > 0 ; lizDays--) {
            for (int start = 0; start < happiness.length - lizDays + 1; start++) {

                int[] temp = Arrays.copyOfRange(happiness, start, start + lizDays);
                if(isLizPossible(temp))
                    return lizDays;

            }

        }
        return 0;
    }

    private static boolean isLizPossible(int[] days) {
        int possible =0;
        for (int day : days) {
            if (day > 8) {
                possible++;
            } else {
                possible--;
            }
        }
        return possible > 0;
    }

}
