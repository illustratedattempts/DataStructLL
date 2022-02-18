import java.util.Scanner;

public class Tester
{
    public static void menu()  // Prints out the menu.
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
    public static Product buildProduct()
    {
        Product temp;
        Scanner inner_input = new Scanner(System.in);
        System.out.print("Enter Product Name: ");
        String prodName = inner_input.nextLine();
        System.out.print("Product Name: " + prodName + "\nEnter Supplier's Name: ");
        String suppName = inner_input.nextLine();
        System.out.print("Supplier Name: " + suppName + "\nEnter Product ID: ");
        int prodID = inner_input.nextInt();
        System.out.print("Product ID: " + prodID);
        System.out.print("\nApplication Complete\n");
        temp = new Product(prodID, prodName, suppName);
        return temp;
    }
    public static void main(String[] args)
    {
        LinkedList<Product> userCreated = new LinkedList();

        boolean user_Done = false;
        Scanner input = new Scanner(System.in);
        // User Input Menu
        while(!user_Done)
        {
            menu();
            int menu_Input = input.nextInt();
            switch(menu_Input)
            {
                case 1:
                    userCreated.makeEmpty();
                    break;
                case 2:
                    int ID_Find = input.nextInt();
                    userCreated.findID(ID_Find);
                    break;
                case 3:
                    userCreated.insertAtFront(buildProduct());
                    break;
                case 4:
                    userCreated.deleteFromFront();
                    break;
                case 5:
                    int ID_Delete = input.nextInt();
                    userCreated.delete(ID_Delete);
                    break;
                case 6:
                    userCreated.printAllRecords();
                    break;
                case 7:
                    user_Done = true;
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
