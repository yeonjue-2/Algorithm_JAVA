package com.sparta.prac.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());                         // 테스트 수, 3

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int docu = Integer.parseInt(st.nextToken());                // 문서 수, 6
            int order = Integer.parseInt(st.nextToken());               // 내가 알고 싶은 문서의 현재 순서, 0

            LinkedList<int[]> list = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < docu; i++) {                                        // list에 넣기
                list.offer(new int[] {i, Integer.parseInt(st.nextToken()) });       // {0, 1}, {1, 1}, {2, 9},
            }                                                                       // {3, 1}, {4, 1}, {5, 1}

            int cnt = 0;                                      // 몇 번쨰에 출력 될지

            while (!list.isEmpty()) {
                int[] first = list.poll();                    // first = {0, 1} 빼내기
                boolean isMax = true;
                                                              // 하나 빠져서 list.size() = 5
                for (int i = 0; i < list.size(); i++) {       // i = 0,  list.get(0) = {1, 1}
                    if (first[1] < list.get(i)[1]) {          //         (1 < 1) -> if 문 x  -> for문
                        list.offer(first);                    // i = 1,  list.get(1) = {2, 9}
                                                              //         (1 < 9) -> if문 o  -> {0, 1} 넣기
                        for (int j = 0; j < i; j++) {         //          ->  {2, 9} 이전 list들 뒤로 넣기
                            list.offer(list.poll());          //              {1, 1} 뒤로 넣기
                        }
                        isMax = false;                        //      ->  list = {2, 9}, {3, 1}, {4, 1},
                        break;                                //                 {5, 1}, {0, 1}, {1, 1} -> while문
                    }
                }                                             // while문 -> first = {2, 9} 빼내기
                                                              // i = 0, list.get(0) = {3, 1}
                if (isMax == false) {                         //        (9 < 1) -> if문 x ->
                    continue;                                 //        다시 for i =1,...,5 ->if문 x -> cnt++(1)
                }                                             // while문 -> first = {3, 1} 뺴내기
                                                              // i = 0, list.get(0) = {4, 1}
                cnt++;                                        //        (1 < 1) -> if문 x -> ... -> cnt++(2)
                if (first[0] == order) {                      // while문 -> first = {4, 1} 뺴내기 -> cnt++(3)
                   break;                                     // while문 -> first = {5, 1} 뺴내기 -> cnt++(4)
                }                                             // while문 -> first = {0, 1} 뺴내기 -> cnt++(5)
            }                                                 //            first[0] == order  ->  break
            System.out.println(cnt);
        }
    }
}
