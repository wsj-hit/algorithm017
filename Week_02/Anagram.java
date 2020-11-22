


public class Anagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        //字母相同 字母次数相同
        int[] chars = new int[256];

        char[] c1 = s.toCharArray();
        for (char c : c1) {
            chars[c] = chars[c] + 1;
        }
        char[] c2 = t.toCharArray();
        for (char c : c2) {
            chars[c] = chars[c] - 1;
        }
        for (int i : chars) {
            if (i != 0) return false;
        }
        return true;
    }


}
