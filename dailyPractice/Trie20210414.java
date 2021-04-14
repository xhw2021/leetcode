import java.util.ArrayList;

/**
 * @ClassName Trie20210414
 * @Description TODO
 * @Author 22936
 * @Date 2021/4/14 10:01
 * @Version 1.0
 */

public class Trie20210414 {
/*方式一：通过ArrayList判断，可以通过，但是时间复杂度很高。
    ArrayList<String> list;
    // Initialize your data structure here.
    public Trie20210414() {
        list = new ArrayList<String>();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        list.add(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return list.contains(word);
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {

        for(String s:list){
            if(prefix.length() > s.length()) continue;
            String subStr = s.substring(0,prefix.length());
            if(subStr.compareTo(prefix) == 0){
                return true;
            }
        }
        return false;
    }
*/

//方法二：字典树，即建立26叉树，同时求前缀和整词均可以概括为求字典树是否有路过某个词汇的路径。

        private Trie20210414[] children;
        private boolean isEnd;

        public Trie20210414() {
            children = new Trie20210414[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie20210414 node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie20210414();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie20210414 node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie20210414 searchPrefix(String prefix) {
            Trie20210414 node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }

}

