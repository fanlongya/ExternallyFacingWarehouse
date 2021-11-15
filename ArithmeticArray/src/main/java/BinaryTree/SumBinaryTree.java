package BinaryTree;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

public class SumBinaryTree {
    public static void main(String[] args) {

    }
    public static TreeNode method(TreeNode root1,TreeNode root2){
        if(root1==null&root2==null){
            return null;
        }
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode treeNode=new TreeNode(root1.val+root2.val);
        treeNode.leftNode=method(root1.leftNode,root2.leftNode);
        treeNode.rightNode=method(root1.rightNode,root2.rightNode);
        return treeNode;
    }
    public static TreeNode method1(TreeNode root1,TreeNode root2){
        if(root1==null)return root2;
        if(root2==null)return root1;
        TreeNode temp=new TreeNode(root1.val+root2.val);
        Queue queue=new LinkedList();
        Queue queue1=new LinkedList<>();
        Queue queue2=new LinkedList<>();
        queue.add(temp);
        queue1.add(root1);
        queue2.add(root2);
        while (!queue1.isEmpty()&!queue2.isEmpty()){
            TreeNode treeNode=(TreeNode) queue.peek();
            TreeNode treeNode1=(TreeNode) queue1.peek();
            TreeNode treeNode2=(TreeNode) queue2.peek();
            TreeNode left1=treeNode1.leftNode,left2=treeNode2.leftNode,
                    right1=treeNode1.rightNode,right2=treeNode2.rightNode;
            if(left1!=null|left2!=null){
                if(left1!=null&left2!=null){
                    treeNode.leftNode=new TreeNode(left1.val+left2.val);
                    queue.add(treeNode.leftNode);
                    queue1.add(left1);
                    queue2.add(left2);
                }else if(left1!=null){
                    treeNode.leftNode=left2;
                }else if(left2!=null){
                    treeNode.leftNode=left1;
                }
            }
            if(right1!=null|right2!=null){
                if(right1!=null&right2!=null){
                    treeNode.leftNode=new TreeNode(right1.val+right2.val);
                    queue.add(treeNode.leftNode);
                    queue1.add(right1);
                    queue2.add(right2);
                }else if(right1!=null){
                    treeNode.leftNode=right2;
                }else if(right2!=null){
                    treeNode.leftNode=right1;
                }
            }
        }
        return temp;
    }

//    if(root1==null)return root2;
//        if(root2==null)return root1;
//    TreeNode temp=new TreeNode(root1.val+root2.val);
//    Queue queue=new LinkedList();
//    Queue queue1=new LinkedList<>();
//    Queue queue2=new LinkedList<>();
//        queue.add(temp);
//        queue1.add(root1);
//        queue2.add(root2);
//        while (!queue1.isEmpty()&!queue2.isEmpty()){
//        TreeNode treeNode=(TreeNode) queue.peek();
//        TreeNode treeNode1=(TreeNode) queue1.peek();
//        TreeNode treeNode2=(TreeNode) queue2.peek();
//        TreeNode left1=treeNode1.left,left2=treeNode2.left,
//                right1=treeNode1.right,right2=treeNode2.right;
//        if(left1!=null|left2!=null){
//            if(left1!=null&left2!=null){
//                treeNode.left=new TreeNode(left1.val+left2.val);
//                queue.add(treeNode.left);
//                queue1.add(left1);
//                queue2.add(left2);
//            }else if(left1!=null){
//                treeNode.left=left2;
//            }else if(left2!=null){
//                treeNode.left=left1;
//            }
//        }
//        if(right1!=null|right2!=null){
//            if(right1!=null&right2!=null){
//                treeNode.left=new TreeNode(right1.val+right2.val);
//                queue.add(treeNode.left);
//                queue1.add(right1);
//                queue2.add(right2);
//            }else if(right1!=null){
//                treeNode.left=right2;
//            }else if(right2!=null){
//                treeNode.left=right1;
//            }
//        }
//    }
//        return temp;
}
