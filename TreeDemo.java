class Node{
    int value;
    Node left, right;

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }

}

class BinarySearchTree{

    Node root;


    /*
      inserts a node into the tree
      */
    public void insert(int value){
        //tree is empty
        if(root == null){
            root = new Node(value);
            return;
        }else{
            Node current = root;
            Node parent = null;

            while(true){
                parent = current;

                if(value < current.value){
                    current = current.left;
                    if(current == null){
                        parent.left = new Node(value);
                        return;
                    }
                }else{
                    current = current.right;
                    if(current == null){
                        parent.right = new Node(value);
                        return;
                    }
                }

            }//closing while

        }//closing main if-else
    }



    /**
     * preOrder traversal of a tree
     * @param root the root node of the tree
     */
    public void preOrderTraversal(Node root){
        if (root == null)
            return;

        // print the node
        System.out.print(root.value + "->");
        // traverse the left child
        preOrderTraversal(root.left);
        // traverse the right child
        preOrderTraversal(root.right);
    }



    /**
     * inOrder traversal of a tree
     * @param root the root node of the tree
     */
    public void inOrderTraversal(Node root){
        if (root == null)
            return;

        // traverse the left child
        inOrderTraversal(root.left);
        // print the node
        System.out.print(root.value + "->");
        // traverse the right child
        inOrderTraversal(root.right);
    }



    /**
     * postOrder traversal of a tree
     * @param root the root node of the tree
     */
    public void postOrderTraversal(Node root){
        if (root == null)
            return;

        // traverse the left child
        postOrderTraversal(root.left);
        // traverse the right child
        postOrderTraversal(root.right);
        // print the node
        System.out.print(root.value + "->");
    }



    /**
     * checks if the key value is in the tree
     * @param root the root node of the tree
     * @param key the key to serach for
     * @return boolean
     */
    public boolean find(Node root, int key){
        if (root == null) {
            return false;
        } else if (root.value == key) {
            return true;
        } else if (root.value > key) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }



    /**
     * returns the minimum value in a tree
     * @param root the root node of the tree
     * @return int
     */
    public int getMin(Node root){
        if (root.left == null){
            return root.value;
        }
        else{
            return getMin(root.left);
        }
    }



    /**
     * returns the maximum value in a tree
     * @param root the root node of the tree
     * @return int
     */
    public int getMax(Node root){
        if (root.right== null){
            return root.value;
        }
        else{
            return getMax(root.right);
        }
    }



    /*
    this method will not compile until getMax
    is implemented
    */
    public Node delete(Node root, int key){

        if(root == null){
            return root;
        }else if(key < root.value){
            root.left = delete(root.left, key);
        }else if(key > root.value){
            root.right = delete(root.right, key);
        }else{
            //node has been found
            if(root.left==null && root.right==null){
                //case #1: leaf node
                root = null;
            }else if(root.right == null){
                //case #2 : only left child
                root = root.left;
            }else if(root.left == null){
                //case #2 : only right child
                root = root.right;
            }else{
                //case #3 : 2 children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }
        return root;
    }



}



public class TreeDemo{
    public static void main(String[] args){
        BinarySearchTree t1  = new BinarySearchTree();
        t1.insert(24);
        t1.insert(80);
        t1.insert(18);
        t1.insert(9);
        t1.insert(90);
        t1.insert(22);

        System.out.print("in-order :   ");
        t1.inOrderTraversal(t1.root);
        System.out.println();


    }
}