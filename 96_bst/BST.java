/*
AKH+D :: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW 96 - BSTs is the Perfect Place for Shade
2022-05-10
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
    if (_root == null) { _root = newNode; }
    else { insert(_root, newNode); }
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      if (stRoot.getLeft() == null) { stRoot.setLeft(newNode); }
      else {
        TreeNode left = stRoot.getLeft();
        insert(left, newNode);
      }
    }
    else {
      if (stRoot.getRight() == null) { stRoot.setRight(newNode); }
      else {
        TreeNode right = stRoot.getRight();
        insert(right, newNode);
      }
    }
  }//end insert()




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
    System.out.println(currNode.getValue());
    if (currNode.getLeft() != null) {
      preOrderTrav(currNode.getLeft());
    }
    if(currNode.getRight() != null) {
      preOrderTrav(currNode.getRight());
    }
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if (currNode.getLeft() != null) {
      inOrderTrav(currNode.getLeft());
    }
    System.out.println(currNode.getValue());
    if(currNode.getRight() != null) {
      inOrderTrav(currNode.getRight());
    }
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if (currNode.getLeft() != null) {
      postOrderTrav(currNode.getLeft());
    }
    if(currNode.getRight() != null) {
      postOrderTrav(currNode.getRight());
    }
    System.out.println(currNode.getValue());
  }


      /*****************************************************
       * TreeNode search(int)
       * returns pointer to node containing target,
       * or null if target not found
       *****************************************************/
      public TreeNode search( int target )
      {
        return search(target, _root);
      }
      public TreeNode search(int target, TreeNode stRoot){
        if (stRoot.getValue() == target){
          return stRoot;
        }
        else if (target < stRoot.getValue()){
          if (stRoot.getLeft() == null) {return null;} //return null if the node is not there
          return search(target, stRoot.getLeft());
        }
        else{
          if (stRoot.getRight() == null) {return null;}
          return search(target, stRoot.getRight());
        }
      }


      /*****************************************************
       * int height()
       * returns height of this tree (length of longest leaf-to-root path)
       * eg: a 1-node tree has height 1
       *****************************************************/
      public int height()
      {
      	return height(_root);
      }
      public int height(TreeNode stRoot) {
        if (stRoot.getLeft() == null && stRoot.getRight() == null){
          return 1;
        }
        if (stRoot.getRight() == null){
          return height(stRoot.getLeft()) + 1;
        }
        if (stRoot.getLeft() == null){
          return height(stRoot.getRight()) + 1;
        }
        int n = height(stRoot.getLeft());
        int m = height(stRoot.getRight());
        if (n > m) {return n;}
        else{
          return m;
        }
      }

      /*****************************************************
       * int numLeaves()
       * returns number of leaves in tree
       *****************************************************/
      public int numLeaves()
      {
      	return numLeaves(_root);
      }
      public int numLeaves(TreeNode stRoot){
        if (stRoot.getLeft() == null && stRoot.getRight() == null){
          return 1;
        }
        if (stRoot.getRight() != null && stRoot.getLeft() != null){
          return numLeaves(stRoot.getRight()) + numLeaves(stRoot.getLeft());
        }
        else if (stRoot.getRight() != null){
          return numLeaves(stRoot.getRight());
        }
        else {
          return numLeaves(stRoot.getLeft());
        }
      }



  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  //main method for testing
  public static void main( String[] args )
  {

      BST arbol = new BST();

      //PROTIP: sketch state of tree after each insertion
      //        ...BEFORE executing these.
      arbol.insert( 4 );
      arbol.insert( 2 );
      arbol.insert( 5 );
      arbol.insert( 6 );
      arbol.insert( 1 );
      arbol.insert( 3 );
      /*
          4
         / \
        2   5
       / \   \
      1   3   6
      */
          /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      System.out.println( "\n-----------------------------");
      System.out.println( "pre-order traversal:" );
      arbol.preOrderTrav();
      System.out.println("expecting: 421356");

      System.out.println( "\n-----------------------------");
      System.out.println( "in-order traversal:" );
      arbol.inOrderTrav();
      System.out.println("expecting: 123456");

      System.out.println( "\n-----------------------------");
      System.out.println( "post-order traversal:" );
      arbol.postOrderTrav();
      System.out.println("expecting: 132654");

      System.out.println( "\n-----------------------------");

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

      System.out.println(arbol.numLeaves());
      System.out.println("...expecting 3");
      System.out.println(arbol.height());
      System.out.println("...expecting 2");
      System.out.println(arbol.search(6).getValue());
      System.out.println("...expecting 6");

      BST x = new BST();
      x.insert( 16 );
      x.insert( 8 );
      x.insert( 20 );
      x.insert( 24 );
      x.insert( 4 );
      x.insert( 12 );
      x.insert( 25 );
      x.insert( 1 );
      System.out.println(x.numLeaves());
      System.out.println("...expecting 3");
      System.out.println(x.height());
      System.out.println("...expecting 3");
      System.out.println(x.search(12).getValue());
      System.out.println("...expecting 12");
  }

}//end class
