package com.sparta.prac.domain;

import java.util.Stack;

class Soluti {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int i : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i-1] != 0) {
                    basket.push(board[j][i - 1]);
                    board[j][i - 1] = 0;

                    if (basket.size() > 1) {
                        int n = basket.size();
                        if (basket.get(n-1) == basket.get(n-2)) {
                            basket.pop();
                            basket.pop();
                            answer += 2;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Soluti sol = new Soluti();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(sol.solution(board, moves));
    }
}


//
