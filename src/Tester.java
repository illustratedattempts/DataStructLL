import java.util.InputMismatchException;
import java.util.Scanner;

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
                "7. Done\n" +
                "Your Choice: "
        );
    }

    private static int validInt(Scanner input) // Prompts, verifies, and returns an integer greater than 0
    {
        boolean input_valid = false;
        int valid_Int = -1;

        while(!input_valid)
        {

            try
            {
                valid_Int = input.nextInt();

                if (valid_Int > 0) {
                    input_valid = true;
                } else {
                    System.out.println("ID must be GREATER than 0. Try Again.");
                    System.out.print("Enter Product ID: ");
                }
            }
            catch(InputMismatchException e)
            {
                input.next(); // Referenced by StackOverflow: Scanner does not discard InputMismatchException. Need to do it manually.
                System.out.println("Integer Values ONLY! Try Again.");
                System.out.print("Enter Product ID: ");
            }

        }
        return valid_Int;
    }

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
        int prodID = validInt(inner_input);
        System.out.print("Product ID: " + prodID);
        System.out.print("\nApplication Complete for " + prodName + " of ID " + prodID + ", supplied by " + suppName + "\n");
        return new Product(prodID, prodName, suppName); // Same ID does not filter
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
            switch(menu_Input)
            {
                case 1:
                    userCreated.makeEmpty();
                    System.out.println("Linked List has been CLEARED.\n");
                    break;
                case 2: // Find ID
                        System.out.print("Enter Product ID To Find: ");
                        int ID_Find = validInt(input);
                        Product IDHolder = userCreated.findID(ID_Find);
                        if(IDHolder != null)
                        {
                            IDHolder.printID(); System.out.println();
                        }
                        else
                        {
                            System.out.println("Product does not exist/List is empty."); System.out.println();
                        }
                    break;
                case 3: // Insert at Front
                    boolean accepted_insertion = userCreated.insertAtFront(buildProduct()); // New Product Case
                    if(accepted_insertion)
                    {
                        System.out.println("Application Approved. Product was inserted into List.\n");
                    }
                    else
                    {
                        System.out.println("Application Denied. Product already exists.\n");
                    }
                    break;
                case 4: // Delete From Front
                    Product DeleteFrontHolder = userCreated.deleteFromFront();
                    if(DeleteFrontHolder == null) // Delete From Front can call NULL
                    {
                        System.out.println("Linked List is Empty!");
                    }
                    else
                    {
                        System.out.println("Deleted From Front:");
                        DeleteFrontHolder.printID(); System.out.println();
                    }

                    break;
                case 5: // Delete ID
                    System.out.print("Enter Product ID To Be Deleted: ");
                    int ID_Delete = validInt(input);
                    Product DeleteID_Holder = userCreated.delete(ID_Delete);
                    if(DeleteID_Holder == null)
                    {
                        System.out.println("ID does not exist/Can not be found."); System.out.println();
                    }
                    else
                    {
                        System.out.println("Deleted:");
                        DeleteID_Holder.printID(); System.out.println();
                    }
                    break;
                case 6: // Print All Records
                    userCreated.printAllRecords();
                    break;
                case 7: // Exit on Completion
                    System.out.println("Exiting Application...");
                    user_Done = true;
                    break;
                default:
                    System.out.println("Please enter an input between 1 - 7 (inclusive).\n");
                    break;
            }
        }
        input.close();

    }
}
