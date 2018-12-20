import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.io.*;


public class BSTMaxWidth{

    //Binary Tree node 
    public static class Node{
        public Integer data, count;
        public Node left, right;

        Node(Integer data){
            this.data = data;
            count = 0;
            left = null;
            right = null;
        }
    }

    //adds a node to the binary search tree
    public static void add(Node curr_node, Node new_node){
        
        //procedes to the left
        if(curr_node.data > new_node.data){
            if(curr_node.left == null){
                curr_node.left = new_node;
            }else{
                add(curr_node.left, new_node);
            }
        }

        //procedes the the right
        else if(curr_node.data < new_node.data){
            if(curr_node.right == null){
                curr_node.right = new_node;
            }else{
                add(curr_node.right, new_node);
            }
            
        }

        //update the count of this element
        else{
            curr_node.count++;
        }

    }

    //performs a level order traversal to determine the max horizaontal width of a binary tree
    public static int getMaxWidth(Node node){
        //Initialize a queue to store the nodes head
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        //keep track of the max width
        int max_width = 0;
        

        while(!queue.isEmpty()){

            //check the current width
            if(queue.size() > max_width){
                max_width = queue.size();
            }
            
            //get the first avaliable node from the queue
            Node curr_node = queue.pop();
            
            //add the children to the list
            if(curr_node.left != null){
                queue.add(curr_node.left);
            }
            
            if(curr_node.right != null){
                queue.add(curr_node.right);
            }
        } 

        return max_width;
    }
    
    public static void main(String[] args){

        Node root = new Node(5);

        //add some elements to the tree
        Integer[] values = {1,41,52,3,21,4,5,64,8,9};

        //add a bunch of new values
        for(Integer value: values){
            Node new_node = new Node(value);
            add(root, new_node);
        }

        //perform some traversals
        int max_width = getMaxWidth(root);
        System.out.printf("The max width of the binary tree is: %d\n",max_width);

    }

}