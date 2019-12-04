package com.demo.collections;

/**
 * @author LiHaitao
 * @description MergeTrees:合并二叉树
 * @date 2019/11/8 14:32
 **/
public class MergeTrees {
    public static void main(String[] args) {
        //        TreeNode treeNode
        mergeTreesRefactor(null, null);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            t1 = new TreeNode(t2.val);
            t1.left = mergeTrees(null, t2.left);
            t1.right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            t1.left = mergeTrees(t1.left, null);
            t1.right = mergeTrees(t1.right, null);
        } else {
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }
        return t1;
    }

    public static TreeNode mergeTreesRefactor(TreeNode t1, TreeNode t2) {
        float f = 3.4f;
        if (t1 != null && t2 != null) {
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
        //如果两个二叉树任一节点存在，则合并（这一层包含了t2=null的情况，即条件3））是递归的结束条件
       /* if(t1 == null){
            return t2;
        }else{
            return t1;
        }*/
        //化简后如下
        return t1 == null ? t2 : t1;
    }
}
