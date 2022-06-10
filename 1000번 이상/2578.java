package com.sparta.prac.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Student {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[][] arr1 = new String[5][5];
        int[][] arr2 = new int[5][5];

        // 빙고판 제작
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                String str = st.nextToken();
                arr1[i][j] = str;
            }
        }

        // 불리는 숫자와 같은 것을 골라 arr2 채우기
        int cnt = 1;
        for (int i = 0; i < 5; i++) {
            StringTokenizer stz = new StringTokenizer(br.readLine());            // arr2
            for (int j = 0; j < 5; j++) {                                        // 21 16 05 22 02
                String str2 = stz.nextToken();                                   // 04 13 10 11 15
                for (int k = 0; k < 5; k++) {                                    // 14 24 01 20 09
                    for (int l = 0; l < 5; l++) {                                // 17 06 08 19 23
                        if (arr1[k][l].equals(str2)) {                           // 07 25 03 18 12
                            arr2[k][l] = cnt;
                            cnt++;
                        }
                    }
                }
            }
        }

        // 빙고가 되는 수 list
        ArrayList<Integer> list = new ArrayList<>();

        // 가로 빙고
        for (int i = 0; i < 5; i++) {
            int line_max = 0;                  // 가로 빙고가 되려면 가로 한 줄이 모두 채워져야 함
            for (int j = 0; j < 5; j++) {      // 그게 그 줄의 최대값
                if (arr2[i][j] > line_max) {
                    line_max = arr2[i][j];
                }
            }
            list.add(line_max);               // 22, 15, 24, 23, 25
        }

        // 세로 빙고
        for (int i = 0; i < 5; i++) {
            int line_max = 0;
            for (int j = 0; j < 5; j++) {
                if (arr2[j][i] > line_max) {
                    line_max = arr2[j][i];
                }
            }
            list.add(line_max);              // 21, 25, 10, 22, 23
        }

        // 왼 -> 오 대각선
        int line_max = 0;
        for (int i = 0; i < 5; i++) {
            if (arr2[i][i] > line_max) {
                line_max = arr2[i][i];
            }
        }
        list.add(line_max);                 // 21

        // 오 -> 왼 대각선
        int line_max2 = 0;
        for (int i = 0; i < 5; i++) {
            if (arr2[i][4-i] > line_max2) {
                line_max2 = arr2[i][4-i];
            }
        }
        list.add(line_max2);                // 11

        Collections.sort(list);              //  10, 11, 15, 21, 22, 23, 24, 25
        System.out.println(list.get(2));     //  3번째까지만
    }
}

