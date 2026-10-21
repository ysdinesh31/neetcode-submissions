class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Task> map = new HashMap<>();
        for(char task : tasks) {
            if(map.containsKey(task)) {
                map.get(task).freq = map.get(task).freq + 1;
            } else {
                map.put(task, new Task(task));
            }
        }
        PriorityQueue<Task> heap = new PriorityQueue<>((Task a, Task b) ->{
            return b.freq - a.freq;
        });

        for(char c: map.keySet()) {
            heap.add(map.get(c));
        }

        int cycle = 1;
        PriorityQueue<Task> freeAt = new PriorityQueue<>((Task a, Task b) ->{
            return a.freeAt - b.freeAt;
        });

        while(heap.size() > 0 || freeAt.size() > 0) {

            while(freeAt.size() > 0 &&freeAt.peek().freeAt == cycle) heap.offer(freeAt.poll());
        if(heap.size() > 0){
            Task t = heap.poll();
            // System.out.print(t.name);
            t.freq = t.freq - 1;
            if(t.freq > 0) {
                t.freeAt = cycle + n + 1;
                freeAt.offer(t);
            }
        }
            cycle ++;
        }
        return cycle - 1;
    }
}

class Task{
    char name;
    int freq;
    public int freeAt;
    public Task(char name) {
        this.name = name;
        this.freq = 1;
        this.freeAt = 0;
    }
}
