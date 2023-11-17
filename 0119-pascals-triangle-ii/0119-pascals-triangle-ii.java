class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        triangle.add(List.of(1));

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for (int j = 2; j <= i; j++) {
                currentRow.add(prevRow.get(j - 2) + prevRow.get(j - 1));
            }

            currentRow.add(1);
            triangle.add(currentRow);
        }

        return triangle.get(rowIndex);
    }
}