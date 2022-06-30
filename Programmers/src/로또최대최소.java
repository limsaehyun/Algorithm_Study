import java.util.Arrays;

/*
https://programmers.co.kr/learn/courses/30/lessons/77484
2022-06-30
 */
public class 로또최대최소 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int num = 0;
        int zero = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
            }
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    num++;
                }
            }
        }

        answer[0] = returnRank(num + zero);
        answer[1] = returnRank(num);

        return answer;
    }

    static int returnRank(int num) {

        if(num > 1) {
            return 7 - num;
        } else {
            return 6;
        }
    }
}
