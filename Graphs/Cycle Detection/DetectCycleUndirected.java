BFS:

class Tuple{
    int node,parent;
    Tuple(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}
class Solution {
    private boolean bfs(int start,boolean visit[],List<List<Integer>> adj){
        Queue<Tuple> que=new LinkedList<>();
        que.offer(new Tuple(start,-1));
        visit[start]=true;
        
        while(!que.isEmpty()){
            Tuple tup=que.poll();
            int node=tup.node;
            int par=tup.parent;
        for(int num:adj.get(node)){    
            if(visit[num]!=true){
                visit[num]=true;
                que.offer(new Tuple(num,node));
            }
            else if(num!=par){
                return true;
            }
        }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
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
        boolean visit[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visit[i]){
                if(bfs(i,visit,adj)) return true;
            }
        }
        
        return false;
        
    }
}


DFS:

class Tuple{
    int node,parent;
    Tuple(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}
class Solution {
    private boolean dfs(int node,int parent,boolean visit[],List<List<Integer>> adj){
        visit[node]=true;
        for(int num:adj.get(node)){
            if(visit[num]!=true){
                if(dfs(num,node,visit,adj)) return true;
            }
            else if(num!=parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
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
        boolean visit[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visit[i]){
                if(dfs(i,-1,visit,adj)) return true;
            }
        }
        
        return false;
        
    }
}
