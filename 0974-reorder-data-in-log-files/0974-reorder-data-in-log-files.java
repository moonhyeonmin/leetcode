class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digit.add(log);
            } else {
                letter.add(log);
            }
        }

        letter.sort((s1, s2) -> {
            // 인덱스 값 넣어주면 띄어쓰기 기준으로 두개로 나눠짐
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        letter.addAll(digit);

        return letter.toArray(new String[0]);
    }
}