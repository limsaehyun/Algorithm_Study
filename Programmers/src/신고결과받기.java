import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
    2022.06.30
    https://programmers.co.kr/learn/courses/30/lessons/92334
 */
public class 신고결과받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // HashSet을 통해 중복 신고 방지
        HashMap<String, HashSet<String>> reporterMap = new HashMap<>();
        HashMap<String, Integer> reportedMap = new HashMap<>();

        for (String reportInfo : report) {
            String reporter = reportInfo.split(" ")[0];
            String reported = reportInfo.split(" ")[1];

            if (reporterMap.containsKey(reporter)) {
                if (reporterMap.get(reporter).contains(reported)) {
                    continue;
                } else {
                    reporterMap.get(reporter).add(reported);
                }

            } else {
                reporterMap.put(reporter, new HashSet<>() {{
                    add(reported);
                }});
            }

            reportedMap.put(reported, reportedMap.getOrDefault(reported, 0)+1);
        }

        for(String reported : reportedMap.keySet())  {
            if(reportedMap.get(reported) >= k) {
                for(int i = 0; i < id_list.length; i++) {
                    if(reporterMap.get(id_list[i]) == null) {
                        answer[i] = 0;
                    } else if(reporterMap.get(id_list[i]).contains(reported)) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}
