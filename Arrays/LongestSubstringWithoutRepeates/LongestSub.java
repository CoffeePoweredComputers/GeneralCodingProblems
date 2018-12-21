class LongestSub {
    public int lengthOfLongestSubstring(String s) {

        //all of our states/storage containers
        HashSet<Character> map = new HashSet<Character>();
        int max = 0;
        int i = 0;
        int j = 0;
        
        //keep looking until we have reached the end of the string
        while(i < s.length() && j < s.length()){

            //if the letter is already found then remove it and advance the lower half of the window
            if(map.contains(s.charAt(j))){
                map.remove(s.charAt(i++));
            } 
            
            //otherwise add it and advance the upper bound of the window
            //also update the window as needed
            else{
                map.add(s.charAt(j++));
                
                //see if there is a new longest substring and update it if needed
                max = ((j-i) > max) ? (j - i) : max;
            }
        }
        
        return max;
    }
}