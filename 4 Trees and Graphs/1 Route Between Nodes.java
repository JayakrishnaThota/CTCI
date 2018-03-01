//Executed in LintCode

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
    DirectedGraphNode s, DirectedGraphNode t) {
        int vertexcount = graph.size();
        boolean[] visited = new boolean[vertexcount];
        visited[s.label] = true;
        Queue<DirectedGraphNode> q = new LinkedList();
        q.offer(s);
        while(!q.isEmpty()){
            DirectedGraphNode temp = q.poll();
            for(DirectedGraphNode neighbor: temp.neighbors){
                if(visited[neighbor.label]==false){
                    visited[neighbor.label] = true;
                    q.offer(neighbor);
                }
            }
        }
        return visited[t.label];
    }
}
