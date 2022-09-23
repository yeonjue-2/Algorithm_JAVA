public class Pracc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = 0;
        int cnt = 0;

        while (true) {
            a++;
            cnt += a;

            if (cnt > N) {
                if (a%2 == 0) {
                    int sum = a + 1;
                    int ord = N - (cnt - a);   // 해당 행에서 몇번째인지
                    System.out.println(ord + "/" + (sum - ord));
                } else {
                    int sum = a + 1;
                    int ord = N - (cnt - a);
                    System.out.println((sum - ord) + "/" + ord);
                }

                break;
            }
        }
    }
}
