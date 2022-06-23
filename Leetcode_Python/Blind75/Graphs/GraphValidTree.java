package Blind75.Graphs;
/*
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges 
 * where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
Return true if the edges of the given graph make up a valid tree, and false otherwise.
 */
public class GraphValidTree {
    //Approach 1: Iterative depth first search
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        Map<Integer, Integer> parent = new HashMap<>();
        
        parent.put(0, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        while(!stack.isEmpty()){
            int node = stack.pop();
            
            for (int neighbor : adjacencyList.get(node)){
                if (parent.get(node) == neighbor){
                    continue;
                }
                
                if (parent.containsKey(neighbor)){
                    return false;
                }
                
                stack.push(neighbor);
                parent.put(neighbor, node);
            }
        }
        
        return parent.size() == n;
        
    }
    
}
