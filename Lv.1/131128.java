// 첫번째 풀이 - 시간초과
class Zoo {
    public String solution(String X, String Y) {
        String answer = "";
        ArrayList<String> li = new ArrayList<>();

        String[] strX = X.split("");
        String[] strY = Y.split("");
        ArrayList<String> arrX = new ArrayList<>(Arrays.asList(strX));
        ArrayList<String> arrY = new ArrayList<>(Arrays.asList(strY));

        for (int i = 0; i < arrX.size(); i++) {
            for (int j = 0; j < arrY.size(); j++) {
                if (arrX.get(i).equals(arrY.get(j))) {
                    li.add(arrX.get(i));
                    arrX.set(i, "x");
                    arrY.set(j, "y");
                    break;
                }
            }
        }

        Collections.sort(li, Collections.reverseOrder());

        if (li.size() > 0) {
            if (li.get(0).equals("0")) {
                answer = "0";
            } else {
                answer = String.join("", li);

            }
        } else {
            answer = "-1";
        }


        return answer;
    }
}

// 개선된 풀이
class Zoo {
    public String solution(String X, String Y) {
        String answer = "";
        ArrayList<String> li = new ArrayList<>();

        String[] strX = X.split("");
        String[] strY = Y.split("");

        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < 10; i++) { 		                // 0-9까지의 개수를 map 형태로 저장
            mapX.put(i, Collections.frequency(Arrays.asList(strX), String.valueOf(i)));
            mapY.put(i, Collections.frequency(Arrays.asList(strY), String.valueOf(i)));
        }

        for (int i = 0; i < 10; i++) {
            if (mapX.get(i) >= 1 && mapY.get(i) >= 1) {
                if (mapX.get(i) >= mapY.get(i)) {
                    for (int j = 0; j < mapY.get(i); j++) {
                        li.add(String.valueOf(i));
                    }
                } else {
                    for (int j = 0; j < mapX.get(i); j++) {
                        li.add(String.valueOf(i));
                    }
                }
            }
        }

        Collections.sort(li, Collections.reverseOrder());
		    // 내림차순 정렬
        
        if (li.size() > 0) {
            if (li.get(0).equals("0")) {
                answer = "0";
            } else {
                answer = String.join("", li);

            }
        } else {
            answer = "-1";
        }
        
        return answer;
    }
