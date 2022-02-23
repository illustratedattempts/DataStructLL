public class LinkedList<AnyType extends IDedObject>
{

    class Node
    {
        private Node nextNode;
        private AnyType storedObj;
        public Node(AnyType obj)
        {
            storedObj = obj;
            nextNode = null;
        }
        public Node(AnyType obj, Node next)
        {
            storedObj = obj;
            nextNode = next;
        }
        public void assignNext(Node z)
        {
            nextNode = z;
        }
        public Node getNext()
        {
            return nextNode;
        }
        public AnyType getStored()
        {
            return storedObj;
        }

    } // End of Node Class


    private Node header;

    public LinkedList() // Empty List
    {
        header = null;
        //tail = null;
    }
    public void makeEmpty() // Empties out the Linked List
    {
        header = null;
    }

    AnyType findID(int ID) // Finds the AnyType's ID and then returns it. Returns NULL if empty or ID if not found
    {
        //First check if List is not NULL
        if (header != null)
        {
            // Comb through Linked List. Start: Header, End: Next Element is NULL
            Node parsed = header;
            int parsedID = parsed.getStored().getID();

            while (parsedID != ID) // Make sure that ID does not match
            {
                if( (parsed.getNext()) != null)
                {
                    parsed = parsed.getNext();
                    parsedID =  parsed.getStored().getID(); // New Parsing ID
                }
                else
                {
                    break;
                }
            }
            if(parsedID == ID) // The while breaks for two reasons: Next Node reference is NULL (END OF LINKED LISTED) OR the ID is equal. Here we check for the case in which it is equal.
            {
                return parsed.getStored();
            }
        }
        return null; // IF ALL ELSE FAILS, it will RETURN NULL.

    }

    boolean insertAtFront(AnyType x) // Inserts AnyType at front of List. Returns FALSE if ID already exists
    {
        if(findID(x.getID()) != null) // If ID is found in List
        {
            return false;
        }
        else if(header == null) // If LinkedList EMPTY
        {
            header = new Node(x); // Adds in a new Node to header
        }
        else
        {
            Node temp = header;
            header = new Node(x, temp);
        }
        return true;


    }

    AnyType deleteFromFront() // Deletes and Returns the AnyType at the front of List. Returns NULL if List is EMPTY.
    {
        Node temp;
        if(header == null) //Guaranteed to be EMPTY if header is NULL
        {
            return null;
        }
        else
        {
            temp = header;
            header = header.getNext(); // Just straight up references the next node is the header
        }
        return temp.getStored();
    }

    AnyType delete(int ID) // Finds and Deletes the record based off of ID, or returns NULL if not FOUND
    {
        /*
            COPIED from findID
            ------------------
            While findID does the same thing, it cannot functionally do anything within the LinkedList. Additionally, it returns an object
            of Product type. We need a Node object.

        */

        // First check if List is not NULL (Empty)
        if (header != null)
        {
            // Comb through Linked List. Start: Header, End: Tail
            Node parsed = header;
            Node previous = null;
            int parsedID = parsed.getStored().getID();
            while (parsedID != ID) // Make sure that ID does not match
            {
                // Check that next node is NOT NULL
                if( parsed.getNext() != null) // Checks that Linked List not at end
                {
                    // Then assigns to NEXT.
                    previous = parsed; // Stores node BEHIND it for future LINKING after DELETION
                    parsed = parsed.getNext();
                    parsedID =  parsed.getStored().getID(); // New Parsing ID
                }
                else if(parsed.getStored().getID() == ID ) // Case at END of the Linked List & ID found
                {
                    return parsed.getStored();
                }
            }
            if(parsedID == ID) // Case in which ID found BEFORE END of Linked List
            {
                if(previous != null) // Case found ID is at front, so CHECK it's not
                {
                    previous.assignNext(parsed.getNext()); // Assigns the DELETED node's NEXT node to PREVIOUS' NEXT node
                    return parsed.getStored();
                }
                else
                {
                    return deleteFromFront();
                }
            }
        }
        return null; // IF ALL ELSE FAILS, it will RETURN NULL.
    }

    void printAllRecords() // Prints Linked List elements (In Order). If Empty, print msg.
    {
        Node running = header;
        System.out.println("----------------------------------------------------------------");
        if(header == null) // Find out if Linked List is empty first
        {
            System.out.println("Linked List is EMPTY!");
            System.out.println("----------------------------------------------------------------");
        }
        else
        {
            while(running != null)
            {
                if(running.getNext() != null) // Just a dumb way to make sure that the arrow doesn't print for the last element of the Linked List
                {
                    running.getStored().printID();
                    System.out.println(" | ");
                    System.out.println(" | ");
                    System.out.println(" V ");
                    running = running.getNext();
                }
                else
                {
                    running.getStored().printID();
                    System.out.println("----------------------------------------------------------------");
                    running = running.getNext();
                }

            }
        }

    }


} // End of Linked List Class

