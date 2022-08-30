import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    for (int i = 0; i < this.adjMatrix.length; ++i) {
      for (int j = 0; j < this.adjMatrix[i].length; ++j) {
        str += this.adjMatrix[i][j] + "\t";
      }
      str += "\n";
    }
    return str;
  }

  public void addEdge(int source, int sink, int weight) {
    if (source < 0 || source > this.countNodes - 1 
        || sink < 0 || sink > this.countNodes - 1 || weight <= 0) {
      System.err.println("Invalid edge: " + source + sink + weight);
      return;
    }
    this.adjMatrix[source][sink] = weight;
    this.countEdges++;
  }

  public int degree(int node) {
    if (node < 0 || node > this.countNodes - 1)
      System.err.println("Invalid node: " + node);
    int degree = 0;
    for (int j = 0; j < this.adjMatrix[node].length; ++j) {
      if (this.adjMatrix[node][j] != 0)
        ++degree;
    }
    return degree;
  }
  


  
//AULA 10.08.22

  public int highestDegree(){
    int highest =0;
    for(int i=0; i<this.adjMatrix.length; ++i){
      int degreeNodeI = this.degree(i);
      if (highest < degreeNodeI){
        highest = this.degree(i);
      }

    }
    return highest;
  }

  public int lowestDegree(){
    int lowest = 0;
    for(int j=0; j<this.adjMatrix.length; ++j){
    int degreeNodeI = this.degree(j);
      if (lowest > degreeNodeI){
        lowest = this.degree(j);
      }      

    }
    return lowest;    
   
  }


  public Graph complement(){

    Graph complementGraph = new Graph(this.adjMatrix.length);
    for (int i = 0; i <this.adjMatrix.length; i++){
      for (int j = 0; j < this.adjMatrix[i].length; j++){
        if (this.adjMatrix[i][j] == 0 && i != j){
          complementGraph.addEdge(i, j, 1);
        }
      }
    }
    return complementGraph;
  }

  public Graph complementGraph() {
    Graph g2 = new Graph(this.countNodes);
    for(int i=0; i<this.adjMatrix.length; i++) {
      for(int j=0; j<this.adjMatrix[i].length; j++) {
        if(i != j && this.adjMatrix[i][j] == 0) {
          g2.addEdge(i, j, i);
        }
      }
    }
    return g2;
  }

  public float density() {
    // d = E / V * V - 1
    return (float) this.countEdges / (this.countNodes * (this.countNodes - 1));
  }

  public boolean subgraph(Graph g2) {
    // retorna true se g2 for subgrafo de this;
    // retorna false caso contrario
    if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges)
      return false;
    for (int i = 0; i < g2.adjMatrix.length; ++i) {
      for (int j = 0; j < g2.adjMatrix[i].length; ++j) {
        if (g2.adjMatrix[i][j] != 0 && this.adjMatrix[i][j] == 0)
          return false;
      }
    }
    return true;
  }

  public ArrayList<Integer> bfs(int s) { // busca em largura
    // inicialização
    int[] desc = new int[this.countNodes];
    ArrayList<Integer> Q = new ArrayList<>();
    Q.add(s);
    ArrayList<Integer> R = new ArrayList<>();
    R.add(s);
    desc[s] = 1;
    // Loop principal
    while(Q.size() > 0) {
      int u = Q.remove(0);
      for(int v=0; v<this.adjMatrix[u].length; v++) {
        if(this.adjMatrix[u][v] != 0) { // v é adjacente a u
          if(desc[v] == 0) {
            Q.add(v);
            R.add(v);
            desc[v] = 1;
          }
        }
      }
    }
    return R;
  }

  public ArrayList<Integer> dfs(int s) { // busca em profundidade por último valor
    int[] desc = new int[this.countNodes];
    ArrayList<Integer> S = new ArrayList();
    S.add(s);
    ArrayList<Integer> R = new ArrayList();
    R.add(s);
    desc[s] = 1;
    // loop principal
    while (S.size() > 0) {
      int u = S.get(S.size()-1);
      boolean unstack = true; // desempilha
      for(int v = 0; v < adjMatrix[u].length;++v){
        if(this.adjMatrix[u][v] != 0 && desc[v] == 0){
            S.add(v);
            R.add(v);
            desc[v] = 1;
            unstack = false;
            break;
          }
      } if(unstack)
          S.remove(S.size()-1);
    }
    return R;
  }

  public boolean connected() {
    return this.bfs(0).size() < this.countNodes;
  }

  public ArrayList<Integer> dfsRec(int s) {
    int[] desc = new int[this.countNodes];
    ArrayList<Integer> R = new ArrayList<>();
    dfsRecursiveAux(s, desc, R);
    return R;
  }
  
  public void dfsRecursiveAux(int u, int[] desc, ArrayList<Integer> R) {
    desc[u] = 1;
    R.add(u);
    for (int v = 0; v < this.adjMatrix[u].length; ++v) {
      if (this.adjMatrix[u][v] != 0 && desc[v] == 0) {
        dfsRecursiveAux(v, desc, R);
      }
    }
  }  
  
}
