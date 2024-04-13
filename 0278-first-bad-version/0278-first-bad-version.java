/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long start = 0, end = n, ans = -1;

        while (start <= end) {
            long version = (start + end) / 2;
            
            if (isBadVersion((int) version)) {
                end = version - 1;
                ans = version;
            }

            else {
                start = version + 1;
            }
        }

        return (int) ans;
    }
}