class TimeMap {
    static class Data{
        String val;
        int times;

        public  Data(String v, int t){
            this.val = v;
            this.times=t;
        }
    }
    HashMap<String,List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Data(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
    if (!map.containsKey(key)) return "";

        List<Data> list = map.get(key);

        int left = 0, right = list.size() - 1;
        String res = "";

        // Binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).times <= timestamp) {
                res = list.get(mid).val; // possible answer
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
