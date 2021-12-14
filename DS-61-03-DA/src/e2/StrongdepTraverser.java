package e2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StrongdepTraverser implements GraphTraverser {

    @Override
    public List<Task> traversegraph(Graph graph) {



        /*
        HashMap<Task, List<Task>> g = graph.getGraph();
        List<Task> aux = new ArrayList<>();
        List<Task> total = new ArrayList<>();

        while (!graph.isEmptyGraph()){
            for (Task key : g.keySet()) {

                if (!graph.taskDepends(key)){
                    aux.add(key);

                }
            }

            for (Task t: aux) {
                g.remove(t);
            }
            total.addAll(aux);
            aux.clear();
        }
        */
        return null;



    }
}
