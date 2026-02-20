class Solution {

    class Task implements Comparable<Task>{
        int freq = 0;
        int executionTime = 0;

        public Task(int freq,int executionTime){
            this.freq = freq;
            this.executionTime = executionTime;
        }

        public int compareTo(Task task){
            return task.freq - this.freq;   // max heap by freq
        }
    }

    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> freqMap = new HashMap<>();
        for(Character ch: tasks){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>();
        for(Character ch: freqMap.keySet()){
            pq.offer(new Task(freqMap.get(ch),0));
        }

        Queue<Task> queue = new LinkedList<>();

        int time = 0;

        while(!queue.isEmpty() || !pq.isEmpty()){
            time++;

            // Execute highest frequency task
            if(!pq.isEmpty()){
                Task task = pq.poll();
                task.freq--;

                if(task.freq > 0){
                    task.executionTime = time + n;
                    queue.offer(task);
                }
            }

            // Check if cooling completed
            if(!queue.isEmpty() && queue.peek().executionTime == time){
                pq.offer(queue.poll());
            }
        }

        return time;
    }
}