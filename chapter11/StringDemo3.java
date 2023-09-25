package chapter11;

/**String 常用方法*/

public class StringDemo3 {
    public static void main(String[] args) {
        String china = "中国";
        String description = "热爱和平";
    
        System.out.println(china.concat(description));

        String testStr = "      a b        ";
        System.out.println("-----" + myTrim(testStr) + "-----");

        String testStr2 = "ab1234567890a";
        System.out.println(reverse(testStr2, 0, testStr2.length()));

        System.out.println(counts("abkkcadkabkebfkabkskab", "ab"));
        System.out.println(getMaxSameSubString("abcwerthelloyuiodef", "cvhellobnm"));

    }

    public static String myTrim(String str){
        /*去除字符串两端的空格*/
        if (str != null) {
            int startIdx = 0;
            int endIdx = str.length() - 1;

            while (startIdx < endIdx && str.charAt(startIdx) == ' ') {
                startIdx++;
            }

            while (startIdx < endIdx && str.charAt(endIdx) == ' ') {
                endIdx--;
            }

            if (str.charAt(startIdx) == ' ') {
                // str全是空格组成的
                return "";
            }
            return str.substring(startIdx, endIdx + 1); 
        }

        return null;
    }

    /** 将一个字符串进行反转。
     * 将字符串中指定部分进行反转。
     * 比如“abcdefg”反转为”abfedcg” */
    public static String reverse(String origin, int start, int end){
        if (origin != null) {
            start = start < 0 ? 0: start;
            end = end > origin.length() - 1 ? origin.length() - 1: end;

            char[] originChars = origin.toCharArray();
            char tmp;
            for (;start < end; start++, end--){
                tmp = originChars[start];
                originChars[start] = originChars[end];
                originChars[end] = tmp;
            }
            return new String(originChars);
        }
        return null;
    }

    /**获取一个字符串在另一个字符串中出现的次数。
     * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数*/
    public static int counts(String origin, String target){
        if (origin == null || target == null || origin.length() < target.length()){
            return 0;
        }

        int oLen = origin.length();
        int tLen = target.length();
        int count = 0;
        String tmp;

        for (int i = 0; i + tLen <= oLen; i++){
            tmp = origin.substring(i, i+tLen);
            if (tmp.equals(target)){
                count += 1;
            }
        }
        return count;
    }

    /**
     * 获取两个字符串中最大相同子串。
     * 比如：str1 = "abcwerthelloyuiodef“;
     * str2 = "cvhellobnm".
     * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    */
    public static String getMaxSameSubString(String str1, String str2){
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLength = 0;
        int endIndex = 0;

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }

        return str1.substring(endIndex - maxLength + 1, endIndex + 1);
    }

}
