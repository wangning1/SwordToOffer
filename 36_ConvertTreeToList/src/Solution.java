/**
 * @authour winner
 * @Date 2020/5/5 9:54
 */
public class Solution {
    public Node treeToDoublyList(Node root) {
        Node tail = convert(root, null);
        Node head = tail;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    Node convert(Node node, Node lastPNodeInList) {
        if (node == null) {
            return null;
        }

        Node currentNode = node;
        if (currentNode.left != null) {
            lastPNodeInList = convert(currentNode.left, lastPNodeInList);
        }

        currentNode.left = lastPNodeInList;
        if (lastPNodeInList != null) {
            lastPNodeInList.right = currentNode;
        }

        lastPNodeInList = currentNode;
        if (currentNode.right != null) {
            lastPNodeInList = convert(currentNode.right, lastPNodeInList);
        }
        return lastPNodeInList;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
//
        root.right = new Node(5);

        Solution solution = new Solution();

        Node head = solution.treeToDoublyList(root);
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.right;
        }
    }
}
