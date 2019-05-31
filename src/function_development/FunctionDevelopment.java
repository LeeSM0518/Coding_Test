package function_development;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FunctionDevelopment {

    public static class Project {
        int progress;
        int speed;

        public Project(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Stack<Project> projects = new Stack<>();
        Queue<Integer> distribute = new LinkedList<>();

        for (int i = progresses.length - 1; i >= 0 ; i--) {
            Project project = new Project(progresses[i], speeds[i]);
            projects.push(project);
        }

        while (!projects.empty()) {
            projects.forEach(project -> {
                project.progress += project.speed;
            });

            if (projects.peek().progress >= 100) {
                int count = (int) projects.stream().filter(project -> project.progress >= 100).count();
                distribute.add(count);

                for (int i = 0; i < count; i++) {
                    projects.pop();
                }
            }
        }

        answer = new int[distribute.size()];

        distribute.forEach(distribute -> {});

        for (int i = 0; i < answer.length; i++) {
            answer[i] = (int)distribute.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{93, 39, 55};
        int[] speeds = new int[]{1, 30, 5};

        System.out.println(solution(progresses, speeds));
    }

}
