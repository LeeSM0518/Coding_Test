package function_development;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

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

        // 스택에 작업 진도를 뒤쪽 인덱스부터 푸시한다.
        for (int i = progresses.length - 1; i >= 0 ; i--) {
            Project project = new Project(progresses[i], speeds[i]);
            projects.push(project);
        }

        while (!projects.empty()) {
            // 프로젝트의 진도를 속도만큼 더 해준다.
            projects.forEach(project -> {
                project.progress += project.speed;
            });

            // 첫 번째 프로젝트 진도가 100과 같거나 클때
            if (projects.peek().progress >= 100) {
                int count = 0;

                // 스택에 진도가 100 이상인 것들을 찾아서 pop 해주고 큐에 넣어준다.
                for (int i = projects.size() - 1; i >= 0; i--) {
                    if (projects.peek().progress >= 100) {
                        projects.pop();
                        count++;
                    } else {
                        break;
                    }
                }
                distribute.add(count);
            }
        }

        answer = new int[distribute.size()];

        // 큐에 들어온 갯수만큼 꺼내온다.
        for (int i = 0; i < answer.length; i++) {
            answer[i] = distribute.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{93, 39, 55};
        int[] speeds = new int[]{1, 30, 5};

        int[] answer = solution(progresses, speeds);
        for(int i : answer) {
            System.out.print(i + ", ");
        }
    }

}
