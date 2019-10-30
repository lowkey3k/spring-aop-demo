package com.demo.collections;

/**
 * @author LiHaitao
 * @description PrintTree:
 * @date 2019/10/24 13:17
 **/

import java.util.ArrayList;
import java.util.List;

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
        treeNode.left.left = new TreeNode(3);
        System.out.println(getDepth(treeNode));
    }

    /**
     * m=-(1-2^n*2)
     * n=getDepth(root)
     *
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        int m = (int) (2 * Math.pow(2, (double) depth)) + 1;
        List<String> row = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            row.add("");
        }
        row.add(m / 2, root.val + "");

        return null;
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
