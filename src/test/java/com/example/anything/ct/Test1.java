package com.example.anything.ct;

public class Test1 {

    public static void main(String[] args) {

        String[][] arr = {{"W", "W", "B"}, {"W", "B", "W"}, {"B", "W", "W"}, {"B", "W", "W"}};

        System.out.println(solution(arr));
    }

    public static int solution(String[][] arr) {
        int result = 0;


        //m = 4 , n = 3
        for (int m = 0; m < arr.length; m++) {
            for (int n = 0; n < arr[0].length; n++) {
                if (arr[m][n].equals("B") && checkAlone(m, n, arr)) {
                    result ++ ;
                }
            }
        }

        return result;
    }

    public static boolean checkAlone(int m, int n, String[][] arr) {
        int row = 0;
        int col = 0;

        for (int j = 0; j < arr[0].length; j++) {
            if (arr[m][j].equals("B")) {
                row ++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][n].equals("B")) {
                col ++;
            }
        }
        return row == 1 && col == 1;

    }

}
