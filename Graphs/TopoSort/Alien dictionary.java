
class Solution {
    public String findOrder(String[] words) {
        // code here
        
        List<List<Character>> adj=new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        
        int len=words.length;
        int indegree[]=new int[26];
        boolean present[]=new boolean[26];
        
        for(String word:words){
            for(char c:word.toCharArray()){
                present[c-'a']=true;
            }
        }
        
        for(int i=0;i<len-1;i++){
            
            String word1=words[i];
            String word2=words[i+1];
            
            int j=0,k=0;
            while(j<word1.length() && k<word2.length()){
                if(word1.charAt(j)!=word2.charAt(k)){
                    adj.get(word1.charAt(j)-'a').add(word2.charAt(k));
                    indegree[word2.charAt(k)-'a']++;
                    break;
                }
                j++;
                k++;
            }
        }
        
        StringBuilder sb=new StringBuilder();
        Queue<Character> que=new LinkedList<>();
        for(int i=0;i<26;i++){
            if(present[i]==true && indegree[i]==0){
            que.offer((char)('a'+i));
            sb.append((char)('a'+i));
            }
        }
        
        while(!que.isEmpty()){
            char ch=que.poll();
            
            for(char c:adj.get(ch-'a')){
                
                indegree[c-'a']--;
                if(indegree[c-'a']==0){
                    que.offer(c);
                    sb.append(c);
                }
            }
        }
        
        int totalCharacters = 0;

        for(boolean x : present){
            if(x) totalCharacters++;
        }

        if(sb.length() != totalCharacters) return "";
        return sb.toString();
        
    }
}
