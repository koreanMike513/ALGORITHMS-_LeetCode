class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int left = 0, right = skill.length - 1, chem = skill[left] + skill[right];
        long sum = 0;

        while (left < right) {
            int t = skill[left] + skill[right];

            if (t != chem) {
                return -1;
            }
            
            else {
                sum += skill[left] * skill[right];
            }

            left++; right--;
        }

        return sum;
    }
}