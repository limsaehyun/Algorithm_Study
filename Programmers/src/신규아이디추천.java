public class 신규아이디추천 {
    public static void main(String[] args) {
    }

    public static String solution(String new_id) {
        String answer = "";

        if(idCorrect(new_id)) {
            return new_id;
        } else {

        }
        return answer;
    }

    public static String replaceKakaoId(String id) {
        String replaceString = id ;
        char replaceWord = 'a';

        for(int i = 0; i < id.length(); i++) {
            char replaceChar = id.charAt(i);

            // 1 단계
            if('A' <= replaceChar && 'Z' >= replaceChar) {
                replaceString.replace(replaceChar, (char)(replaceChar + 32));
            }

            // 2 단계
        }
        
        return replaceString;
    }

    public static boolean idCorrect(String id) {
        if (!(3 <= id.length() && 15 >= id.length())) {
            System.out.println("1");
            return false;
        }

        for (int i = 0; i < id.length(); i++) {
            char correctChar = id.charAt(i);

            if (!(('0' <= correctChar && correctChar <= '9') || ('a' <= correctChar && correctChar <= 'z') || correctChar == '-' || correctChar == '_' || correctChar == '.')) {
                System.out.println("2");
                return false;
            }
        }

        int lastIndex = id.length();
        if(id.charAt(0) == '.' || id.charAt(lastIndex-1) == '.') {
            System.out.println("3");
            return false;
        }

        if(id.contains("..")) {
            System.out.println("4");
            return false;
        }

        return true;
    }
}
