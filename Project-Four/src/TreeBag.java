
// File: TreeBag.java 

// The implementation of most methods in this file is left as a student
// exercise from Section 9.5 of "Data Structures and Other Objects Using Java"


/******************************************************************************

* An <CODE>TreeBag</CODE> is a collection of int numbers.
*
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond <CODE>Integer.MAX_VALUE</CODE> elements, <CODE>countOccurrences</CODE>,
*   and <CODE>size</CODE> are wrong. 
*
* <dt><b>Note:</b><dd>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @version
*   Jan 24, 2016
******************************************************************************/
public class TreeBag< E extends Comparable> implements Cloneable
{
   // The Term E extends Comparable is letting the compiler know that any type
   // used to instantiate E must implement Comparable. i. e. that means that whatever
   // type E is must have a compareTo method so that elements can be compared against one another
   // This is required because we are doing comparisons in our methods


   // Invariant of the TreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private BTNode<E> root;   
 

   /**
   * Insert a new element into this bag.
   * @param <CODE>element</CODE>
   *   the new element that is being inserted
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new BTNode.
   **/
   public void add(E element)
   
   {      
	   BTNode node = new BTNode(element, null, null);
   
	   if(root ==null) {
		  this.root = node;
	   }else {
		   insert(root,node);
	   }
	  
      
   }
   private void insert(BTNode<E> parent, BTNode<E> child ) {
	   
	   if((parent.getData()).compareTo(child.getData())>=0) {
		   if(parent.getLeft()==null) {
			   parent.setLeft(child);
			   
		   }else {
			   insert(parent.getLeft(),child);
		   }	   
		   
	   }else{
		   if(parent.getRight()==null) {
			   parent.setRight(child);
		   }else{
			   insert(parent.getRight(),child);
		   }   
	   }
   }

   /**
   * Retrieve location of a specified element from this bag.
   * @param <CODE>target</CODE>
   *   the element to locate in the bag
   * @return 
   *  the return value is a reference to the found element in the tree
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then method returns
   *   a reference to a comparable element. If the target was not found then
   *   the method returns null.
   *   The bag remains unchanged.
   **/
   
   public E retrieveRecursively(BTNode<E>root,E target)
   {      
	       if (root==null) 
	    	   return null;
		   
	       else if (root.getData().compareTo(target)==0) 
		   
			  return  root.getData();
		 
		   else if (root.getData().compareTo(target)>0) 
			      
			  return  retrieveRecursively(root=root.getLeft(),target);
		
		   else		  
			  return  retrieveRecursively(root=root.getRight(),target);	   
	   
	   }
   
   

   public E retrieve(E target)
   {      
	   
	   BTNode <E>currentNode= root;
	   
	   while (currentNode != null) {
		   
		   if (currentNode.getData().compareTo(target)==0) 
		   
			   return  currentNode.getData();
		 
		   if (currentNode.getData().compareTo(target)>0) 
	  
				   currentNode=currentNode.getLeft();
		
		   if (currentNode.getData().compareTo(target)<0) 
			  
				   currentNode=currentNode.getRight();
			  
	   }
	   return null;
   }
   
   /**
   * Remove one copy of a specified element from this bag.
   * @param <CODE>target</CODE>
   *   the element to remove from the bag
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then one copy of
   *   <CODE>target</CODE> has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   public boolean remove(E target)
   {
      BTNode<E>cursor= root;
      BTNode<E>parentOfCursor=null;
      
      while(cursor!= null&&!(cursor.getData().compareTo(target)==0)) {
    	  
    	  if (cursor.getData().compareTo(target)>0) 
    	  {
    		  parentOfCursor = cursor;
    		  cursor = cursor.getLeft();
    	  }
    	  if (cursor.getData().compareTo(target)<0) 
    	  {
    		  parentOfCursor = cursor;
    		  cursor = cursor.getRight();
    	  } 
      
      }
      if(cursor == null) 
      {					//target not found;
    	  return false;
      }
      else if(cursor==root&&cursor.getLeft()==null)  // target is at the root, with no left child 
      {
    	  root= root.getRight();
    	  return true;
      }
      else if(cursor.getLeft()==null) 				// target if not at the root, but has no left child 
      {	 
    	 if(parentOfCursor.getRight()==cursor)
    	 {
    		 parentOfCursor.setRight(cursor.getRight());    	
    		 return true;
    	 }
    	 else
    	 {
    		 parentOfCursor.setLeft(cursor.getRight());    	
    		 return true;
    		 
    	 }
    	
      
      }
      else if(cursor.getRight()!=null)
      {
    	  cursor.setData(cursor.getLeft().getRightmostData());
    	  cursor.setLeft(cursor.getLeft().removeRightmost());
    	  return true;
    	  
      }
  
        return false;
   }
   
   /**
   * Displays the entire tree of Node elements in a order specified
   * by the elements compareTo method
   * 
   * @param 
   *   none
   * <dt><b>Postcondition:</b><dd>
   *   Outputs all elements in the tree to Screen.
   *   Does not change the structure 
   **/
   public void display()
   {
	   if (root == null) 
	   {
		   throw new IllegalStateException ("Tree is empty");
	   }
	   else 
	   {
		   root.inorderPrint();
	   }
      
      
   } 
     
   /**
   * Displays the entire tree of Node elements using the
   * built in print method of BTNode
   * which displays the entire tree in tree format
   * 
   * @param 
   *   none
   * <dt><b>Postcondition:</b><dd>
   *   Outputs all elements in the tree to Screen.
   *   Does not change the structure 
   **/   
   public void displayAsTree() {
      root.print(0);
   }
      
   
   
   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to an <CODE>TreeBag</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public TreeBag<E> clone( )
   {  // Clone an IntTreeBag object.
      // Student will replace this return statement with their own code:
      return null; 
   } 

   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param <CODE>target</CODE>
   *   the element that needs to be counted
   * @return
   *   the number of times that <CODE>target</CODE> occurs in this bag
   **/
   public int countOccurrences(E target)
   {
      // Student will replace this return statement with their own code:
      return 0;
   }
   
       
   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/                           
   public int size( )
   {
      return BTNode.treeSize(root);
   }




   /**
   * Add the contents of another bag to this bag.
   * @param <CODE>addend</CODE>
   *   a bag whose contents will be added to this bag
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null.
   * <dt><b>Postcondition:</b><dd>
   *   The elements from <CODE>addend</CODE> have been added to this bag.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>addend</CODE> is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of the bag.
   **/
   public void addAll(TreeBag<E> addend)
   {
      // Implemented by student.
   }
   
   /**
   * Create a new bag that contains all the elements from two other bags.
   * @param <CODE>b1</CODE>
   *   the first of two bags
   * @param <CODE>b2</CODE>
   *   the second of two bags
   * <dt><b>Precondition:</b><dd>
   *   Neither b1 nor b2 is null.
   * @return
   *   the union of b1 and b2
   * @exception IllegalArgumentException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new bag.
   **/   
   public static TreeBag union(TreeBag b1, TreeBag b2)
   {
      // Student will replace this return statement with their own code:
      return null;
   }
   
   public static<E> int numberOfNodes(BTNode<Golfer>source) {
	   
	   if(source==null) {
		  return 0;
	   }else {   
		   return 1+numberOfNodes(source.getLeft()) +  numberOfNodes(source.getRight());
		   
	   }
   }
   
   public static<E> int height(BTNode<E>source) {
	 
	   if(source==null) {
		  return -1;
	   }else { 		   
		   int leftDepth = height(source.getLeft());
		   int rightDepth = height(source.getRight());
		   return 1+ Math.max(leftDepth, rightDepth);  
	   }
	   
   }
  
   public static void main(String []args){
	   
	   TreeBag<Golfer> t = new TreeBag<Golfer>();
	   Golfer g6 = new Golfer("b");
	   Golfer g7 = new Golfer("b");
	   Golfer g1 = new Golfer("c");
	   Golfer g2 = new Golfer("a");
	   Golfer g3 = new Golfer("d");
	   Golfer g4 = new Golfer("s");
	   Golfer g5 = new Golfer("b");
	   Golfer g8 = new Golfer("f");
	   Golfer g9 = new Golfer("h");
	   t.add(g1);
	   t.add(g2);
	   t.add(g3);
	   t.add(g4);
	   t.add(g5);
	   t.add(g6);
	   t.add(g7);
	   t.add(g8);
	   t.add(g9);
	
	  Golfer g = new Golfer("f");
	  t.display();
	  //System.out.println(t.remove(g5));
	   System.out.println(t.retrieveRecursively(t.root, g8));
	   t.display();
	  //System.out.println("Root"+t.root.getData());
	  //System.out.println("Left"+t.root.getLeft().getData());
	  //System.out.println("Right"+t.root.getRight().getData());
	  
   }
      
}
           
