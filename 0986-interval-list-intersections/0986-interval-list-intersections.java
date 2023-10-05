class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            if (firstList[i][1] <= secondList[j][1]) {
                int left = Math.max(firstList[i][0], secondList[j][0]);
                int right = Math.min(firstList[i][1], secondList[j][1]);

                if (left <= right && (secondList[j][0] <= firstList[i][1])) {
                    list.add(new int[] { left, right });
                }

                i++;
            }

            else {
                int left = Math.max(firstList[i][0], secondList[j][0]);
                int right = Math.min(firstList[i][1], secondList[j][1]);

                if (left <= right && (firstList[i][0] <= secondList[j][1])) {
                    list.add(new int[] { left, right });
                }

                j++;
            }
        }

        return list.toArray(new int[list.size()][2]);
    }
}