class Solution {
  public String intToRoman(int num) {
    String ans = "";
    Map<Integer, String> map = new HashMap<>();
    
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
    map.put(0, "");

    int div = 1000;

    while (num != 0) {
      int conv = num / div;
  
      if (!map.containsKey(conv * div)) {
        if (conv > 5) {
          ans += map.get(div * 5); 
          conv -= 5;
        }

        for (int i = 0; i < conv; i++) {
          ans += map.get(div);
        }
      }

      else {
        ans += map.get(conv * div);
      }

      num = num % div;
      div /= 10;
    }

    return ans;
  }
}