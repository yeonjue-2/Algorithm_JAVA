public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();   // 과목별 들어야하는 선수과목 리스트
        int[] indegree = new int[numCourses];            // 진입차수 (선수과목 수)

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int a = pair[0];
            int b = pair[1];
            graph.get(b).add(a);
            indegree[a]++;  //
        }

        Queue<Integer> queue = new LinkedList<>();    // 선수과목이 없는 것들만 queue에 넣기
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return count == numCourses;
    }
}
