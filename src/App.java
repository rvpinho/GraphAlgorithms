import java.io.IOException;




class Main {
  public static void main(String[] args) {
    Graph g1 = new Graph(4);
  /* 
    g1.addEdge(0, 1, 3);
    g1.addEdge(1, 0, 3);
    g1.addEdge(0, 3, 4);
    g1.addEdge(3, 0, 4);
    g1.addEdge(3, 4, 4); //Warning
    */

    g1.addEdgeUnoriented(7, 5, 1);
    g1.addEdgeUnoriented(7, 1, 1);
    g1.addEdgeUnoriented(7, 2, 1);
    g1.addEdgeUnoriented(1, 0, 1);
    g1.addEdgeUnoriented(1, 4, 1);
    g1.addEdgeUnoriented(2, 3, 1);
    g1.addEdgeUnoriented(5, 6, 1);
    g1.addEdgeUnoriented(6, 8, 1);
    System.out.println(g1.bfs(7));
    System.out.println(g1.connected());

    Graph g2 = new Graph("grafo1.txt");
    System.out.println(g2);

    /*/
    System.out.println(g1);
    System.out.println(g1.degree(0));
    System.out.println(g1.degree(1));
    System.out.println(g1.degree(2));
    System.out.println(g1.degree(3));

    System.out.println(g1.highestDegree()); //2
    System.out.println(g1.lowestDegree()); //0
    System.out.println(g1.complementGraph());
*/

// Graph g1 = new Graph(4);
    // System.out.println(g1.toString());
    // g1.addEdge(0, 1, 3);
    // g1.addEdge(1, 0, 3);
    // g1.addEdge(0, 3, 4);
    // g1.addEdge(3, 0, 4);
    // g1.addEdge(3, 4, 2); // warning
    // System.out.println(g1);
    // System.out.println(g1.degree(0)); // 2
    // System.out.println(g1.degree(1)); // 1
    // System.out.println(g1.degree(2)); // 0
    // System.out.println(g1.degree(3)); // 1
    // System.out.println(g1.highestDegree()); // 2
    // System.out.println(g1.lowestDegree()); // 0
    // System.out.println(g1.complement());
    // System.out.println(g1.subGraph());    


  }
}