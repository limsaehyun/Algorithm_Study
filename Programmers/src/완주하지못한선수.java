import java.util.HashMap;

/*
programmers - 완주하지 못한 선수
number: 42576
 */
class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String e: participant) {
            hashMap.put(e, hashMap.getOrDefault(e, 0) + 1);
        }

        for(String e: completion) {
            hashMap.put(e, hashMap.get(e) - 1);
        }

        for(String key: hashMap.keySet()) {
            if(hashMap.get(key) > 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
