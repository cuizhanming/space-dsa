package com.cuizhanming.learning.dsa.advanced;

import java.util.*;

public class BinaryTree {


    public static class TreeNode {
        public int value;
        public TreeNode leftChild;
        public TreeNode rightChild;
        public TreeNode(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "[(" + value + "), leftChild=" + leftChild + ", rightChild=" + rightChild + "]\n";
        }
    }

    /**
     [(3),
         leftChild=
         [(2),
                leftChild=[(9), leftChild=null, rightChild=null]
                rightChild=[(10), leftChild=null, rightChild=null]
         ]
         rightChild=
         [(8),
                leftChild=null,
                rightChild=[(4), leftChild=null, rightChild=null]
         ]
     ]

     */

    private static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return node;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * Pre-order traversal
     * We put the `root` node value first, before the left child node and right child node.
     */
    public static List<Integer> preOrderTraversalResult = new ArrayList<>();
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrderTraversalResult.add(root.value);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    /**
     * In-order traversal
     * We put the `root` node value in the middle of the left and right child node value.
     */
    public static List<Integer> inOrderTraversalResult = new ArrayList<>();
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.leftChild);
        inOrderTraversalResult.add(root.value);
        inOrderTraversal(root.rightChild);
    }

    /**
     * Post-order traversal
     * We put the `root` node value after the left and right child node value.
     */
    public static List<Integer> postOrderTraversalResult = new ArrayList<>();
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        postOrderTraversalResult.add(root.value);
    }

    /**
     * Use `stack` to implement pre-order traversal, instead of `recursion` method
     * Any solution with `recursion` can be implemented with `stack`,
     * because `recursion` is actually a `stack` in essence, first in last out.
     */
    public static List<Integer> preOrderTraversalWithStackResult = new ArrayList<>();
    public static void preOrderTraversalWithStack(TreeNode root) {
        if (root == null) {
            return;
        }
        // Use `stack` to store the node after it is visited
        Stack<TreeNode> stack = new Stack<>();
        // Start from the `root` node
        TreeNode node = root;
        // If the `stack` is not empty or the `node` is not null, continue to traverse
        while (!stack.isEmpty() || node != null) {
            // loop to the left child node, until the left child node is null
            while (node != null) {
                // visit the node, retrieve the value
                preOrderTraversalWithStackResult.add(node.value);
                // put the node into the `stack` after it is visited
                stack.push(node);
                // next visit its left child node
                node = node.leftChild;
            }

            // check if the stack contains the parent nodes
            if (!stack.isEmpty()) {
                // pop the nearest parent node from the stack
                node = stack.pop();
                // assign the traverse to the right child node, starting that right side traverse
                node = node.rightChild;
            }
        }
    }

    /**
     * Level-order traversal
     * Put the `root` node value first, then the left child node value, and then the right child node value.
     * We use `queue` to implement the level-order traversal.
     */
    public static List<Integer> levelOrderTraversalResult = new ArrayList<>();
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // Use `queue` to store the node's children, so FIFO, we can keep the order of the nodes
        Queue<TreeNode> queue = new LinkedList<>();
        // Start from the `root` node
        queue.offer(root);
        // If the `queue` is not empty, continue to traverse
        while (!queue.isEmpty()) {
            // poll the node from the `queue`
            TreeNode node = queue.poll();
            // visit the node, retrieve the value
            levelOrderTraversalResult.add(node.value);
            // put the left child node into the `queue`
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            // put the right child node into the `queue`
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }


    public static void main(String[] args) {
        /*
              3
            2    8
           9 10    4
         */

        Integer[] inputArray = new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4};
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(inputArray));
        TreeNode treeNode = createBinaryTree(inputList);

        preOrderTraversal(treeNode);
        System.out.println(preOrderTraversalResult);
        // [3, 2, 9, 10, 8, 4]

        preOrderTraversalWithStack(treeNode);
        System.out.println(preOrderTraversalResult);

        inOrderTraversal(treeNode);
        System.out.println(inOrderTraversalResult);
        // [9, 2, 10, 3, 8, 4]

        postOrderTraversal(treeNode);
        System.out.println(postOrderTraversalResult);
        // [9, 10, 2, 4, 8, 3]

        levelOrderTraversal(treeNode);
        System.out.println(levelOrderTraversalResult);
        // [3, 2, 8, 9, 10, 4]

    }
}