class Solution {
    class Pair{
        char x;
        int count;

        public Pair(char c, int n){
            this.x = c;
            this.count = n;
        }
    }
    int time=0;

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

    for (char c : tasks) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->b.count-a.count
        );

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }

    int time=0;

    while(!pq.isEmpty()){
        List<Pair> temp = new ArrayList<>();

        int cycle = n+1;

        while(cycle>0&&!pq.isEmpty()){
            Pair p = pq.poll();
            p.count--;
            temp.add(p);
            time++;
            cycle--;
        }

        for (Pair p : temp) {
            if (p.count > 0) {
                pq.offer(p);
            }
        }
        if (!pq.isEmpty()) {
            time += cycle;
        }
    }
return time;
    }
        
}


// map 
// x=2
// y=2
// n=2

// 1. x







