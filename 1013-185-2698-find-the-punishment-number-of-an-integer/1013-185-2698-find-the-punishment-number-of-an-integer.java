class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (checkPunishimentNumber(i, 0, String.valueOf(i * i), 0))
                sum += i * i;
        }

        return sum;
    }

    private boolean checkPunishimentNumber(
        int num, 
        int sum,
        String squared, 
        int idx
        ) {

        if (idx >= squared.length())
            return num == sum;

        for (int i = idx + 1; i <= squared.length(); i++) {
            int t = Integer.parseInt(squared.substring(idx, i));
            
            if (checkPunishimentNumber(num, sum + t, squared, i))
                return true;
        }

        return false;
    }
}