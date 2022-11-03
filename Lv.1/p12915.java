class Zoo {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Map<String, String> map = new HashMap<>();

        for (int i=0; i < strings.length; i++) {
            map.put(strings[i], String.valueOf(strings[i].charAt(n)));
        }

        List<Map.Entry<String, String>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue());

        for (int i=0; i<entryList.size(); i++) {
            answer[i] = entryList.get(i).getKey();
        }

        return answer;
    }
 }
