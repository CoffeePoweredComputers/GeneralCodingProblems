// INITIAL CODE PROVIDED BY GEEKS4GEEKS
// Please note that this code is purely for show and outside of the Geeks4Geeks environment will not run without significant modification!
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
import java.util.*;
import java.lang.*;
import java.io.*;

// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Level_Order_Traverse{
	
    // driver function to test the above functions
    public static void main(String args[])    {
		
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		//Node root=null;
        while (t > 0)        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null){
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
		
            GfG g = new GfG();
            g.levelOrder(root);
			System.out.println();
            t--;
			
        }
    }
}

//
// This class contains a method that performs and outputs a level order traversal
//
class GfG{
    
    void levelOrder(Node node){
        //Initialize a queue to store the nodes head
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            
            //get the first avaliable node from the queue
            Node curr_node = queue.pop();
            System.out.print(curr_node.data);
            
            //add the children to the list
            if(curr_node.left != null){
                queue.add(curr_node.left);
            }
            
            if(curr_node.right != null){
                queue.add(curr_node.right);
            }
            System.out.print(" ");
        } 
    }
}