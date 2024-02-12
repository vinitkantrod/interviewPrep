package Roshni;

import java.util.ArrayList;
import java.util.List;

public class findWordsContaining {

    public static void main(String[] args) {
       String[] words = {"leet","code"};
       char x = 'e';
        System.out.println(findWordsContaining(words,x));
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i< words.length ;i++) {
            String word = words[i];
            if(word.indexOf(x) >= 0)
                ans.add(i);
        }
        return ans;
    }
}
