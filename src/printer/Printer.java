package printer;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    static class Document {
        int priority;
        int location;

        public Document(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Document> readyQueue = new LinkedList<>();
        Queue<Document> printQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            readyQueue.add(new Document(priorities[i], i));
        }

        Document firstDocument;
        Document returnTail = null;

        do {
            firstDocument = readyQueue.peek();

            for (Document document : readyQueue) {
                if (document.priority > firstDocument.priority) {
                    returnTail = readyQueue.poll();
                    break;
                }
            }

            if (returnTail != null) {
                readyQueue.add(returnTail);
            } else {
                printQueue.add(readyQueue.poll());
            }

            returnTail = null;

        } while (printQueue.size() != priorities.length);

        for (int i = 1; i <= priorities.length; i++) {
            if (printQueue.poll().location == location) {
                answer = i;
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }
}
