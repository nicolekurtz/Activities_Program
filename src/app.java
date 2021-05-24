// Nicole Kurtz

// this is a derived class of the cooking class and the activities abstract class
// this is for creating an appetizer object.
// You are able to create, display and edit the object through the methods

public class app extends cooking{
    protected String temp; // hot or cold appetizer

    // constructor
    public app()
    {
        this.temp = null;
    }

    // copy constructor
    public app(app tocopy)
    {
        super(tocopy);
        temp = tocopy.temp;
    }

    // constructor with arguments
    public app(String name, String description, String author, String cook_time, int calories, ArrayList ingredients, String temp)
    {
        super(name, description, author, cook_time, calories, ingredients);

        this.temp = temp;
    }

    // output data member info
    public void display()
    {
        System.out.println();
        System.out.println("---Appetizer Information---");
        super.display();
        System.out.println("Temperature: " + temp);
    }

    // edit appetizer information
    public boolean edit()
    {
        System.out.println();
        System.out.println("---" + name + " Edit---");

        // call super's edit function
        super.edit();

        System.out.println("New temperature: ");
        this.temp = input.nextLine();

        if(temp == null)
            return false;
        return true;
    }

    // create appetizer object
    public boolean create()
    {
        System.out.println("---Create Appetizer Post---");
        super.create();
        System.out.println("Temperature of App (hot/cold): ");
        temp = input.nextLine();

        if(temp == null)
            return false;
        return true;
    }


}
