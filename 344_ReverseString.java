public class Solution {
    //5ms
    public String reverseString(String s) {
        if(s==null || s.length()<=0){
            return s;
        }
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }
    
    //3ms
     public String reverseString(String s) {
        if(s==null || s.length()<=0){
            return s;
        }
        int len = s.length()-1;
        char[] cs = s.toCharArray();
        for(int i=0,j=len ; i<j;i++,j--){
            char tc = cs[i];
            cs[i]=cs[j];
            cs[j]=tc;
        }
        return new String(cs);
    }
}
