package com.kmcho.alg;

import java.util.Scanner;

public class UtopianTree {
    static int utopianTree(int n) {
        return (1 << (n + 1) / 2 + 1) - 1 - n % 2;
//        return ~(~1 << ((n + 1) >> 1)) - n % 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = utopianTree(n);
            System.out.println(result);
        }
        in.close();
    }
}
