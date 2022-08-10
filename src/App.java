class Main {
  public static void main(String[] args) {
    Graph g1 = new Graph(4);
    g1.addEdge(0, 1, 3);
    g1.addEdge(1, 0, 3);
    g1.addEdge(0, 3, 4);
    g1.addEdge(3, 0, 4);
    g1.addEdge(3, 4, 4); //Warning

    System.out.println(g1);
    System.out.println(g1.degree(0));
    System.out.println(g1.degree(1));
    System.out.println(g1.degree(2));
    System.out.println(g1.degree(3));

    System.out.println(g1.highestDegree()); //2
    System.out.println(g1.lowestDegree()); //0
    System.out.println(g1.complementGraph());

  }
}