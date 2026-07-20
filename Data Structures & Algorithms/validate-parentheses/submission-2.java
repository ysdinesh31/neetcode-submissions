class Solution {
    public boolean isValid(String s) {
        Deque<Character> queue = new LinkedList<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('[', ']');
        brackets.put('(', ')');
        brackets.put('{', '}');

        for (char c: s.toCharArray()) {
            if(brackets.containsKey(c)) {
                queue.addLast(c);
            } else if (queue.size() > 0 && brackets.get(queue.removeLast()) == c){
                continue;
            } else {
                return false;
            }
        }

        return queue.size() == 0;
    }
}
