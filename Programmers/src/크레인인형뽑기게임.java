import java.util.*;

/*
Programmers - 크레인 인형 뽑기 게임
Number - 64061
 */
class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (Integer move : moves) {
            int claw = move - 1;
            for (int i = 0; i < board.length; i++) {
                int k = board[i][claw];

                if (k == 0) {
                    continue;
                } else if (!stack.empty() && stack.peek() == k) {
                    stack.pop();
                    answer++;
                } else {
                    stack.push(k);
                }

                board[i][claw] = 0;
                break;
            }
        }
        return answer * 2;
    }
}
