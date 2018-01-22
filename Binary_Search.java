/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

     package binary_search;

     import java.util.Scanner;

 /**
 *
 * @author suraz
 */

     class BSTNode

     {

         BSTNode left, right;

         int data;

     
         public BSTNode()           /* Constructor */

         {

             left = null;

             right = null;

             data = 0;

         }

 
         public BSTNode(int n)         /* Constructor */

         {

             left = null;

             right = null;

             data = n;

         }

         public void setLeft(BSTNode n)  /* Function for left node */

         {

             left = n;

         }

         public void setRight(BSTNode n)    /* Function to set right node */ 

         {

             right = n;

         }

         public BSTNode getLeft()         /* Function to get left node */

         {

             return left;

         }

         public BSTNode getRight()        /* Function to get right node */


         {

             return right;

         }

         public void setData(int d)      /* Function to set data to node */


         {

             data = d;

         }

         public int getData()         /* Function to get data from node */

         {

             return data;

         }     

     }

     
     class BST

     {

         private BSTNode root;

     
         public BST()      /* Constructor */

         {

             root = null;

         }

        
         public boolean isEmpty() /* Function to check if tree is empty */

         {

             return root == null;

         }

         
         public void insert(int data)/* Functions to insert data */

         {

             root = insert(root, data);

         }

        
         private BSTNode insert(BSTNode node, int data)  /* Function to insert data recursively */


         {

             if (node == null)

                 node = new BSTNode(data);

             else

             {

                 if (data <= node.getData())

                     node.left = insert(node.left, data);

                 else

                     node.right = insert(node.right, data);

             }

             return node;

         }


         public void delete(int k)             /* Functions to delete data */

         {

             if (isEmpty())

                 System.out.println("Tree Empty");

             else if (search(k) == false)

                 System.out.println("Sorry "+ k +" is not present");

             else

             {

                 root = delete(root, k);

                 System.out.println(k+ " deleted from the tree");

             }

         }

         private BSTNode delete(BSTNode root, int k)

         {

             BSTNode p, p2, n;

             if (root.getData() == k)

             {

                 BSTNode lt, rt;

                 lt = root.getLeft();

                 rt = root.getRight();

                 if (lt == null && rt == null)

                     return null;

                 else if (lt == null)

                 {

                     p = rt;

                     return p;

                 }

                 else if (rt == null)

                 {

                     p = lt;

                     return p;

                 }

                 else

                 {

                     p2 = rt;

                     p = rt;

                     while (p.getLeft() != null)

                         p = p.getLeft();

                     p.setLeft(lt);

                     return p2;

                 }

             }

             if (k < root.getData())

             {

                 n = delete(root.getLeft(), k);

                 root.setLeft(n);

             }

             else

             {

                 n = delete(root.getRight(), k);

                 root.setRight(n);             

             }

             return root;

         }

         public int countNodes()          /* Functions to count number of nodes */

         {

             return countNodes(root);

         }

         private int countNodes(BSTNode r) /* Function to count number of nodes recursively */

         {

             if (r == null)

                 return 0;

             else

             {

                 int l = 1;

                 l += countNodes(r.getLeft());

                 l += countNodes(r.getRight());

                 return l;

             }

         }

         
         public boolean search(int val) /* Functions to search for an element */


         {

             return search(root, val);

         }

         private boolean search(BSTNode r, int val)   /* Function to search for an element recursively */


         {

             boolean found = false;

             while ((r != null) && !found)

             {

                 int rval = r.getData();

                 if (val < rval)

                     r = r.getLeft();

                 else if (val > rval)

                     r = r.getRight();

                 else

                 {

                     found = true;

                     break;

                 }

                 found = search(r, val);

             }

             return found;

         }

         
         public void inorder()   /* Function for inorder traversal */

         {

             inorder(root);

         }

         private void inorder(BSTNode r)

         {

             if (r != null)

             {

                 inorder(r.getLeft());

                 System.out.print(r.getData() +" ");

                 inorder(r.getRight());

             }

         }


         public void preorder()               /* Function for preorder traversal */

         {

             preorder(root);

         }

         private void preorder(BSTNode r)

         {

             if (r != null)

             {

                 System.out.print(r.getData() +" ");

                 preorder(r.getLeft());             

                 preorder(r.getRight());

             }

         }

         
         public void postorder() /* Function for postorder traversal */


         {

             postorder(root);

         }

         private void postorder(BSTNode r)

         {

             if (r != null)

             {

                 postorder(r.getLeft());             

                 postorder(r.getRight());

                 System.out.print(r.getData() +" ");

             }

         }     

     }

     

     public class Binary_Search    /* BinarySearchTree */

     /**
     * @param args the command line arguments
     */  
     {

         public static void main(String[] args)

        {                 

            Scanner scan = new Scanner(System.in);
            
            BST bst = new BST(); 

            System.out.println("Binary Search Tree Test\n");          

            char ch;

            do    

            {

                System.out.println("\nBinary Search Tree Operations\n");

                System.out.println("1. insert ");

                System.out.println("2. delete");

                System.out.println("3. search");

                System.out.println("4. count nodes");

                System.out.println("5. check empty"); 

     

                int choice = scan.nextInt();            

                switch (choice)

                {

                case 1 : 

                    System.out.println("Enter integer element to insert");

                    bst.insert( scan.nextInt() );                     

                    break;                          

                case 2 : 

                    System.out.println("Enter integer element to delete");

                    bst.delete( scan.nextInt() );                     

                    break;                         

                case 3 : 

                    System.out.println("Enter integer element to search");

                    System.out.println("Search result : "+ bst.search( scan.nextInt() ));

                    break;                                          

                case 4 : 

                    System.out.println("Nodes = "+ bst.countNodes());

                    break;     

                case 5 :  

                    System.out.println("Empty status = "+ bst.isEmpty());

                    break;            

                default : 

                    System.out.println("Wrong Entry \n ");

                    break;   

                }

                System.out.print("\nPost order : ");

                bst.postorder();

                System.out.print("\nPre order : ");

                bst.preorder();

                System.out.print("\nIn order : ");

                bst.inorder();

     

                System.out.println("\nDo you want to continue (Type y or n) \n");

                ch = scan.next().charAt(0);                        

            } while (ch == 'Y'|| ch == 'y');               

        }

     }
