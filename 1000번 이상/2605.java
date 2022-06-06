import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            list.add(i-1-num, i);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(list.get(i) + " ");

        }
    }
}

