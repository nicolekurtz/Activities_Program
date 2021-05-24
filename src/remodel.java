// Nicole Kurtz

// this is a derived object to the maintenance object
// it allows you to create, edit, adn display a remodel object

public class remodel extends maintenance{
    protected String inspiration; // inspiration for remodeling

    // constructor
    public remodel() {
        this.inspiration = null;
    }

    // copy constructor
    public remodel(remodel tocopy)
    {
        super(tocopy);
        this.inspiration = tocopy.inspiration;
    }

    // constructor with arguments
    public remodel(String name, String description, String author, String cost, ArrayList materials, String inspiration)
    {
        super(name, description, author, cost, materials);

        this.inspiration = inspiration;
    }

    // display remodel data members
    public void display()
    {
        System.out.println("---Remodel Post---");
        super.display();
        System.out.println("Inspiration for Remodel: " + inspiration);
    }

    // edit remodel object
    public boolean edit() {
        System.out.println("---" + name + " EDIT---");

        super.edit(); // call super edit function

        System.out.println("New Inspiration: ");
        this.inspiration = input.nextLine();

        // check that something was added
        if(inspiration == null)
            return false;
        return true;
    }

    // create remodel object
    public boolean create()
    {
        System.out.println("---Create Remodel Post---");
        super.create();
        System.out.println("Remodel Inspiration: ");
        this.inspiration = input.nextLine();

        // check that something was added
        if(inspiration == null)
            return false;
        return true;
    }

}
