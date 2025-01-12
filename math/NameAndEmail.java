import java.util.*;

public class NameAndEmail {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {

        HashMap<String, HashSet<String>> graph = new HashMap<>();  // 이메일-hashSet
        HashMap<String, String> name = new HashMap<>();            // 이메일-이름

        for (ArrayList<String> account : accounts) {
            String userName = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                name.put(account.get(i), userName);

                if (i == 1) {
                    continue;
                }

                graph.get(account.get(i)).add(account.get(i-1));  // 이메일끼리 연결
                graph.get(account.get(i-1)).add(account.get(i));
            }
        }

        HashSet<String> visited = new HashSet<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String email : graph.keySet()) {
            ArrayList<String> list = new ArrayList<>(); // 현재 기록용
            if (visited.add(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                result.add(list);
            }
        }


        return result;
    }

    public static void dfs(HashMap<String, HashSet<String>> graph, String email, HashSet<String> visited, ArrayList<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john_lab@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john02@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts = solution(accounts);
        for (ArrayList<String> item: accounts) {
            System.out.println(item);
        }
    }
}



/*
  문제설명
  이메일 정보를 병합하는 프로그램을 구현하려고 한다.
  이메일 정보가 들어있는 2차원 문자열 배열 accounts 가 주어졌고,
  각각의 accounts[i] 에 대해 accounts[i][0] 에는 사람 이름을, 나머지는 이메일을 나타낸다.
  
  
  주어진 이메일 정보에는 한 사람이 여러 이메일을 소유하기도, 동명이인이 있기도 하다.
  
  이름이 같고 이메일이 다르면 동명이인이다.
  이름이 같고 이메일 중 같은 이메일이 있으면 동일 인이다.
  주어진 이메일을 정보를 병합하고 출력하는 프로그램을 작성하세요.
  
  입출력 예시
  입력	결과
    "John", "john@mail.com", "john_lab@mail.com"
    "John", "john@mail.com", "john02@mail.com"
    "Mary", "mary@mail.com"
    "John", "johnnybravo@mail.com"	
  
  출력 결과
  "John, johnnybravo@mail.com"
  "John, john02@mail.com, john@mail.com, john_lab@mail.com"
  Mary, mary@mail.  com

문제해결 방법
 B - A - C
 D   E
 그래프와 같이 연결된 것을 표현해서 출력
*/
