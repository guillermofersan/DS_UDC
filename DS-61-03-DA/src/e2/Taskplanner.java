package e2;

import java.io.*;
import java.util.*;

public class Taskplanner {

    Graph graph;

    public Taskplanner(List<String> depList) {

        graph = new Graph();

        Task t1,t2;

        for (String s: depList) {
            t1 = new Task(s.charAt(0));
            t2 = new Task(s.charAt(5));

                graph.addVertexifAbsent(t1);
                graph.addVertexifAbsent(t2);

            graph.addDependency(t1,t2);
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public static void main(String[] args) {

        String[] array = {"C -> A","C -> F","A -> B","A -> D","B -> E","D -> E","F -> E","G -> F","G -> H","F -> J","H -> J"};

        Taskplanner t = new Taskplanner(Arrays.asList(array));

        System.out.print(t.getGraph().toString() + "\n");

        System.out.println("Strong Dependency: " + t.getGraph().traverseGraph(new StrongdepTraverser()).toString());

        System.out.println("Weak Dependency:   " + t.getGraph().traverseGraph(new WeakdepTraverser()).toString());

        System.out.println("hierarchi noseque: " + t.getGraph().traverseGraph(new HierarchicalTraverser()).toString());
    }




}
