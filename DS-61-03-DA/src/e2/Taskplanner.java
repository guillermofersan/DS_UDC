package e2;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

public class Taskplanner {

    Graph graph;

    public Taskplanner(String filename) throws IOException {

        graph = new Graph();

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
    }

    public Graph getGraph() {
        return graph;
    }

    public static void main(String[] args) throws IOException {

        Taskplanner t = new Taskplanner("tasks.txt");


        System.out.print(t.getGraph().toString() + "\n");

        //if (t.getGraph().taskDepends(new Task('C')))
        //    System.out.println("Buenas tardes");


        System.out.println(t.getGraph().traverseGraph(new StrongdepTraverser()).toString());

    }




}
