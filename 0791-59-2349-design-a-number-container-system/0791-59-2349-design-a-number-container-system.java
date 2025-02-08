class NumberContainers {

    private Map<Integer, TreeSet<Integer>> numberToIndices;
    private Map<Integer, Integer> indexToNumbers;

    public NumberContainers() {
        numberToIndices = new HashMap<>();
        indexToNumbers = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumbers.containsKey(index)) {
            int previousNumber = indexToNumbers.get(index);
            numberToIndices.get(previousNumber).remove(index);

            if (numberToIndices.get(previousNumber).isEmpty()) 
                numberToIndices.remove(previousNumber);
            
        }

        indexToNumbers.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {        
        return (numberToIndices.containsKey(number)) 
            ? numberToIndices.get(number).first()
            : -1;
    }
}
/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index, number);
 * int param_2 = obj.find(number);
 */