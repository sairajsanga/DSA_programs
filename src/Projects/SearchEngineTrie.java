package Projects;

import java.util.*;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // ✅ Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        word = word.toLowerCase();

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isEndOfWord = true;
        System.out.println("✅ Word inserted successfully!");
    }

    // ✅ Search for a word in the trie
    public boolean search(String word) {
        TrieNode current = root;
        word = word.toLowerCase();

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null)
                return false;
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    // ✅ Delete a word
    public void delete(String word) {
        if (deleteHelper(root, word.toLowerCase(), 0))
            System.out.println("✅ Word deleted successfully!");
        else
            System.out.println("❌ Word not found!");
    }

    private boolean deleteHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord)
                return false;
            current.isEndOfWord = false;
            return isEmpty(current);
        }

        int charIndex = word.charAt(index) - 'a';
        TrieNode node = current.children[charIndex];

        if (node == null)
            return false;

        boolean shouldDelete = deleteHelper(node, word, index + 1);

        if (shouldDelete) {
            current.children[charIndex] = null;
            return isEmpty(current);
        }
        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children)
            if (child != null)
                return false;
        return true;
    }

    // ✅ Auto-Suggestion Feature
    public void autoSuggest(String prefix) {
        TrieNode current = root;
        prefix = prefix.toLowerCase();

        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                System.out.println("❌ No suggestions found!");
                return;
            }
            current = current.children[index];
        }

        System.out.println("✅ Suggestions:");
        printSuggestions(current, prefix);
    }

    private void printSuggestions(TrieNode current, String prefix) {
        if (current.isEndOfWord)
            System.out.println(prefix);

        for (int i = 0; i < 26; i++) {
            if (current.children[i] != null) {
                char ch = (char) (i + 'a');
                printSuggestions(current.children[i], prefix + ch);
            }
        }
    }
}

// ✅ Main Class
public class SearchEngineTrie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();

        // Preloaded words
        String[] words = {"google", "github", "gmail", "geeks", "game", "goat"};
        for (String word : words)
            trie.insert(word);

        while (true) {
            System.out.println("\n==== 🔍 SEARCH ENGINE USING TRIE ====");
            System.out.println("1. Insert Word");
            System.out.println("2. Search Word");
            System.out.println("3. Delete Word");
            System.out.println("4. Auto Suggest");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter word to insert: ");
                    trie.insert(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter word to search: ");
                    String searchWord = sc.nextLine();
                    if (trie.search(searchWord))
                        System.out.println("✅ Word found!");
                    else
                        System.out.println("❌ Word not found!");
                    break;

                case 3:
                    System.out.print("Enter word to delete: ");
                    trie.delete(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Enter prefix: ");
                    trie.autoSuggest(sc.nextLine());
                    break;

                case 5:
                    System.out.println("✅ Thank You! Exiting...");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
