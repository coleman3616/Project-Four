
// File: TreeBag.java 


/******************************************************************************
*@author Stryder R. Coleman and Roman Kozulia
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
   * Add a new element into this bag.
   * @param <CODE>element</CODE>
   *   the new element that is being inserted
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new BTNode.
   * @note calls insert method when the tree is not empty 
   **/
   public void add(E element)
   
   {      
	   BTNode node = new BTNode(element, null, null);   // create new node to insert 
   
	   if(root ==null) {								// if tree is empty, make add new node as the root
		  this.root = node;
	   }else {
		   insert(root,node);							// otherwise, call insert method 
	   } 
   }
   
   /**
    * Insert a new element into this bag.
    * @param parent (root node) and child (node to insert)
    *   the new element that is being inserted
    * <dt><b>Postcondition:</b><dd>
    *   A new copy of the element has been added to this bag.
    * @exception OutOfMemoryError
    *   Indicates insufficient memory a new BTNode.
    * @note uses compareTo() method to compare elements. Methods calls itself 
    * recursively until an empty spot is found.
    **/
   private void insert(BTNode<E> parent, BTNode<E> child ) 
   {
	   
	   if((parent.getData()).compareTo(child.getData())>0)
	   {		// if root's name ASCII code > than child's
		   if(parent.getLeft()==null) 
		   {							    						// try to insert to the left
			   parent.setLeft(child);							     
		   }
		   else 
		   {														// if root already has left child, call the method 
			   insert(parent.getLeft(),child);					    //recursively making its left child new root. 
		   }	   
		   
	   }
	   else
	   {															// do the same algorithm if ASCII code < than child's
		   if(parent.getRight()==null) 
		   {
			   parent.setRight(child);
		   }
		   else
		   {
			   insert(parent.getRight(),child);
		   }   
	   }
   }

   /**
   * Retrieve location of a specified element from this bag.
   * @param <CODE>target</CODE>, BTNode<E>root. 
   * target - the element to locate in the bag
   * @return 
   *  the return value is a reference to the found element in the tree
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then method returns
   *   a reference to a comparable element. If the target was not found then
   *   the method returns null.
   *   The bag remains unchanged.
   *   @Note method uses recursion for search.
   **/
   //
   public E retrieveRecursively(BTNode<E>root,E target)
   {      
	       if (root==null) 										// if tree is empty - return null;
	    	   return null;
		   
	       else if (root.getData().compareTo(target)==0) 		// if  target's name ASCII code = than root's => object is 
	    	   												    // found, return it. 
			  return  root.getData();
		 
		   else if (root.getData().compareTo(target)>0) 		// if  target's name ASCII code < than root's 
			      												// call this method recursively with the root set to its left node 
			  return  retrieveRecursively(root=root.getLeft(),target);
	       														// if  target's name ASCII code > than root's 
																// call this method recursively with the root set to its right node 
		   else		  										   
			  return  retrieveRecursively(root=root.getRight(),target);	  	   
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
      BTNode<E>cursor= root;											// set temporary nodes: cursor, parentCursor
      BTNode<E>parentOfCursor=null;
      															    	// find node to remove. 
      while(cursor!= null&&!(cursor.getData().compareTo(target)==0)) 
      {																	// Move cursor to the left/ right node of the root depending 
    	  																// on compare to evaluation.
    	  if (cursor.getData().compareTo(target)>=0) 				    // loop stops when cursor == null or object is foud 
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
      {												 //target not found;
    	  return false;
      }
      else if(cursor==root&&cursor.getLeft()==null)  // target is at the root, with no left child 
      {
    	  root= root.getRight();					 // make root's left node new root
    	  return true;
      }
      else if(cursor.getLeft()==null) 				 // target if not at the root, but has no left child 
      {	 											 // set parentOfCursor's  left/right child to cursor's right child
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
      else if(cursor.getRight()!=null)							// if cursor has a right child, 
      {															// set cursor to its left child's rightmost data.   	       									    			// remove cursor's left child's rightmost node. 
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
		   root.inorderPrint();					// use inheritor print to print in alphabetical order
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
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/                           
   public int size( )
   {
      return BTNode.treeSize(root);
   }   
}
           
