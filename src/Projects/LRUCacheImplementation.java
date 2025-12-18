package Projects;

import java.util.*;

class Node {
    int key, value;
    Node prev, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    // ✅ Get Value
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAtHead(node);
        return node.value;
    }

    // ✅ Put Value
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtHead(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.key);
                remove(tail);
            }

            Node newNode = new Node(key, value);
            insertAtHead(newNode);
            map.put(key, newNode);
        }
    }

    // ✅ Remove Node
    private void remove(Node node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }

    // ✅ Insert at Head
    private void insertAtHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null)
            head.prev = node;

        head = node;

        if (tail == null)
            tail = head;
    }

    // ✅ Display Cache
    public void display() {
        Node temp = head;
        System.out.print("Cache: ");
        while (temp != null) {
            System.out.print("[" + temp.key + ":" + temp.value + "] ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// ✅ Main Class
public class LRUCacheImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Cache Capacity: ");
        int capacity = sc.nextInt();

        LRUCache cache = new LRUCache(capacity);

        while (true) {
            System.out.println("\n===== ✅ LRU CACHE MENU =====");
            System.out.println("1. Put (Insert)");
            System.out.println("2. Get (Access)");
            System.out.println("3. Display Cache");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    int key = sc.nextInt();
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    cache.put(key, value);
                    System.out.println("✅ Inserted Successfully!");
                    break;

                case 2:
                    System.out.print("Enter key to access: ");
                    int searchKey = sc.nextInt();
                    int result = cache.get(searchKey);
                    if (result == -1)
                        System.out.println("❌ Key not found!");
                    else
                        System.out.println("✅ Value: " + result);
                    break;

                case 3:
                    cache.display();
                    break;

                case 4:
                    System.out.println("✅ Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid Choice!");
            }
        }
    }
}
