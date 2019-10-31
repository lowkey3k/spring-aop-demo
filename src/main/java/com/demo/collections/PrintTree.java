package com.demo.collections;

/**
 * @author LiHaitao
 * @description PrintTree:
 * @date 2019/10/24 13:17
 **/

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 * <p>
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PrintTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        //        treeNode.right.left = new TreeNode(6);
        //        treeNode.left.left = new TreeNode(3);
        //        treeNode.left.left.left = new TreeNode(4);
        //        treeNode.left.left.left.left = new TreeNode(5);

        //        System.out.println(getDepth(treeNode));
        List<List<String>> lists = printTree(treeNode);
        //        System.out.println(lists.toString());
    }

    /**
     * m=-(1-2^n*2)
     * n=getDepth(root)
     *
     * @param root
     * @return
     */
    public static List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return Lists.newArrayList();
        }
        int depth = getDepth(root);
        int m = (int) (2 * Math.pow(2, (double) depth)) - 1;
        List<List<String>> result = new ArrayList<>(m + 1);
        List<String> fillList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            fillList.add("*");
        }
        fill(root, m, result);
        return result;
    }

    //
    //    private static void fill(TreeNode root, int start, int end, int m, List<List<String>> result, List<String> fillList) {
    //        if (root == null || (root.left == null && root.right == null)) {
    //            return;
    //        }
    //        for (int i = 0; i < m; i++) {
    //            fillList.set(i, "*");
    //        }
    //        Queue<TreeNode> queue = new LinkedList<>();
    //        queue.offer(root);
    //
    //        int pa = (start + end / 2) / 2;
    //        int pb = (end / 2 + end) / 2;
    //        if (root.left != null)
    //            fillList.set(pa, root.left.val + "");
    //        if (root.right != null)
    //            fillList.set(pb, root.right.val + "");
    //        fill(root.left, start, end / 2, m, result, fillList);
    //        fill(root.right, end / 2 + 1, m, m, result, fillList);
    //        System.out.println(fillList);
    //        result.add(fillList);
    //
    //    }


    private static void fill(TreeNode root, int m, List<List<String>> result) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<String> fillList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            fillList.add("*");
        }
        int position = m / 2;
        fillList.set(position, root.val + "");
        int pB = m / 2;
        int a = m;
        result.add(fillList);
        System.out.println(fillList);
        Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
        while (!queue.isEmpty() || !treeNodeQueue.isEmpty()) {
            treeNodeQueue = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                treeNodeQueue.offer(queue.poll());
            }

            List<String> fill = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                fill.add("*");
            }
            a = a / 2;
            int pA = (0 + a) / 2;
            pB = (pB + 1 + m) / 2;


            while (!treeNodeQueue.isEmpty()) {
                TreeNode node = treeNodeQueue.poll();
                if (node.left != null) {
                    fill.set(pA, node.left.val + "");
                }
                if (node.right != null) {
                    fill.set(pB, node.right.val + "");
                }
                if (node.left != null && (node.left.left != null || node.left.right != null)) {
                    queue.offer(node.left);
                }
                if (node.right != null && (node.right.left != null || node.right.right != null)) {
                    queue.offer(node.right);
                }
            }
            result.add(fill);
            System.out.println(fill);

        }

    }


    private static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (root.left != null && root.right != null) {
                int leftDepth = getDepth(root.left) + 1;
                int rightDepth = getDepth(root.right) + 1;
                return leftDepth > rightDepth ? leftDepth : rightDepth;
            }
            if (root.left != null) {
                return getDepth(root.left) + 1;
            }
            if (root.right != null) {
                return getDepth(root.right) + 1;
            }
        }
        return 0;
    }

}
