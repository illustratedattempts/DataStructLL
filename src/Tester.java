import java.util.Scanner;
// Clean your comments later dummy, these comments are kind dumb
public class Tester
{
    private static void menu()  // Prints out the menu.
    {
        System.out.print(
        "Operations on List\n" +
                "1. Make Empty\n" +
                "2. Find ID\n" +
                "3. Insert at Front\n" +
                "4. Delete From Front\n" +
                "5. Delete ID\n" +
                "6. Print All Records\n" +
                "7. Done\n"
        );
    }
    // Thoughts on if nextLine() then nextInt() - Wouldn't
    private static Product buildProduct() // Takes user input and return the product
    {
        Scanner inner_input = new Scanner(System.in);
        System.out.print("Enter Product Name: ");
        String prodName = inner_input.nextLine();
        System.out.print("Product Name: " + prodName + "\nEnter Supplier's Name: ");
        String suppName = inner_input.nextLine();
        System.out.print("Supplier Name: " + suppName + "\nEnter Product ID: ");
        // Catches Format Type Errors: NumberFormatException
        // Thoughts on filtering out strings that include purely integers? Honestly a lot of work.
        int prodID = inner_input.nextInt();
        System.out.print("Product ID: " + prodID);
        System.out.print("\nApplication Complete for " + prodName + ": " + prodID + ", supplied by " + suppName + "\n");
        return new Product(prodID, prodName, suppName);
    }
    public static void main(String[] args)
    {
        LinkedList<Product> userCreated = new LinkedList();

        boolean user_Done = false;
        Scanner input = new Scanner(System.in);
        // User Input Menu

        while(!user_Done)
        {
            menu(); // Displays menu options
            int menu_Input = input.nextInt();
            /*
                EDGE CASES (To work on)
                ----------
                * 1: Print out that the list is now empty. [x]
                * 2: Make sure that the input is an INT. []
                * 3: (Allowed) User can enter any string for names. However, ID must be an INT. []
                     Needs to be able to handle TRUE/FAlSE output from insertAtFront()  []
                * 4: Print out something after deleteFromFront() in cases where returns NULL, also print out delete item []
                * 5: Same as above (* 4). []
                * 6: Nothing really, just prints it out
                * 7: Print out that item is exiting [x]

                Recommended to use Integer.parseInt(scanner.nextLine()) over scanner.nextInt()
                ** REPLACE ALL []
                REASON: .nextInt() leaves a line break in the keyboard buffer
                Test if STRING or ID are the same

                // 1-7 for input
                // Exception handler
                // Function to validate
                // Try-Catch && Validate
                // Integer inputs must be greater than 0
            */
            switch(menu_Input)
            {
                case 1:
                    userCreated.makeEmpty();

                    System.out.println("Linked List has been CLEARED.");

                    break;
                case 2:
                    try {
                        int ID_Find = input.nextInt();
                        userCreated.findID(ID_Find);
                    }
                    catch(NullPointerException e)
                    {
                        System.out.println("Input needs to be an Integer");
                    }
                    break;
                case 3:
                    userCreated.insertAtFront(buildProduct()); // New Product Case
                    break;
                case 4:
                    userCreated.deleteFromFront();
                    break;
                case 5:
                    System.out.print("Here!");
                    int ID_Delete = Integer.parseInt(input.nextLine());
                    userCreated.delete(ID_Delete);
                    break;
                case 6:
                    userCreated.printAllRecords();
                    break;
                case 7:
                    user_Done = true;
                default:
                    System.out.print("Please enter an input between 1 - 7.");
            }
        }
        input.close();


        /*
                    CUSTOM MANUALLY INPUTTED TEST CASES

        //How to make good test cases for code?
        Product tester01 = new Product(69420, "DING1", "TESTER1");
        Product tester02 = new Product(69421, "DING2", "TESTER2");
        Product tester03 = new Product(69422, "DING3", "TESTER3");
        Product tester04 = new Product(69423, "DING4", "TESTER4");


        //Linked List Zone
        LinkedList<Product> testing = new LinkedList();
        testing.insertAtFront(tester01);
        testing.insertAtFront(tester02);
        testing.insertAtFront(tester03);
        testing.insertAtFront(tester04);

        //Records Print
        System.out.println("|  Print All Records  |");
        testing.printAllRecords();

        //Find ID
        System.out.println("|  Find ID  |");
        // Think about using printf?
        testing.findID(69423).printID();
        testing.findID(69422).printID();
        testing.findID(69421).printID();
        testing.findID(69420).printID();

        //Delete from Middle of Linked List
        System.out.println("|  DELETE FRONT  |");
        testing.delete(69423);

        //Records Print
        System.out.println("|  Print All Records  |");
        testing.printAllRecords();
        /*
        //Delete Front
        System.out.println("|  Deletion From Front  |");
        testing.deleteFromFront().printID();
        testing.deleteFromFront().printID();
        testing.deleteFromFront().printID();
        testing.deleteFromFront().printID();


        // ERROR Null Exception
        // You could just ask if it equals NULL
        //testing.deleteFromFront().printID();

        // Make Empty
        // Reinsertion of Nodes
        testing.insertAtFront(tester01);
        testing.insertAtFront(tester02);
        testing.insertAtFront(tester03);
        testing.insertAtFront(tester04);
        // Make Empty Function Call
        testing.makeEmpty();
        // Testing print call
        testing.printAllRecords();
        */
    }
}
