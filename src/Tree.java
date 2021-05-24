// Nicole Kurtz
// CS202 Prog 4-5

// This is my AVL tree class
// It holds Tnodes which point to activities.
// This is a self balancing tree

public class Tree extends Utility{
    private Tnode root;
/*
    // gets and adds 1 to height of argument
    public int updateHeight(Tnode node)
    {
        /*
        int left_height = 0;
        int right_height = 0;

        if(node.getleft() != null)
            left_height = node.getleft().getHeight();
        if(node.getright() != null) {

            right_height = node.getright().getHeight();
        }

        // add one to the largest height
        return 1 + Math.max(left_height, right_height);
        */
        /*
        node.setHeight(1+Math.max(height(node.getleft()), height(node.getright())));
        return node.getHeight();
        return 1+ Math.max(height(node.getleft()), height(node.getright()));
    }

         */
    // get the height of a node
    public int height(Tnode node)
    {
        if(node == null) return 0;

        else
            return node.getHeight();
    }

    // get the balance value
    public int getBalance(Tnode node)
    {
        if(node == null) return 0;

        else
            return (height(node.getleft()) - height(node.getright()));
    }

    // rotate the AVL tree right
    public Tnode rotateRight(Tnode node)
    {
        // right rotate subtree
       Tnode new_root = node.getleft();
       Tnode new_left = node.getright();

       // perform rotation
       new_root.setright(node);
       node.setleft(new_left);

       // update heights
       node.setHeight(Math.max(height(node.getleft()), height(node.getright())) +1 );
       new_root.setHeight(Math.max(height(new_root.getleft()), height(new_root.getright())) +1 );

       // return new root
       return new_root;
    }

    // rotate the AVL tree left
    public Tnode rotateLeft(Tnode node)
    {
        // rotate left subtree
        Tnode new_root = node.getright();
        Tnode new_right = node.getleft();

        // perform rotation
        new_root.setleft(node);
        node.setright(new_right);

        // update heights
        node.setHeight(Math.max(height(node.getleft()), height(node.getright())) +1 );
        new_root.setHeight(Math.max(height(new_root.getleft()), height(new_root.getright())) + 1 );

        // return new root
        return new_root;
    }
/*
    private Tnode rebalance(Tnode node)
    {
        node.setHeight(updateHeight(node));
        int balance = getBalance(node);
        if(balance > 1 && ) {
            Tnode temp = (Tnode)node.getleft();
            if (height(node.getright().getright()) > height(node.getright().getleft())) {
                node = rotateLeft(node);
            } else {
                Tnode temp = node.getright();
                temp = rotateRight(node.getright());
                node = rotateLeft(node);
            }
        }
        else if(balance < -1)
        {
            if(height(node.getleft().getleft()) > height(node.getleft().getright()))
                node = rotateRight(node);
            else
            {
                Tnode temp = node.getright();
                temp = rotateLeft(node.getleft());
                node = rotateRight(node);
            }
        }

        return node;
    }
*/

    // wrapper function at add and balance tree
    public void insert(activity add)
    {
        this.root = insert(this.root, add);
    }

    // recursive function to add a new activity to the tree
    // balance the tree as needed
    private Tnode insert(Tnode node, activity add)
    {
        // empty tree
        if(node == null)
        {
            node = new Tnode(add);
            return node;
        }

        // the current node has a name that is greater than the argument
        // go left
        if(node.is_greater(add))
        {
            node.setleft(insert(node.getleft(), add));
        }

        // otherwise, go right.
        // argument is equal or greater than node
        else
        {
            node.setright(insert(node.getright(), add));
        }

        // update height of the ancestor node
        node.setHeight(1 + Math.max(height(node.getleft()), height(node.getright())));

        // get the balance factor of ancestor node to check if this node is unbalanced
        int balance = getBalance(node);

        // left left case
        if(balance > 1 && node.getleft().is_greater(add)) {
            return rotateRight(node);
        }

        // right right case
        if(balance < -1 && !node.getright().is_greater(add))
            return rotateLeft(node);

        // left right case
        if(balance > 1 && !node.getleft().is_greater(add))
        {
            node.setleft(rotateLeft(node.getleft()));
            return rotateRight(node);
        }

        // right left case
        if(balance < -1 && node.getright().is_greater(add))
        {
            node.setright(rotateRight(node.getright()));
            return rotateLeft(node);
        }

        // return the node pointer
        return node;
    }

    // display contents of AVL tree
    public boolean display()
    {
        // empty list
        if(this.root == null) return false;
        int counter = 0;
        return display(this.root, counter);
    }

    //recursive display of AVL tree
    public boolean display(Tnode root, int counter)
    {
        if(root == null) return true;
        ++ counter;

        //System.out.println("This is the actual height: " + counter);
        display(root.getleft(), counter);
        root.display();
        System.out.println();

        display(root.getright(), counter);
        return true;
    }

    // wrapper function for delete all
    public boolean remove_all()
    {
        if(root == null) return false;

        this.root = null;

        return true;
    }

    // find post in tree
    public boolean find(String tofind)
    {
        if(root == null) return false;

        int result = find(root, tofind);
        if(result > 0)
            return true;
        return false;
    }

    // recursively find post in tree
    private int find(Tnode root, String tofind)
    {
        if(root == null) return 0;

        int result = find(root.getleft(), tofind);

        // if data matches, add one to result
        if(root.cmpdata(tofind))
        {
            ++result;
        }

        return result += find(root.getright(), tofind);

    }

    // return node to calling routine
    // if name matches
    public Tnode retrieve(String tofind)
    {
        Tnode found = null;
        return retrieve(this.root, tofind, found);
    }

    // recursive retrieve node to calling routine
    // if name matches
    private Tnode retrieve(Tnode root, String tofind, Tnode found)
    {
        Tnode found2 = null;

        if(root == null)
            return null;

        if(root.cmpdata(tofind))
            found2 = root;

        if(found2 == null) {
            if(root.is_greater(tofind))
                found2 = retrieve(root.getleft(), tofind, found);
            else
                found2 = retrieve(root.getright(), tofind, found);
        }

        // compare root data to argument

        return found2;
    }

    // display all nodes that match activity
    public boolean display_activity(String activity)
    {
       if(root == null) return false;

       int result = display_activity(root, activity);

       // if any items were displayed then return true
       if(result > 0)
           return true;
       // otherwise, there was no activity to display
       return false;
    }

    // recursive function to display all nodes that match activity
    public int display_activity(Tnode root, String activity)
    {
        if(root == null) return 0;

        int result = display_activity(root.getleft(), activity);

        // if root is of the activity passed as argument, display
        if(root.cmp_activity(activity))
        {
            root.display();
            ++result;
        }
        return result += display_activity(root.getright(), activity);
    }

}
