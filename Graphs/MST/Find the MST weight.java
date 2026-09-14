class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    
    int findPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        
        int ulp=findPar(parent.get(node));
        parent.set(node,ulp);
        
        return parent.get(node);
    }
    
    void unionByRank(int u,int v){
        int ulp_u=findPar(u);
        int ulp_v=findPar(v);
        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_u,ulp_v);
            int rankU=rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        
        DisjointSet ds=new DisjointSet(V);
        
        int mstWeight=0;
        
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            
            if(ds.findPar(u) != ds.findPar(v)){
                ds.unionByRank(u,v);
                mstWeight+=w;
            }
        }
        
        return mstWeight;
        
    }
}
