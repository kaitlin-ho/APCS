/*
AKH+D :: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW 97 - Prune Your Tree
2022-05-11
time spent: 1.0 hrs
*/

/**
 * class BST
 * v1:partial
 * SKELETON
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 *
 * This BST implementation only holds ints (its nodes have int cargo)
 */

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /**
   * default constructor
   */
  BST()
  {
    _root = null;
  }


  /**
     * void insert( int )
     * Adds a new data element to tree.
     */
    public void insert( int newVal )
    {
      TreeNode newNode = new TreeNode( newVal );

      if ( _root == null ) {
        _root = newNode;
        return;
      }
      insert( _root, newNode );
    }
    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode )
    {
      if ( newNode.getValue() < stRoot.getValue() ) {
        //if no left child, make newNode the left child
        if ( stRoot.getLeft() == null )
          stRoot.setLeft( newNode );
        else //recurse down left subtree
          insert( stRoot.getLeft(), newNode );
        return;
      }
      else { // new val >= curr, so look down right subtree
        //if no right child, make newNode the right child
        if ( stRoot.getRight() == null )
          stRoot.setRight( newNode );
        else //recurse down right subtree
          insert( stRoot.getRight(), newNode );
        return;
      }
    }//end insert()

  /**
   * TreeNode remove( int )
   * Removes a data element from tree.
   */
  public TreeNode remove( int val )
  {
    TreeNode node = search(val);
    boolean flag = (findParent(_root, node) == null);
    System.out.println("findParent is null: " + flag);
    return remove(findParent(_root, node), node);
  }
  //helper for remove(int)
  public TreeNode remove( TreeNode parent, TreeNode node )
  {
    boolean isLeft = (parent.getLeft() != null &&
                      parent.getLeft().getValue() == node.getValue());
    //if node has no children:
    if (node.getRight() == null && node.getLeft() == null) {
      if (isLeft) {
        parent.setLeft(null);
      }
      else {
        parent.setRight(null);
      }
    }
    //if node has one child:
    else if (node.getRight() == null) {
      if (isLeft) {
        parent.setLeft(node.getLeft());
      }
      else {
        parent.setRight(node.getLeft());
      }
    }
    else if (node.getLeft() == null) {
      if (isLeft) {
        parent.setLeft(node.getRight());
      }
      else {
        parent.setRight(node.getRight());
      }
    }
    //if node has two children:
    else {
      TreeNode tn = node.getLeft();
      while (tn.getRight() != null) {
        tn = tn.getRight();
      }
      TreeNode pt = findParent(node, tn);
      node.setValue(tn.getValue());
      //if replacement has no children:
      if (tn.getLeft() == null) {
        pt.setRight(null);
      }
      //if replacement has children (it will be a left child):
      else {
        pt.setRight(tn.getLeft());
      }
    }
    return node;
  }//end remove()
  //recursive helper for remove(int)
  //returns null if the node isn't even there
  public TreeNode findParent(TreeNode stRoot, TreeNode node)
  {
    //if _root is the node ur looking for, make up a parent for it
    if (stRoot.getValue() == node.getValue()) {
      TreeNode temp = new TreeNode(Integer.MAX_VALUE, null, stRoot);
      return temp;
    }
    if ((stRoot.getLeft() != null && stRoot.getLeft().getValue() == node.getValue())
    || (stRoot.getRight() != null && stRoot.getRight().getValue() == node.getValue())) {
      return stRoot;
    }
    else if (search(node.getValue(), stRoot.getLeft()) != null) {
      return findParent(stRoot.getLeft(), node);
    }
    else if (search(node.getValue(), stRoot.getRight()) != null) {
      return findParent(stRoot.getRight(), node);
    }
    else { return null; }
  }



  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~
    // each traversal should simply print to standard out
    // the nodes visited, in order

    //process root, recurse left, recurse right
    public void preOrderTrav()
    {
      preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode currNode )
    {
      if ( currNode == null )
        return;
      System.out.print( currNode.getValue() + " " );
      preOrderTrav( currNode.getLeft() );
      preOrderTrav( currNode.getRight() );
    }

    //recurse left, process root, recurse right
    public void inOrderTrav()
    {
      inOrderTrav( _root );
    }
    public void inOrderTrav( TreeNode currNode )
    {
      if ( currNode == null )
        return;
      inOrderTrav( currNode.getLeft() );
      System.out.print( currNode.getValue() + " " );
      inOrderTrav( currNode.getRight() );
    }

    //recurse left, recurse right, process root
    public void postOrderTrav()
    {
      postOrderTrav( _root );
    }
    public void postOrderTrav( TreeNode currNode )
    {
      if ( currNode == null )
        return;
      postOrderTrav( currNode.getLeft() );
      postOrderTrav( currNode.getRight() );
      System.out.print( currNode.getValue() + " "  );
    }

    public String inOrderTravStr( TreeNode currNode ) {
      String retStr = "";
      if ( currNode == null )
        return retStr;
      retStr += inOrderTravStr( currNode.getLeft() );
      retStr += " " + currNode.getValue();
      retStr += inOrderTravStr( currNode.getRight() );
      return retStr;
    }
    public String preOrderTravStr( TreeNode currNode ) {
      String retStr = "";
      if ( currNode == null )
        return retStr;
      retStr += " " + currNode.getValue();
      retStr += preOrderTravStr( currNode.getLeft() );
      retStr += preOrderTravStr( currNode.getRight() );
      return retStr;
    }
    public String postOrderTravStr( TreeNode currNode ) {
      String retStr = "";
      if ( currNode == null )
        return retStr;
      retStr += postOrderTravStr( currNode.getLeft() );
      retStr += postOrderTravStr( currNode.getRight() );
      retStr += " " + currNode.getValue();
      return retStr;
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //~~~~~~~~~~~~~v~~MISC.HELPERS~~v~~~~~~~~~~~~~~~~~~~
    public boolean isLeaf( TreeNode node )
    {
      return ( node.getLeft() == null
               &&
               node.getRight() == null );
    }
    //~~~~~~~~~~~~~^~~MISC.HELPERS~~^~~~~~~~~~~~~~~~~~~~


    //overridden toString
    public String toString()
    {
      return
        " pre-order trav:" + preOrderTravStr( _root ) + '\n' +
        "  in-order trav:" + inOrderTravStr( _root ) + '\n' +
        "post-order trav:" + postOrderTravStr( _root ) + '\n' +
        "         height: " + height() + '\n' +
        "     num leaves: " + numLeaves()
        ;
    }


    /**
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     */
    TreeNode search( int target )
    {
      return search( target, _root );
    }
    TreeNode search( int target, TreeNode currNode )
    {
      if ( currNode==null || currNode.getValue()==target )
        return currNode;
      else if ( target < currNode.getValue() )
        return search( target, currNode.getLeft() );
      else if ( target > currNode.getValue() )
        return search( target, currNode.getRight() );
      else
        return null; //to get past compiler
    }


    /**
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     */
    public int height()
    {
      return height( _root );
    }
    //recursive helper for height()
    public int height( TreeNode currNode )
    {
      if ( currNode==null ) //Q: Why cannot use .equals() ?
        return 0;
      if ( isLeaf(currNode) )
        return 0;
      else //height is 1 for this node + height of deepest subtree
        return 1 + Math.max( height(currNode.getLeft()),
                             height(currNode.getRight()) );
    }


    /**
     * int numLeaves()
     * returns number of leaves in tree
     */
    public int numLeaves()
    {
      return numLeaves( _root );
    }
    public int numLeaves( TreeNode currNode ) {
      int foo = 0;
      if ( currNode == null )
        return 0;
      foo += numLeaves( currNode.getLeft() );
      if ( isLeaf(currNode) )
        foo++;
      foo += numLeaves( currNode.getRight() );
      return foo;
    }


  //main method for testing
  public static void main( String[] args ) {

  	BST arbol = new BST();

  	System.out.println( "tree init'd: " + arbol );

  	//inserting in this order will build a perfect tree
  	arbol.insert( 3 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	arbol.insert( 2 );
  	arbol.insert( 5 );
  	arbol.insert( 4 );
  	arbol.insert( 6 );
  	/*
  	*/

  	//insering in this order will build a linked list to left
  	/*
  	arbol.insert( 6 );
  	arbol.insert( 5 );
  	arbol.insert( 3 );
  	arbol.insert( 4 );
  	arbol.insert( 2 );
  	arbol.insert( 1 );
  	arbol.insert( 0 );
  	*/

  	System.out.println( "tree after insertions:\n" + arbol );
  	System.out.println();

  	System.out.println();
  	for( int i=-1; i<8; i++ ) {
  	    System.out.println(" searching for "+i+": " + arbol.search(i) );
  	}

  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(6);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(5);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(4);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(3);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(2);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(1);
  	System.out.println();
  	System.out.println( arbol );

  	arbol.remove(0);
  	System.out.println();
  	System.out.println( arbol );
  }

}//end class
