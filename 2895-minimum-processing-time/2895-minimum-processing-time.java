class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int[] processor = processorTime.stream().mapToInt(Integer::intValue).toArray();
        int[] task = tasks.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(processor);
        Arrays.sort(task);

        int ans = 0, j = task.length - 1;

        for (int i = 0; i < processor.length; i++, j -= 4) {
            ans = Math.max(ans, processor[i] + task[j]);
        }

        return ans;
    }
}