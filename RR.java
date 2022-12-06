/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */
 
import java.util.*;
public class RR implements Algorithm {

        List<Task> queue;
        int TIMEQUANTUM = 10;
        int seat = 0;
        CPU cpu;
        Task task, tt;

        public RR(List<Task> q) {
                queue = q;
        }

        public void schedule() {
                while (queue.size() > 0) {
                    task = pickNextTask();
                    cpu.run(task, Math.min(task.getBurst(), TIMEQUANTUM));
                }
        }

        public Task pickNextTask() {
                tt = queue.get(seat);
                if (tt.getBurst() <= TIMEQUANTUM) {
                        tt.setBurst(0);
                        queue.remove(tt);
                } else {
                        tt.setBurst(tt.getBurst() - TIMEQUANTUM);
                        seat += 1;
                        if (seat > queue.size()-1) {
                                seat = 0;
                        }
                }
                return tt;
        }
}