
class Pair{
    int node,wt;
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}
class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Queue<Pair> que=new LinkedList<>();
        que.offer(new Pair(src,0));
        
        boolean visit[]=new boolean[V];
        visit[src]=true;
        
        while(!que.isEmpty()){
            Pair p=que.poll();
            int node=p.node;
            int wt=p.wt;
            
            if(node==dest) return wt;
            
            for(int num:adj.get(node)){
                if(!visit[num]){
                    visit[num]=true;
                    que.offer(new Pair(num,wt+1));
                }
            }
        }
        
        return -1;
    }
}
