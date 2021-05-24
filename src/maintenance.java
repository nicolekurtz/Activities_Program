// Nicole Kurtz
//
// this is a dervived class from the abstract class, activity
// it is the base to repair, remodel, and build
// it allows you to display, create, and edit a maintenance object

public class maintenance extends activity{
    protected String cost; // cost of maintenance
    protected ArrayList material_list; // list of materials to do maintenance

    // constructor
    public maintenance() {
        this.cost = null;
        material_list = new ArrayList();
    }

    // Constructor with argument
    public maintenance(maintenance tocopy)
    {
        super(tocopy.name, tocopy.description, tocopy.author);
        this.cost = tocopy.cost;
        this.material_list = new ArrayList(tocopy.material_list);
    }

    // constructor with arguments
    public maintenance(String name, String description, String author, String cost, ArrayList material_list)
    {
        super(name, description, author);
        this.cost = cost;
        this.material_list = material_list;
    }

    // display maintenance data members
    public void display()
    {
        super.display();
        System.out.println("Cost: " + cost);
        System.out.println(name + "'s Material List:");
        if(!material_list.display())
            System.out.println("No Materials to Display");
    }

    // edit maintenance object
    public boolean edit() {
        //System.out.println("---" + name + " EDIT---");
        super.edit();
        System.out.println("New cost: ");
        this.cost = input.nextLine();
        if(cost == null)
            return false;
        return true;
    }

    // create maintenance object
    public boolean create()
    {
        //System.out.println("---Create Maintenance Post---");
        super.create();
        System.out.println("Cost: ");
        this.cost = input.nextLine();

        String response;
        String material;

        do {
            System.out.println("Enter Material: ");
            material = input.nextLine();
            this.material_list.add(material);

            System.out.println("Would you like to enter another (y/n): ");
            response = input.nextLine();
            System.out.println();
        }while(!response.equals("n") && (!response.equals("N")));

        if(cost == null)
            return false;
        return true;
    }

    // remove item from array of LLL
    public boolean remove_item()
    {
        String todelete;
        this.material_list.display();
        System.out.println("What Material would like you to remove: ");
        todelete = input.nextLine();

        if(this.material_list.remove_item(todelete)) {
            System.out.println("Material Deleted!");
            return true;
        }
        else
            System.out.println("Material could not be deleted");
        return false;
    }

    // add another material item to array of LLL
    public boolean add_item()
    {
        String material; // user input for material to add
        String response; // response if they want to add more

        // loop until user wants to stop adding materials to list
        do {
            System.out.println("What material would you like to add to the list: ");
            material = input.nextLine();
            if(!material_list.add(material))
                return false;
            System.out.println("Would you like to add another? (y/n)");
            response = input.nextLine();
        }while(response.compareTo("Y")  == 0 || response.compareTo("y") == 0);

        return true;

    }

}