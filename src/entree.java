// Nicole Kurtz

// this is a derived class to the cooking class
// it allows you to create, edit, display an entree object

public class entree extends cooking{
    protected String cuisine; // label cusine type

    // constructor
    public entree()
    {
        this.cuisine = null;
    }

    // copy constructor
    public entree(entree tocopy)
    {
        super(tocopy);
        this.cuisine = tocopy.cuisine;
    }

    // constructor with arguments
    public entree(String name, String description, String author, String cook_time, int calories, ArrayList ingredients,  String cuisine)
    {
        super(name, description, author, cook_time, calories, ingredients);

        this.cuisine = cuisine;
    }

    // output data member info
    public void display()
    {
        System.out.println();
        System.out.println("---Entree Information---");
        super.display();
        System.out.println("Cuisine: " + this.cuisine);
    }

    // edit entree information
    public boolean edit()
    {
        System.out.println();
        System.out.println("---" + name + " Edit---");

        // call super's edit function
        super.edit();

        System.out.println("New Cuisine: ");
        this.cuisine = input.nextLine();

        if(cuisine == null)
            return false;
        return true;
    }

    // create entree object
    public boolean create()
    {
        System.out.println("---Create Entree Post---");
        super.create();
        System.out.println("Type of Cuisine: ");
        cuisine = input.nextLine();

        if(cuisine == null)
            return false;
        return true;
    }
}
