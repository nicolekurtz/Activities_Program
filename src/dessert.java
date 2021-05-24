// Nicole Kurtz

// this is a derived class from the cooking class
// these functiosn allow you to create, display, and edit
// a dessert object

public class dessert extends cooking {
    protected int sweetness; // rate how sweet the dessert is

    // constructor
    public dessert()
    {
        this.sweetness = 0;
    }

    // copy constructor
    public dessert(dessert tocopy)
    {
        super(tocopy);
        this.sweetness = tocopy.sweetness;
    }

    // constructor with arguments
    public dessert(String name, String description, String author, String cook_time, int calories, ArrayList ingredients, int sweetness)
    {
        super(name, description, author, cook_time, calories, ingredients);

        this.sweetness = sweetness;
    }

    // output data member info
    public void display()
    {
        System.out.println();
        System.out.println("---Dessert Information---");
        super.display();
        System.out.println("Sweetness Level (1-10): " + this.sweetness);
    }

    // edit appetizer information
    public boolean edit()
    {
        System.out.println();
        System.out.println("---" + name + " Edit---");

        // call super's edit function
        super.edit();

        System.out.println("New Sweetness Level (1-10: ");
        this.sweetness = input.nextInt();
        input.nextLine();

        return true;
    }

    // create appetizer object
    public boolean create()
    {
        System.out.println("---Create Dessert Post---");
        super.create();
        System.out.println("Sweetness Level (1-10): ");
        this.sweetness = input.nextInt();
        input.nextLine();

        return true;
    }
}
