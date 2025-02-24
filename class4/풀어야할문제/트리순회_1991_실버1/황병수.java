package class4.풀어야할문제.트리순회_1991_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 황병수 {

    static Map<Character, Node> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.putIfAbsent(node, new Node(node));

            // 왼쪽 자식 노드 추가
            if (left != '.') {
                tree.putIfAbsent(left, new Node(left));
                tree.get(node).left = tree.get(left);
            }

            // 오른쪽 자식 노드 추가
            if (right != '.') {
                tree.putIfAbsent(right, new Node(right));
                tree.get(node).right = tree.get(right);
            }
        }

        // 순회 실행
        preorder(tree.get('A'));
        System.out.println();
        inorder(tree.get('A'));
        System.out.println();
        postorder(tree.get('A'));
        System.out.println();
    }


    // 전위 순회: 루트 → 왼쪽 → 오른쪽
    static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회: 왼쪽 → 루트 → 오른쪽
    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회: 왼쪽 → 오른쪽 → 루트
    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    static class Node {
        char value;
        Node left, right;
        public Node(char value) {
            this.value = value;
        }
    }
}
