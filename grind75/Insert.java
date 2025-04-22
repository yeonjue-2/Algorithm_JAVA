public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int start = newInterval[0];
        int end = newInterval[1];

        ArrayList<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            int curStart = interval[0];
            int curEnd = interval[1];

            if (interval[1] < start) {
                result.add(interval);
            } else if (interval[0] > end) {
                result.add(interval);
            } else {
                start = Math.min(curStart, start);
                end = Math.max(curEnd, end);
            }
        }

        result.add(new int[]{start, end});

        result.sort(Comparator.comparingInt(a -> a[0]));

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }

        return res;
    }


  // 위 과정에서 정렬로 인해 시간복잡도가 증가(O(NlogN))
  // 아예 순서대로 넣어주도록 변경
  public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();
        int i=0;
        int n= intervals.length;
    
        while(i<n && intervals[i][1]<newInterval[0]){
            mergedIntervals.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]= Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]= Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        mergedIntervals.add(newInterval);
    
        while(i<n){
             mergedIntervals.add(intervals[i]);
             i++;
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}



