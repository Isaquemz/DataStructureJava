package problem;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReverse {

    public static Queue<Integer> reverseFirstK(Queue<Integer> queue, int k) {
        solveQueue(queue, k);

        // Manda para o final da lista os valores não alterados
        int n = queue.size() - k;
        while (n-- > 0) {
            int element = queue.remove();
            queue.add(element);
        }

        return queue;
    }

    private static void solveQueue(final Queue<Integer> queue, final int k) {
        if (k == 0) return;
        // Remove valores quantidade de vezes definidas em "k" guardando
        // na memoria e depois inserindo de forma reversa.
        int element = queue.remove();
        solveQueue(queue, k-1);
        queue.add(element);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(reverseFirstK(queue, 3));
    }

}
