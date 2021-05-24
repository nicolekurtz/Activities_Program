// Nicole Kurtz

// this is the derived class to the abstract activity class
// it is the base class to app, main and dessert
// this allows you to add, edit, find, and display a cooking object

public class cooking extends activity {
    protected int calories; // number of calories in meal
    protected String cook_time; // time it takes to make meal
    protected ArrayList ingredient_list; // list of ingredients to make item

    // constructor
    public cooking() {
        this.calories = 0;
        this.cook_time = null;
        ingredient_list = new ArrayList();
    }

    // copy constructor
    public cooking(cooking tocopy)
    {
        super(tocopy);
        this.calories = tocopy.calories;
        this.cook_time = tocopy.cook_time;
        ingredient_list = new ArrayList(tocopy.ingredient_list);
    }

    // constructor with arguments
    public cooking(String name, String description, String author, String cook_time, int calories, ArrayList ingredients)
    {
        super(name, description, author);
        this.calories = calories;
        this.cook_time = cook_time;
        this.ingredient_list = ingredients;
    }

    // output cooking data members
    public void display()
    {
        super.display();
        System.out.println("Calories: " + this.calories);
        System.out.println("Cook Time: " + this.cook_time);
        System.out.println(name + "'s Ingredient List:");
        if(!ingredient_list.display())
            System.out.println("No ingredients added!");
    }

    // add function to create cooking object
    public boolean create()
    {
        // call super equivalent function
        super.create();

        System.out.println("Cook Time: ");
        this.cook_time = input.nextLine();

        System.out.println("Calories: ");
        this.calories = input.nextInt();
        input.nextLine();

        // create array of LLL of materials
        String response;
        String ingredient;
        System.out.println("--INGREDIENT LIST---");
        do {
            System.out.println("Enter Ingredient: ");
            ingredient = input.nextLine();
            this.ingredient_list.add(ingredient);

            System.out.println("Would you like to enter another (y/n): ");
            response = input.nextLine();
            System.out.println();
        }while(!response.equals("n") && (!response.equals("N")));

        // check to make sure information was put into Strings
        if (this.name == null || this.description == null || this.author == null || this.cook_time == null)
            return false;
        return true;
    }

    // edit the information of a cooking object
    public boolean edit()
    {
        // call superclass equivalent function
        super.edit();

        // user input
        System.out.println("Enter the new calorie amount: ");
        this.calories = input.nextInt();
        input.nextLine();

        //user input
        System.out.println("Enter the new cooking time: ");
        this.cook_time = input.nextLine();

        if(cook_time == null)
            return false;
        return true;
    }

    // remove item from array of LLL
    public boolean remove_item()
    {
        String todelete;
        this.ingredient_list.display();
        System.out.println("What Ingredient would like you to remove: ");
        todelete = input.nextLine();

        if(this.ingredient_list.remove_item(todelete)) {
            System.out.println("Ingredient Deleted!");
            return true;
        }
        else
            System.out.println("Ingredient could not be deleted");
        return false;
    }

    // add another ingredient item to array of LLL
    public boolean add_item()
    {
        String material; // user input for material to add
        String response; // response if they want to add more

        do {
            System.out.println("What ingredient would you like to add to the list: ");
            material = input.nextLine();
            if(!ingredient_list.add(material))
                return false;
            System.out.println("Would you like to add another? (y/n)");
            response = input.nextLine();
        }while(response.compareTo("Y")  == 0 || response.compareTo("y") == 0);
        return true;

    }

}
