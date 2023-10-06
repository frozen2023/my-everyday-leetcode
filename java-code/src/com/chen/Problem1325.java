package com.chen;


public class Problem1325 {

    /*
    * 本题就是普通的递归
    * 但是我想的太复杂了
    * */

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }


    // 下面是我写的， 依托答辩，不知道什么思路

    /*Map<TreeNode, TreeNode> father = new HashMap<>(3001);

    List<TreeNode> leaf = new ArrayList<>();

    public TreeNode removeLeafNodes(TreeNode root, int target){
        visit(root);
        for (TreeNode each : leaf) {
            if (!removeLeaf(each, target)) {
                return null;
            }
        }
        return root;
    }

    public boolean removeLeaf(TreeNode each, int target) {
        if (each.val == target) {
            TreeNode fn = father.get(each);
            if (fn == null) {
                return false;
            }
            if (fn.left == each) {
                fn.left = null;
            } else {
                fn.right = null;
            }
            if (isLeafNode(fn)) {
                return removeLeaf(fn, target);
            }
        }
        return true;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void visit(TreeNode node) {
        boolean left = false, right = false;
        if (node.left != null) {
            father.put(node.left, node);
            visit(node.left);
            left = true;
        }
        if (node.right != null) {
            father.put(node.right, node);
            visit(node.right);
            right = true;
        }
        if (!left && !right) {
            leaf.add(node);
        }
    }
*/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(1, null, null), new TreeNode(1, null, null));
        TreeNode treeNode = new Problem1325().removeLeafNodes(root, 1);
        System.out.println(treeNode == null);
    }


}
