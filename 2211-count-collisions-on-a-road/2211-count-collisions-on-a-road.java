class Solution {
    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        
        int collision = 0;
        
        for (int i = 0; i < directions.length(); i++) {
            char car = directions.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == 'R' && car == 'L') {
                collision += 2;
                car = 'S';    
                stack.pop();
            }

            else if (!stack.isEmpty() && stack.peek() == 'S' && car == 'L') {
                collision++;
                car = 'S';    
                stack.pop();
            }

            while (!stack.isEmpty() && car == 'S' && stack.peek() == 'R') {
                collision++;
                stack.pop();
            }

            stack.push(car);
        } 

        return collision;
    }
}