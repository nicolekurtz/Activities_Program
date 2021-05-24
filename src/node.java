// Nicole Kurtz

// this node is used by the list class.
// It points to a string object
// this allows the list to get the next, set the next, display, etc

public class node {
        protected node next; // next pointer
        String material; // matierials to make build

        // constructor
        public node() {
            next = null;
            material = null;
        }

        // copy constructor
        public node(node tocopy)
        {
            this.material = tocopy.material;
        }

        // set material to passed argument
        public void setdata(String data_copy)
        {
            material = data_copy;
        }

        // get next node
        public node getnext() {
            return next;
        }

        // set next node to connection
        public void setnext(node connection)
        {
            next = connection;
        }

        // display content of node
        public boolean display() {
            if(material != null) {
                System.out.println(material);
                return true;
            }
            return false;
        }

        // return material
        public String returndata()
        {
            return material;
        }

        // compare material to argument
        public boolean cmpdata(String cmp)
        {
            return material == cmp;
        }
}
