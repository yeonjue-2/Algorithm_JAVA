// 이중 for문으로 시간초과

public String solution(String[] participant, String[] completion) {
        String answer = "";

        for (int i = 0; i < completion.length; i++) {
            for (int j = 0; j < participant.length; j++) {
                if (completion[i].equals(participant[j])) {
                    completion[i] = "";
                    participant[j] = "";
                }
            }
        }

        for (int i = 0; i < participant.length; i++) {
            if (!participant[i].equals("")) {
                answer = participant[i];
            }
        }


        return answer;
    }
}


// HashSet 사용 풀이
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> runner = new HashMap<>();

        for (String a : participant) {
            runner.put(a, runner.getOrDefault(a, 0) + 1);
        }

        for (String b :completion ) {
            runner.put(b, runner.get(b) - 1);
        }

        for (String key : runner.keySet()) {
            if (runner.get(key) != 0) {
                answer = key;
                break;
            }
        }


        return answer;
    }
