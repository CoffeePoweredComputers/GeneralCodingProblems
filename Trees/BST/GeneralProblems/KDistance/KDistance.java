import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.io.*;


public class KDistance{

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
    public static ArrayList<Integer> getNodesAtDepth(Node node, int needed_depth, int curr_depth){
        
        //integer array to keep track of the nodes
        ArrayList<Integer> elems = new ArrayList<Integer>();

        //checks to see if we are at the end
        if( node == null){
            return null;
        } 
        
        //if we arent at the end check to see if we are at the desired depth
        else if(needed_depth == curr_depth){
            elems.add(node.data);
            return elems;
        }

        //traverse in the usual manor
        else{

            //check the left path for nodes at k depth
            ArrayList<Integer> left_val = getNodesAtDepth(node.left, needed_depth, curr_depth + 1);
            if(left_val != null){
                elems.addAll(left_val);
            }

            //check the right depth for nodes at k depth
            ArrayList<Integer> right_val = getNodesAtDepth(node.right, needed_depth, curr_depth + 1);
            if(right_val != null){
                elems.addAll(right_val);
            }
        }
        
        return elems;
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

        //gets all nodes at k depth in order
        ArrayList<Integer> nodes = getNodesAtDepth(root,0,0);

        System.out.println(nodes.toString());

    }

}