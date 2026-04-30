class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false ; 
        int[] freq1 = new int[26] ; 
        int[] freq2 = new int[26] ; 
        int left = 0 ;

        for(char c : s1.toCharArray()){
            freq1[c - 'a']++ ; 
        }

        for(int right = 0 ; right < s2.length() ; right++){
            char ch = s2.charAt(right) ; 
            freq2[ch-'a']++ ; 

            if((right - left + 1) > s1.length()){
                freq2[s2.charAt(left) - 'a']-- ; 
                left++ ; 
            }

            if(matched(freq1 , freq2)) return true ; 
        }
        return false ; 
    }

    private static boolean matched(int[] a , int[] b){
        for(int i = 0 ; i < a.length ; i++){
            if(a[i] != b[i]) return false ; 
        }
        return true ; 
    }
}
