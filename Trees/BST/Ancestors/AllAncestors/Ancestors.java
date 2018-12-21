import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Ancestors{

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

    public static boolean getAncestors(Node node, int id){

        ArrayList<Node> parents = new ArrayList<Node>();
        parents = getAncestors(node, id, parents);

        if(parents != null){
            for(int i = parents.size() - 1; i >= 0; i--){
                System.out.printf("%d ", parents.get(i).data);
            }
            return true;
        }

        return false;

    }

    //performs a level order traversal to determine the max horizaontal width of a binary tree
    public static ArrayList<Node> getAncestors(Node node, int id, ArrayList<Node> parent_list){

        //checks to see if we are at the end
        if(node == null){
            return null;
        } 
        
        //if we arent at the end check to see if we are at the desired depth
        else if(node.data == id){
            return parent_list;
        }

        //traverse in the usual manor
        else{

            //check the left path for nodes at k depth
            parent_list.add(node);
            if(getAncestors(node.left, id, parent_list) != null){
                return parent_list;
            } else{
                parent_list.remove(node);//remove the node and check the next position
            }

            //check the right depth for nodes at k depth
            parent_list.add(node);
            if(getAncestors(node.right, id, parent_list) != null){
                return parent_list;
            } else{
                parent_list.remove(node);//remove the node and check the next position
            }
        }

        return null;
    }
    
    public static void main(String[] args){

        Node root = new Node(2);

        //add some elements to the tree
        Integer[] values = {1,41,52,3,21,4,64,8,9};

        //add a bunch of new values
        for(Integer value: values){
            Node new_node = new Node(value);
            add(root, new_node);
        }

        //gets the ancestors of the given node
        getAncestors(root,21);
    }

}