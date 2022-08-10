public class Graph {

    private int countNodes;
    private int countEdges;
    private int[][] adjMatrix;
  
    public Graph(int countNodes) {
      this.countNodes = countNodes;
      this.adjMatrix = new int[countNodes][countNodes];
    }
  
    public int getCountNodes() {
      return this.countNodes;
    }
  
    public int getCountEdges() {
      return this.countEdges;
    }
  
    public int[][] getAdjMatrix() {
      return this.adjMatrix;
    }
  
    public String toString() {
      String str = "";
      for (int i = 0; i < this.adjMatrix.length; i++) {
        for (int j = 0; j < this.adjMatrix[i].length; ++j) {
          str += this.adjMatrix[i][j] + "\t";
        }
        str += "\n";
      }
  
      return str;
  
    }
  
    public void addEdge(int source, int sink, int weight) {
      if (source <= 0 || source > this.countNodes || sink <= 0 || sink > this.countNodes || weight <= 0) {
  
        System.err.println("INVALID VALUE FOR SOURCE,SINK OR WEIGHT");
      }
  
      this.adjMatrix[source][sink] = weight;
      this.countEdges++;
    }
  }