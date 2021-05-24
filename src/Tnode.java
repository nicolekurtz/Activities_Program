// Nicole Kurtz
// CS202 Prog 4-5

// This class manages a node that points to an activity
// It is used by the AVL tree

public class Tnode {
    private Tnode left; // left node
    private Tnode right; // right node
    private activity activities; // activities
    public int key;
    public int height = 1; // track height of the tree

    // constructor
    public Tnode() {
        left = null;
        right = null;
        this.height = 1;
    }

    // set material to passed argument
    public Tnode(activity copy) {
        if(copy instanceof cooking)
            activities = new cooking((cooking)copy);
        if(copy instanceof app)
            activities = new app((app)copy);
        if(copy instanceof entree)
            activities = new entree((entree)copy);
        if(copy instanceof dessert)
            activities = new dessert((dessert)copy);
        if(copy instanceof maintenance)
            activities = new maintenance((maintenance) copy);
        if(copy instanceof repair)
            activities = new repair((repair)copy);
        if(copy instanceof remodel)
            activities = new remodel((remodel)copy);
        if(copy instanceof build)
            activities = new build((build)copy);
    }

    // compare activity to argument
    public boolean cmp_activity(String name)
    {
        if(name.compareTo("app") == 0)
        {
            if(activities instanceof app)
                return true;
        }
        if(name.compareTo("entree") == 0)
        {
            if(activities instanceof entree)
                return true;
        }
        if(name.compareTo("dessert") == 0)
        {
            if(activities instanceof dessert)
                return true;
        }
        if(name.compareTo("cooking") == 0)
        {
            if(activities instanceof cooking)
                return true;
        }
        if(name.compareTo("maintenance") == 0)
        {
            if(activities instanceof maintenance)
                return true;
        }
        if(name.compareTo("repair") == 0)
        {
            if(activities instanceof repair)
                return true;
        }
        if(name.compareTo("remodel") == 0)
        {
            if(activities instanceof remodel)
                return true;
        }
        if(name.compareTo("build") == 0)
        {
            if(activities instanceof build)
                return true;
        }
        return false;
    }
    // get left node
    public Tnode getleft() {
        return left;
    }

    // get right node
    public Tnode getright() {
        return right;
    }

    // return height
    public int getHeight()
    {
        return this.height;
    }

    // set height of node
    public void setHeight(int value)
    {
        this.height = value;
    }


    // set right node to connection
    public void setright(Tnode connection)
    {
        right = connection;
    }

    // set left node to connection
    public void setleft(Tnode connection)
    {
        left = connection;
    }

    // display content of node
    public boolean display() {
        if(activities != null) {
            activities.display();
            return true;
        }
        return false;
    }

    // return activity
    public activity returndata()
    {
        return activities;
    }

    // compare activity to argument
    public boolean cmpdata(String cmp)
    {
        if(this.activities.compare(cmp))
            return true;
        return false;
    }

    // call funciton to see if Activity argument is smaller than root
    public boolean is_greater(activity cmp)
    {
        if(this.activities.is_greater(cmp))
            return true;
        return false;
    }

    // call funciton to see if String argument is smaller than root
    public boolean is_greater(String cmp)
    {
        if(this.activities.is_greater(cmp))
            return true;
        return false;
    }

    // call edit function of activity
    public boolean edit()
    {
        if(this.activities.edit())
            return true;
        return false;
    }

    // remove an item from teh LLL assocaited with activity
    public boolean remove_item()
    {
       if(this.activities.remove_item())
           return true;
       return false;
    }

    // add an item to the LLL associated with activity
    public boolean add_item()
    {
        if(this.activities.add_item())
            return true;
        return false;
    }

    // add comment to activity
    public boolean add_comment()
    {
        if(this.activities.add_comment())
            return true;
        return false;
    }

    // display comments of a post
    public boolean display_comments()
    {
        if(this.activities.display_comments())
            return true;
        return false;
    }

}
