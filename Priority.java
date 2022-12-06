/**
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

public class Priority implements Algorithm {

    List<Task> queue;
    CPU cpu;
    int time, p;
    Task task, nt;

    public Priority(List<Task> q) {
        queue = q;
    }

    public void schedule() {
        for (int i = 0; i < queue.size(); i++) {
            task = pickNextTask();
            time = task.getBurst();
            cpu.run(task, time);
            queue.remove(task);
        }
    }

    public Task pickNextTask() {
        p = 0;
        for (Task t : queue) {
            if (t.getPriority() > p) {
                p = t.getPriority();
                nt = t;
            }
        }
        return nt;
    }
}