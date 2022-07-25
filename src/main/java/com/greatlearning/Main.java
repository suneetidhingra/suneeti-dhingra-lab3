package com.greatlearning;

import com.greatlearning.model.Node;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static HashSet<Integer> values = new HashSet<>();
    public static int n1;

    public static void main(String[] args) {

        Node d = new Node(10, null, null);
        Node e = new Node(30, null, null);
        Node f = new Node(50, null, null);
        Node g = new Node(70, null, null);
        Node b = new Node(20, d, e);
        Node c = new Node(60, f, g);
        Node a = new Node(40, b, c);

        System.out.print("Enter target sum: ");
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();

        findSum(a, sum);
    }

    private static void findSum(Node root, int target) {
        boolean isFoundSum = postOrderTraversal(root, target);
        if (isFoundSum) {
            System.out.printf("Pair is (%d, %d)\n", n1, target-n1);
        } else {
            System.out.println("Nodes are not found");
        }
    }

    public static boolean postOrderTraversal(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (postOrderTraversal(root.getLeft(), target)) {
            return true;
        }
        if (postOrderTraversal(root.getRight(), target)) {
            return true;
        }
        int data = root.getData();
        if (values.contains(target - data)) {
            n1 = data;
            return true;
        }
        values.add(data);
        return false;
    }
}