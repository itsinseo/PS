class Solution {
    public int solution(String[] spell, String[] dic) {
        for (String stringDic : dic) {
            boolean included = true;
            for (String stringSpell : spell) {
                if (!stringDic.contains(stringSpell)) {
                    included = false;
                    break;
                }
            }
            if (included) return 1;
        }

        return 2;
    }
}