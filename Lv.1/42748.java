class Zoo {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];


        for (int i = 0; i < commands.length; i++) {
            int a = commands[i][0];
            int b = commands[i][1];
            int c = commands[i][2];

            ArrayList<Integer> arr = new ArrayList<>();

            for (int j = a-1; j < b; j++) {
                arr.add(array[j]);
            }

            Collections.sort(arr);

            answer[i] = arr.get(c-1);
        }

        return answer;
    }
}
