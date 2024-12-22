import java.util.ArrayList;

class Pibonacci {
    public static ArrayList<ArrayList<Integer>> solution(int N) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int x = result.get(i-1).get(j-1);
                    int y = result.get(i-1).get(j);
                    list.add(x + y);
                }
            }
            result.add(list);
        }
        return result;
    }



    public static void main(String[] args) {

        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(10));
    }
}
