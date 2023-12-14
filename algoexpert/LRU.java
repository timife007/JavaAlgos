package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    static class LRUCache {
        int maxSize;
        String recent = "";
        Map<String,  Integer> cache = new HashMap<>(maxSize);

        public LRUCache(int maxSize) {
            this.maxSize = Math.max(maxSize, 1);
        }

        public void insertKeyValuePair(String key, int value) {
            // Write your code here.
            if(cache.containsKey(key)){
                cache.replace(key,value);
            }else if(cache.size() == maxSize){
                int lowest = Integer.MAX_VALUE;
                String lowestKey = "";
                for(String i : cache.keySet()){
                    if(cache.get(i) < lowest){
                        lowestKey = i;
                        lowest = cache.get(i);
                    }
                }
                cache.remove(lowestKey);
                cache.put(key, value);
            }else{
                cache.put(key, value);
            }
            recent = key;
        }

        public LRUResult getValueFromKey(String key) {
            // Write your code here.
            recent = key;
            if(cache.containsKey(key)){
                return new  LRUResult(true, cache.get(key));
            }else{
                return null;
            }
        }

        public String getMostRecentKey() {
            // Write your code here.
            return recent;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

}
