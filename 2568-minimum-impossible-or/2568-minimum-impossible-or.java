class Solution {
public int minImpossibleOR(int[] nums) {
      Set<Integer> set = new HashSet<>();
      
      for (int n : nums) {
          if (n == 1 || (n & 1) == 0) 
            set.add(n);   
      }
        int c = 1; 

        while (true) {
            if (!set.contains(c)) 
                return c;

            c *= 2; 
        }
    }
}