class MyCalendarTwo {
    List<int[]> overlapping;
    List<int[]> nonOverlapping;

    public MyCalendarTwo() {
        overlapping = new ArrayList<>();
        nonOverlapping = new ArrayList<>();    
    }
    
    public boolean book(int start, int end) {
        for (int[] event : overlapping) {
            if (end > event[0] && start < event[1]) {
                return false;
            }
        }

        for (int[] event : nonOverlapping) {
            if (end > event[0] && start < event[1]) {
                overlapping.add(new int[]{ Math.max(start, event[0]), Math.min(end, event[1]) });
            }
        }

        nonOverlapping.add(new int[]{ start, end });

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */