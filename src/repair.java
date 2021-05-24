// Nicole Kurtz

// this is a derived class to maintenance
// it is a repair object that allows
// creating, editing, and displaying

public class repair extends maintenance{
    protected String time; // time it takes for repair

    // constructor
    public repair() {
        this.time = null;
    }

    // copy constructor
    public repair(repair tocopy)
    {
        super(tocopy);
        this.time = tocopy.time;
    }
    // constructor with arguments
    public repair(String name, String description, String author, String cost, ArrayList materials, String time)
    {
        super(name, description, author, cost, materials);
        this.time = time;
    }

    // display repair data members
    public void display()
    {
        System.out.println("---Repair Post---");
        super.display();
        System.out.println("Time to make Repair: " + time);
    }

    // edit repair object
    public boolean edit() {
        System.out.println("---" + name + " EDIT---");
        super.edit();
        System.out.println("New Repair Time: ");
        this.time = input.nextLine();
        if(time == null)
            return false;
        return true;
    }

    // create repair object
    public boolean create()
    {
        System.out.println("---Create Repair Post---");
        super.create();
        System.out.println("Repair Time: ");
        this.time = input.nextLine();

        if(time == null)
            return false;
        return true;
    }

}
