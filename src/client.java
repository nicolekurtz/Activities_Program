// Nicole Kurtz

// this class is used to test my application
// please note that for program #4 I had to hard wire in some
// functionality so that you can test all of the functions (i.e edit)

public class client extends Utility {

    private Tree all_activities;

    public client(){
        all_activities = new Tree();
    }

    // menu for client
    public void menu() {
        int response = 0;

        do {
            System.out.println("---MENU---");
            System.out.println("1 -- Create Post");
            System.out.println("2 -- Display all Posts");
            System.out.println("3 -- Delete All Posts");
            System.out.println("4 -- Edit/Comment/Display a Post");
            System.out.println("5 -- Display All Post of an Activity Type");
            System.out.println("6 -- End Program");
            System.out.println("----------");

            System.out.println("Enter Menu Choice: ");
            response = input.nextInt();
            input.nextLine();

            switch (response) {
                case 1:
                    create_post();
                    break;

                case 2:
                    if(!all_activities.display())
                        System.out.println("No Posts to display");
                    break;

                case 3:
                    if(all_activities.remove_all())
                        System.out.println("All Posts Removed");
                    break;

                case 4:
                    if(!find_post())
                        System.out.println("Post could not be found.");
                    break;

                case 5:
                    if(!find_activity())
                        System.out.println("No posts match that type");
                    break;

                case 6:
                    System.out.println("Thanks for using the Activities Post Program!");
                    break;

            }
        } while (response != 6);

    }

    // display all activities of a user selected type
    private boolean find_activity()
    {
        int response = 9;
        System.out.println("---SELECT ACTIVITY TYPE TO DISPLAY---");
        System.out.println("1 -- Display All Cooking Posts");
        System.out.println("2 -- Display All Appetizer Posts");
        System.out.println("3 -- Display All Main Course Posts");
        System.out.println("4 -- Display All Dessert Posts");
        System.out.println();
        System.out.println("5 -- Display All Maintenance Posts");
        System.out.println("6 -- Display All Repair Posts");
        System.out.println("7 -- Display All Remodel Posts");
        System.out.println("8 -- Display All Build Posts");
        System.out.println("-----------------------------");

        System.out.println("Menu Choice: ");
        response = input.nextInt();
        input.nextLine();

        switch (response) {
            case 1:
                if(this.all_activities.display_activity("cooking"))
                    return true;
                break;

            case 2:
                if(this.all_activities.display_activity("app"))
                    return true;
                break;

            case 3:
                if(this.all_activities.display_activity("entree"))
                    return true;
                break;

            case 4:
                if(this.all_activities.display_activity("dessert"))
                    return true;
                break;

            case 5:
                if(this.all_activities.display_activity("maintenance"))
                    return true;
                break;

            case 6:
                if(this.all_activities.display_activity("repair"))
                    return true;
                break;

            case 7:
                if(this.all_activities.display_activity("remodel"))
                    return true;
                break;

            case 8:
                if(this.all_activities.display_activity("build"))
                    return true;
                break;

        }
        return false;
    }

    // find post in tree
    public boolean find_post()
    {
        String response;

        System.out.println("What is the name of the post: ");
        response = input.nextLine();
        System.out.println();

        // check to see if activity is in list
        if(!all_activities.find(response))
            return false;

        // ptr to found node
        Tnode ptr = all_activities.retrieve(response);

        // access side submenu
        to_edit_activity(ptr);

        return true;
    }

    // allows for user to create any type of post
    // it then acesses the submenu for that object for testing
    public void create_post() {
        int response = 9;
        System.out.println("---CREATE ACTIVITIES POST---");
        System.out.println("1 -- Create a Cooking Object");
        System.out.println("2 -- Create an Appetizer Object");
        System.out.println("3 -- Create a Main Course Object");
        System.out.println("4 -- Create a Dessert Object");
        System.out.println();
        System.out.println("5 -- Create a Maintenance Object");
        System.out.println("6 -- Create a Repair Object");
        System.out.println("7 -- Create a Remodel Object");
        System.out.println("8 -- Create a Build Object");
        System.out.println("-----------------------------");

        System.out.println("Menu Choice: ");
        response = input.nextInt();
        input.nextLine();

        activity ptr;

        switch (response) {
            case 1:
                ptr = new cooking();
                ptr.create();
                ptr.display();
                this.all_activities.insert(ptr);
                break;

            case 2:
                ptr = new app();
                ptr.create();
                ptr.display();
                this.all_activities.insert(ptr);
                break;

            case 3:
                ptr = new entree();
                ptr.create();
                ptr.display();
                this.all_activities.insert(ptr);
                break;

            case 4:
                ptr = new dessert();
                ptr.create();
                ptr.display();
                this.all_activities.insert(ptr);
                break;

            case 5:
                ptr = new maintenance();
                ptr.create();
                ptr.display();
                this.all_activities.insert(ptr);
                break;

            case 6:
                ptr = new repair();
                ptr.create();
                ptr.display();
                this.all_activities.insert(ptr);
                break;

            case 7:
                ptr = new remodel();
                ptr.create();
                ptr.display();
                this.all_activities.insert(ptr);
                break;

            case 8:
                ptr = new build();
                ptr.create();
                ptr.display();
                this.all_activities.insert(ptr);
                break;

        }


    }

    // function to test functionality of hierarchy of maintenance
    // menu wording is customized for maintenance object is only difference
    // for submission of program 4 use only
    public void to_edit_activity(Tnode toedit) {
        int response;

        do{
            System.out.println();
            System.out.println("--SUBMENU--");
            System.out.println("1 - Edit Activity");
            System.out.println("2 - Delete a Material/Ingredient");
            System.out.println("3 - Display Post");
            System.out.println("4 - Add Item to Material/Ingredient list");
            System.out.println("5 - Add a Comment");
            System.out.println("6 - Display Comments");
            System.out.println("7 - Exit to Main Menu");
            System.out.println("--------");
            System.out.println();
            System.out.println("Enter your menu choice:");
            response = input.nextInt();
            input.nextLine();

            switch(response) {
                case 1:
                    toedit.edit(); // edit hierarchy object
                    break;

                case 2:
                    toedit.remove_item(); // remove item from array of LLL
                    break;

                case 3:
                    toedit.display(); // display object
                    break;

                case 4:
                    toedit.add_item();
                    break;

                case 5:
                    toedit.add_comment();
                    break;

                case 6:
                    if(!toedit.display_comments())
                        System.out.println("No Comments to Display");



            }
        }while(response != 7);
    }

}
