class TimeMap {
    static class Data{
        String val;
        int data;

        public Data(String v, int d){
            this.val =v;
            this.data =d;
        }
    }
    HashMap<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))return "";
        List<Data> list = map.get(key);

        int left =0,right =list.size()-1;

        String res = "";

        while(left<=right){
            int mid = left+(right-left)/2;

            if(list.get(mid).data<=timestamp){
                res =list.get(mid).val;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
    return res;

    }
}
