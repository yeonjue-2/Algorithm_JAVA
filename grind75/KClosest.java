class KClosest {
    // 시간 복잡도 O(nlogn)
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;

        for (int[] point : points) {
            int distance = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
            map.put(idx++, distance);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(Comparator.comparing(map::get));

        int[][] result = new int[k][0];
        for (int i = 0; i < k; i++) {
            int key = keySet.get(i);
            result[i] = new int[]{points[key][0], points[key][1]};
        }

        return result;
    }

    // 시간 복잡도 O(nlogk)
    // 위 메서드처럼 모든 값을 다 가지고 있을 필요없음
    public int[][] kClosest2(int[][] points, int k) {
        // 우선순위 큐를 사용하여 k개의 가장 가까운 점을 구하기
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])  // 내림차순, 큰 값이 우선순위, maxHeap으로 동작
        );
    
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
    
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
    
        return result;
    }
}

// QuickSelect 알고리즘 O(n)
public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);

        // 결과 배열에 가장 가까운 k개 점을 넣기
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = points[i];
        }

        return result;
    }

    private void quickSelect(int[][] points, int left, int right, int k) {
        if (left < right) {
            int pivotIndex = partition(points, left, right);

            if (pivotIndex == k) {
                return;
            } else if (pivotIndex < k) {
                quickSelect(points, pivotIndex + 1, right, k);
            } else {
                quickSelect(points, left, pivotIndex - 1, k);
            }
        }
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[right];
        int pivotDistance = getDistance(pivot);

        int i = left;
        for (int j = left; j < right; j++) {
            if (getDistance(points[j]) < pivotDistance) {
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, right);
        return i;
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}

