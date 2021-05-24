// Nicole Kurtz

// this is a dervived class from the maintenance class
// it allows you to display, create, and edit a build object

public class build extends maintenance{

    protected String skill; // amount of time it took to build item

    // constructor
    public build()
    {
        this.skill = null;
    }

    // constructor with arguments - copy constructor
    public build(build tocopy)
    {
        super(tocopy);
        this.skill = tocopy.skill;
    }

    // constructor with arguments
    public build(String name, String description, String author, String cost, ArrayList materials, String skill)
    {
        super(name, description, author, cost, materials);
        this.skill = skill;

    }

    // display build data members
    public void display()
    {
        System.out.println("---Display Build Post---");
        super.display();
        System.out.println("Technical skills needed: " + this.skill);
    }

    // edit build object
    public boolean edit() {
        System.out.println("---" + name + " EDIT---");
        super.edit();
        System.out.println("New technical skills needed for project: ");
        this.skill = input.nextLine();
        return true;
    }

    // create build object
    public boolean create()
    {
        System.out.println("---Create Build Post---");
        super.create();
        System.out.println("Technical skills needed for project: ");
        this.skill = input.nextLine();

        return true;
    }

}
