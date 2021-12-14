package e2;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

public class Task implements Comparable<Task> {

    final private Character name;

    public Task(char c) {
        this.name = c;
    }

    public Character getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return name.equals(task.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public int compareTo(Task t) {
        return this.name.compareTo(t.getName());
    }

}
