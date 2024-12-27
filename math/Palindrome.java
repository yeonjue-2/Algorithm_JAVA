import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Palindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        Deque<String> deque = new ArrayDeque<>();
        int isPalindrome = 1;

        Arrays.stream(arr).forEach(s -> deque.addLast(s));

        while (!deque.isEmpty()) {
            String a = deque.pollFirst();
            String b = deque.pollLast();

            if (a != null & b != null && !a.equals(b)) {
                isPalindrome = 0;
                break;
            }
        }

        System.out.println(isPalindrome);

    }
}


// https://www.acmicpc.net/problem/10988
