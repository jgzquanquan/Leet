package dfsAndbfs;

import java.util.LinkedList;

/**
 * @author jgz
 * @Date 2020-06-01 11:23
 */
public class Graph {
    private int v;//顶点个数
    private LinkedList<Integer> adj[];

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }
}
