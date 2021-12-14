package e2;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Taskplanner {

    Graph graph;

    public Taskplanner(List<String> depList) {

        graph = new Graph();

        Task t1,t2;

        for (String s: depList) {
            t1 = new Task(s.charAt(0));
            t2 = new Task(s.charAt(5));

            if (!graph.isVertex(t1)) graph.addVertex(t1);
            if (!graph.isVertex(t2)) graph.addVertex(t2);

            graph.addDependency(t1,t2);
        }

        /*
        if (filename==null) throw new IllegalArgumentException();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String s="";
            Task t1,t2;
            String line = br.readLine();
            while (line != null) {
                //s+=line+"\n";
                //System.out.println(line.charAt(0));
                //System.out.println(line.charAt(0) + "---" + line.charAt(5));
                t1 = new Task(line.charAt(0));
                t2 = new Task(line.charAt(5));

                if (!graph.isVertex(t1)) graph.addVertex(t1);
                if (!graph.isVertex(t2)) graph.addVertex(t2);

                graph.addDependency(t1,t2);

                line = br.readLine();
            }

            //System.out.println(s);

        }
         */
    }

    public Graph getGraph() {
        return graph;
    }

    public static void main(String[] args) throws IOException {

        String[] array = {"C -> A","C -> F","A -> B","A -> D","B -> E","D -> E","F -> E","G -> F","G -> H","F -> J","H -> J"};

        //Taskplanner t = new Taskplanner(Arrays.asList(array));



        HashMap<String, Integer> a = new HashMap<>();

        a.put("B",5);
        a.put("A",7);
        a.put("D",2);
        a.put("C",3);

        System.out.println(a.toString());




        //ystem.out.print(t.getGraph().toString() + "\n");


        //System.out.println( t.getGraph().traverseGraph(new StrongdepTraverser()).toString() );

    }




}
