// Sliding Window
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>(); // result
        if (words.length == 0) return res;
        
        Map<String, Integer> map = new HashMap<>(); // word occurance
        for (int i = 0; i < words.length; ++i) map.put(words[i], map.getOrDefault(words[i], 0) + 1);

        // Calculate string length
        int size = words.length;
        int len = words[0].length();
        int window = size * len;
        
        // Sliding window to check is string is valid
        for (int i = 0; i < s.length()-window+1; ++i) {
            String str = s.substring(i, i+window);
            if (containsAll(str, map, len)) res.add(i);
        }
        return res;
    }
    
    public boolean containsAll(String s, Map<String, Integer> map, int len) {
        // Store word occurance in string
        Map<String, Integer> temp = new HashMap<>();
        
        for (int i = 0; i < s.length(); i+=len) {
            String word = s.substring(i, i+len);
            int count = temp.getOrDefault(word, 0) + 1;
            // If string contains more wrods than words list, return false
            if (count > map.getOrDefault(word, 0)) return false;
            temp.put(word, count);
        }
        return true;
    } 
}
