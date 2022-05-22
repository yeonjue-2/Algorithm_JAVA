import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int[] stack;
    public static int size = 0;
    public static int first = 0;

    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if(size - first == 0) {
            return -1;
        }
        else {
            int res = stack[first];
            first++;
            return res;
        }
    }

    public static int size() {
        return size - first;
    }

    public static int empty() {
        if(size - first == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int front() {
        if(size - first == 0) {
            return -1;
        }
        else {
            return stack[first];
        }
    }

    public static int back() {
        if(size - first == 0) {
            return -1;
        }
        else {
            return stack[size - 1];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        stack = new int[N];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append('\n');
                    break;
                case "size":
                    sb.append(size()).append('\n');
                    break;
                case "empty":
                    sb.append(empty()).append('\n');
                    break;
                case "front":
                    sb.append(front()).append('\n');
                    break;
                case "back":
                    sb.append(back()).append('\n');
                    break;
            }

        }
        System.out.println(sb);
    }
}