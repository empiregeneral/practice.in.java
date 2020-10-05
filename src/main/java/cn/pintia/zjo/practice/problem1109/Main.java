package cn.pintia.zjo.practice.problem1109;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        Trie<String, String> dict = new PatriciaTrie<String>();

        while(scanner.hasNextLine()) {

            String line = scanner.nextLine();
            if ("".equals(line)) {
                break;
            }
            int spacePos = findSpacePosInString(line);
            String key = line.substring(spacePos+1, line.length());
            String value = line.substring(0, spacePos);

            dict.put(key, value);
        }

        while(scanner.hasNext()) {
            String fatmouseWord = scanner.next();
            String humanWord = dict.get(fatmouseWord);
            System.out.println(dict.containsKey(fatmouseWord) ?  humanWord : "eh");
        }
    }

    private static int findSpacePosInString(String line) {
        char[] chars = line.toCharArray();
        int len = line.length();
        int index = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                index = i;
            }
        }
        return index;
    }
}
