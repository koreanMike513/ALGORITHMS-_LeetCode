class Solution {
    public boolean canChange(String start, String target) {
        int sp = 0, tp = 0, sl = start.length(), tl = target.length();

        if (sl != tl) return false;
        
        while (sp < sl || tp < tl) {
            while (sp < sl && start.charAt(sp) == '_') { sp++; }

            while (tp < tl && target.charAt(tp) == '_') { tp++; }

            char c1 = (sp < sl) ? start.charAt(sp) : '_';
            char c2 = (tp < tl) ? target.charAt(tp) : '_';
            
            if (((c1 != c2)) || (c1 == 'R' && sp > tp) || (c1 == 'L' && sp < tp)) {
                return false;
            }

            sp++; tp++;
        }
        
        if (sp < sl || tp < tl) return false;

        return true;
    }
}