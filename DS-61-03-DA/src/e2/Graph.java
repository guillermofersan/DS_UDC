package e2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Graph {

    private HashMap<Task, List<Task>> graph;



    public Graph() {
        graph = new HashMap<>();
    }

    public HashMap<Task, List<Task>> getGraph() {
        return graph;
    }

    public void setGraph(HashMap<Task, List<Task>> graph) {
        this.graph = graph;
    }

    boolean isVertex(Task c){
        return graph.containsKey(c);
    }

    boolean isEmptyGraph(){
        return graph.isEmpty();
    }

    void addVertex(Task c){
        graph.put(c,new ArrayList<Task>());
    }

    void addDependency(Task father, Task dependent){
        List<Task> depList = graph.get(father);
        depList.add(dependent);

        graph.replace(father,depList);
    }

    void deleteVertex(Task c){
        graph.remove(c);
    }

    List<Task> traverseGraph(GraphTraverser traverser){
        return traverser.traversegraph(this);
    }

    boolean taskDepends(Task t){

        List<Task> aux;

        for (Task key : graph.keySet()) {
            aux = graph.get(key);

            if (aux.contains(t))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return graph.toString();
    }

}
