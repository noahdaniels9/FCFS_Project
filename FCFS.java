/**
 * FCFS scheduling algorithm.
 */
 
import java.util.*;

public class FCFS implements Algorithm {

    List<Task> queue;
    CPU cpu;
    int time, x;
    Task task, nt;

    public FCFS(List<Task> q) {
        queue = q;
    }

    public void schedule() {
        while (x < queue.size()) {
            task = pickNextTask();
            time = task.getBurst();
            cpu.run(task, time);
            x ++;
        }
    }

    public Task pickNextTask() {
        return queue.get(x);
    }
}