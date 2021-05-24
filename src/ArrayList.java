// Nicole Kurtz
//
// this is an array of linear linked list
// I will be using a hash function to determine the location of my items

public class ArrayList extends Utility{

    protected Link_List hashtable[]; // array of linear linked lists
    protected int SIZE = 21; // the size of the hashtable

    public ArrayList() {
        hashtable = new Link_List[SIZE];
    }

    // constructor with arguments (copy constructor)
    public ArrayList(ArrayList tocopy)
    {
        int i = 0;
        hashtable = new Link_List[SIZE];
        copy_array(i, tocopy.hashtable);
    }

    // copy content of passed array to current array
    private void copy_array(int i, Link_List [] tocopy)
    {
        if(i == SIZE)
            return;

        if(tocopy[i] != null)
            hashtable[i] = new Link_List(tocopy[i]);

        copy_array(++i, tocopy);
    }

    // generates hash value so it knows where to add
    // the string in the table
    public int hash_function(String name)
    {
        int value = 0; // use to calculate hash function value
        char [] tohash = name.toCharArray();
        for(int i = 0; i < name.length(); ++i )
            value += tohash[i];

        value = value * 131 + value;

        return value % SIZE;
    }

    // add string to array
    public boolean add(String name)
    {
        int hash_value = hash_function(name);
        if(hashtable[hash_value] == null)
            hashtable[hash_value] = new Link_List();
        if(this.hashtable[hash_value].add(name))
            return true;
        return false;
    }

    // display all contents of hashtable
    public boolean display()
    {
        int counter = 0;
        boolean check = false;
        return display(counter, check);
    }

    // recursive call to display contents of hashtable
    private boolean display(int counter, boolean check)
    {
        if(counter == SIZE)
        {
            if(check == true)
                return true;
            else
                return false;
        }

        // check that anything exists in list
        if(hashtable[counter] != null) {
            //System.out.println("Index: " + counter);
            if(hashtable[counter].display())
                check = true;
        }
        return display(++counter, check);
    }

    // calls neccessary functions to delete an item in the approparite
    // LLL of the hashtable is it exists
    public boolean remove_item(String toremove)
    {
        int index =  0;
        index = find_item(toremove, index);

        if(index == SIZE)
            return false;

        if(hashtable[index].remove_item(toremove))
            return true;
        return false;
    }

    // find matching item in hashtable
    public int find_item(String tofind, int index)
    {
        index = hash_function(tofind);
        if(hashtable[index] != null)
            if(hashtable[index].find_item(tofind))
                return index;

            return SIZE;
    }

}
