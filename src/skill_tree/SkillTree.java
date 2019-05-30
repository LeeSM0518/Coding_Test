package skill_tree;

public class SkillTree {

    public static int solution(final String skill, final String[] skillTrees) {
        int answer = skillTrees.length;

        for (int i = 0; i < skillTrees.length; i++) {
            String toCompare = skillTrees[i];
            int currentSkill = 0;

            for (int j = 0; j < toCompare.length(); j++) {
                int search = skill.indexOf(toCompare.charAt(j));

                if (search == -1) continue;
                else if (search > currentSkill) {
                    answer--;
                    break;
                } else {
                    currentSkill++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skillTrees = new String[]{"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skillTrees));
    }
}
