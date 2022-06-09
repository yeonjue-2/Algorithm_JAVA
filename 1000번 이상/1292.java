package com.sparta.prac.domain;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int sum =0 ;
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < i+1; j++) {
                list.add(i+1);
            }
        }

        for (int i = N-1; i < M ; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}
