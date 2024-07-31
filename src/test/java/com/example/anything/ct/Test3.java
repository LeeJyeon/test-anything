package com.example.anything.ct;

import java.util.HashMap;

public class Test3 {
    static int answer = 0;
    static int newWorld = 10;

    public static void main(String[] args) {


        int[][] grid = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 0, 1}, {0, 0, 1, 1}};


        System.out.println(solution(grid));

    }

    public static int solution(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = -1 * grid[i][j];
            }
        }


        while (continueCheck(grid)) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != 0) {

                        grid[i][j] += (i + 1) * 2;

                        try {
                            int t1 = grid[i - 1][j];
                            if (t1 > 0) {
                                grid[i - 1][j] = grid[i][j];
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {

                        }

                        try {
                            int t2 = grid[i + 1][j];
                            if (t2 > 0) {
                                grid[i + 1][j] = grid[i][j];
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {

                        }

                        try {
                            int t3 = grid[i][j - 1];
                            if (t3 > 0) {
                                grid[i][j - 1] = grid[i][j];
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }

                        try {
                            int t4 = grid[i][j + 1];
                            if (t4 > 0) {
                                grid[i][j + 1] = grid[i][j];
                            }
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                    }
                }
            }
        }


        HashMap<Integer, Integer> count = new HashMap<>();


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    count.put(grid[i][j], count.getOrDefault(grid[i][j], 0) + 1);
                }
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
        }

        int maxIsland = 0;
        for (Integer i : count.keySet()) {
            maxIsland = Math.max( maxIsland , count.get(i));
        }
        return maxIsland;
    }

    public static boolean continueCheck(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
