import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityCounter {

    static class Customer {
        int id;
        int w;

        public Customer(int id, int w) {
            this.id = id;
            this.w = w;
        }
    }

    static class Counter implements Comparable<Counter> {
        int no;
        int id;
        int time;

        public Counter(int no, int id, int time) {
            this.no = no;
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Counter o) {
            if (this.time < o.time) {
                return -1;
            } else if (this.time == o.time) {
                if (this.no < o.no) {          // 동시에 끝나는 계산대에서는 번호가 큰 계산대에서 먼저 나감
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return 1;
            }
        }
    }

    public static ArrayList<Integer> solution(int k, int[][] customers) {

        if (customers == null || customers.length == 0 || customers[0].length == 0) {
            return null;
        }

        int n = customers.length;

        Queue<Customer> waitQue = new LinkedList<>();                    // 계산 대기 고객관리 큐
        for (int i = 0; i < n; i++) {
            waitQue.offer(new Customer(customers[i][0], customers[i][1]));
        }

        PriorityQueue<Counter> pqCounter = new PriorityQueue<>();        // 계산대 우선순위 큐, 작은값 우선
        for (int i = 0; i < k; i++) {
            Customer customer = waitQue.poll();

            if (customer != null) {
                pqCounter.offer(new Counter(i, customer.id, customer.w));
            }
        }

        PriorityQueue<Integer> pqCounterDone = new PriorityQueue<>();    // 계산이 끝난 카운터 (다음 손님을 받을 수 있음)

        int curTime = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (!pqCounter.isEmpty()) {
            Counter counter = pqCounter.poll();

            result.add(counter.id);                     // 계산 끝난 손님
            curTime = Math.max(curTime, counter.time);
            pqCounterDone.offer(counter.no);            // 계산 끝난 카운터

            while (!pqCounter.isEmpty()) {
                if (pqCounter.peek().time == curTime) {
                    Counter c = pqCounter.poll();
                    result.add(c.id);
                    pqCounterDone.offer(c.no);
                } else {
                    break;
                }
            }

            // 다음 기다리는 손님을 계산대에 배치
            while (!pqCounterDone.isEmpty()) {
                Customer customer = waitQue.poll();
                if (customer != null) {
                    pqCounter.offer(new Counter(pqCounterDone.poll(), customer.id, curTime + customer.w));
                } else {
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[][] customers = {{1, 4}, {2, 5}, {3, 14}, {4, 1}, {5, 7}, {6, 5}, {7, 7}, {8, 5}, {9, 10}, {10, 3}};
        System.out.println(solution(3, customers));
    }
}


/*
  문제 설명
  
  K개의 계산대가 있는 쇼핑몰에서,    
  N 명의 고객이 물건을 고르고 계산을 하기 위해 계산대 앞에 줄을 서 있다.
  
  고객은 먼저 온 순서대로 계산대에 가서 계산을 진행하는데  
  어떤 계산대에 줄을 설지는 안내원의 도움을 받는다.
  
  안내원은 다음과 같은 규칙으로 고객을 계산대로 안내한다.  
  * 비어 있는 계산대 중 계산대 번호가 작은 쪽으로 안내
  * 계산대가 꽉 차있는 경우 먼저 끝나는 쪽으로 안내
  * 동시에 끝나는 계산대가 있다면 계산대 번호가 작은쪽으로 안내
   
  계산대에서 계산을 마친 손님은 쇼핑몰을 빠져 나가는데,  
  동시에 계산을 마친 손님이 있는 경우 계산대 번호가 높은 쪽부터 먼저 나가도록 한다.
  
  계산대에서 계산을 하는데 걸리는 시간의 경우,   
  물건 개수가 w 인 경우 w 분만큼 소요된다.
  
  2차원 배열 customers 에 고객 번호와 물건 개수에 대한 정보가 주어졌을 때,  
  계산을 마치고 나오는 고객 순서대로 출력하는 프로그램을 작성하세요.
  
  입출력 예시
  customers
  {{1, 4}, {2, 5}, {3, 14}, {4, 1}, {5, 7}, {6, 5}, {7, 7}, {8, 5}, {9, 10}, {10, 3}}
  결과
  1, 2, 4, 6, 5, 3, 7, 8, 10, 9
*/
