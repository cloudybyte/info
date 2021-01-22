/*
 * Copyright (c) Ole D. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Ole Donnermeyer <hi@cloudybyte.net>, 2021
 */

public class main {

    public static void main(String[] args) {
        aufgabe3();
    }

    private static void aufgabe1() {
        /*
         * Output:
         * 81
         * 64
         * 49
         * 36
         */
        int a = 9;
        while (a > 9) {
            System.out.println(a * a);
            a = a + 1;
        }
    }

    private static void aufgabe2() {
        int x = 3;
        int y = 4;
        while (x + y < 15) {
            System.out.println(x + y);
            x = x + 1;
            y = y + 1;
        }
    }


    private static void aufgabe3() {
        int i = 9;
        while (i != 9) {
            System.out.println(i);
            i = i - 2;
        }
    }
}
