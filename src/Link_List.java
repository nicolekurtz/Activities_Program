// Nicole Kurtz

// this class manages a linear linked list
// each node of the LLL points to a string

public class Link_List extends Utility{
    protected node head; // head of list

    // constructor
    public Link_List()
    {
        head = null;
    }

    // copy constructor
    public Link_List(Link_List copy)
    {
       this.head = copy_list(this.head, copy.head);
    }

    // copy list recursive function
    private node copy_list(node head, node tocopy)
    {
       if(tocopy == null)
           return head;

       head = new node();
       head.setdata(tocopy.material);

       head.setnext(copy_list(head.getnext(), tocopy.getnext()));

       return head;
    }

    // add string to linear linked list
    public boolean add(String name)
    {
        // if there's no head then add node to head
        if(head == null)
        {
            head = new node();
            head.setdata(name);
            return true;
        }

        // otherwise, set this new node to head and point to prev head
        else
        {
            node temp = new node();
            temp.setdata(name);
            temp.setnext(head);
            head = temp;
            return true;
        }
    }

    // display linear linked list
    public boolean display()
    {
        if(head == null)
            return false;
        if(display(head))
            return true;
        return false;
    }

    // recursive function to display LLL
    private boolean display(node head)
    {
        if(head == null)
            return false;

        System.out.print("-");
        head.display();

        display(head.getnext());
        return true;
    }

    // checks to find if string exists in LLL
    // if so returns true, else false.
    public boolean find_item(String tofind)
    {
        if(head == null)
            return false;

        return find_item(head, tofind);
    }

    // recursive function to check to see if string exists in LLL
    // if so returns true, else false.
    private boolean find_item(node head, String tofind)
    {
        if(head == null)
            return false;

        // compare passed value to material string
        if(tofind.equals(head.material))
            return true;

        return find_item(head.getnext(), tofind);
    }

    // wrapper function for removing item from LLL
    public boolean remove_item(String toremove)
    {
        this.head = remove_item(this.head, toremove);
        return true;
    }

    // recursive function for removing item in LLL
    public node remove_item(node head, String toremove)
    {
        if(head == null)
            return head;

        // check if materials and argument match, if so,
        // set head to the next node
        if(head.material.equals(toremove))
        {
            head = head.getnext();
            if(head == null)
                return head;
            head.setnext(remove_item(head.getnext(), toremove));
        }

        head.setnext(remove_item(head.getnext(), toremove));
        return head;
    }
}

