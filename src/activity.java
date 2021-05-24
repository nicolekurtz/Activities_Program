// Nicole Kurtz

// this is my abstract class which holds the cooking and maintenance classes
// an object will never be derived, this simply is the glue to the base classes

abstract public class activity extends Utility {
    protected String name; // name of activity
    protected String description; // description of activity
    protected String author; // author of activity
    protected Link_List comments = new Link_List(); // linked list of comments

    // constructor
    public activity()
    {
        name = null;
        description = null;
        author = null;
        comments = new Link_List();
    }

    // copy constructor
    public activity(final activity to_copy)
    {
        this.name = to_copy.name;
        this.description = to_copy.description;
        this.author = to_copy.author;
        comments = new Link_List(to_copy.comments);
    }

    // constructor with arguments
    public activity(String name, String description, String author)
    {
        this.name = name;
        this.description = description;
        this.author = author;
    }

    // change the name of an activity
    public void change_name(String name)
    {
        this.name = name;
    }

    // change the description
    public void change_description(String description)
    {
        this.description = description;
    }

    // output activity members
    public void display()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Description: " + this.description);
        System.out.println("Author: " + this.author);
    }

    // compare argument to name of activity
    public boolean find(String name_cmp)
    {
       return this.name.compareToIgnoreCase(name_cmp) == 0;
    }

    // create activities object
    public boolean create()
    {
        System.out.println("Name: ");
        this.name = input.nextLine();

        System.out.println("Description: ");
        this.description = input.nextLine();

        System.out.println("Author: ");
        this.author = input.nextLine();

        if(this.name == null || this.description == null || this.author == null)
            return false;
        return true;
    }

    // compare passed string to activities name
    public boolean compare(String name)
    {
        if(this.name.compareTo(name) == 0)
            return true;
        return false;
    }

    // edit information
    public boolean edit()
    {
        System.out.println("Enter the new description: ");
        this.description = input.nextLine();

        if(name == null || description == null)
            return false;
        return true;
    }

    // remove item -- ABSTRACT FUNCTION
    public abstract boolean remove_item();

    // add item to array of LLL -- ABSTRACT FUNCTION
    public abstract boolean add_item();

    // compare if root data is greater than activity name
    public boolean is_greater(activity cmp)
    {
        if(cmp.name.compareTo(name) < 0)
            return true;
        return false;
    }

    // check to see if root name is greater than string
    public boolean is_greater(String cmp)
    {
        if(cmp.compareTo(name) < 0)
            return true;
        return false;
    }

    // add comment/idea to post
    public boolean add_comment()
    {
        System.out.println("Enter your comment about this activity: ");
        String comment = input.nextLine();
        if(comments.add(comment))
            return true;
        return false;
    }

    // display all comments associated with post
    public boolean display_comments()
    {
        System.out.println(name + "'s Comments:");
        if(comments.display())
            return true;
        return false;
    }


}
