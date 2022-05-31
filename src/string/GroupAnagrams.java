package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/group-anagrams/submissions/
 */
public class GroupAnagrams {

    /**
     * 通过对每个字符串进行hashCode转换，做映射
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String str : strs) {
            String hashCode = hash(str);
            List<String> list = groupMap.getOrDefault(hashCode, new ArrayList<String>());
            list.add(str);
            groupMap.put(hashCode, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> l : groupMap.values())
            res.add(l);
        return res;
    }

    /**
     * 自定义计算字符串的hashCode
     * @param s
     * @return
     */
    public String hash(String s) {
        int[] hashArray = new int[26];
        for (char c : s.toCharArray())
            hashArray[c - 'a']++;
        StringBuffer res = new StringBuffer();
        for (int i : hashArray)
            res.append(i + ".");
        return res.toString();
    }
}
