public class Product implements IDedObject
{
    // STORED PRODUCT INFO:
    private int productID;
    private String productName;
    private String supplierName;

    public Product(int prodID, String prodName, String suppName)
    {
        productID = prodID;
        productName = prodName;
        supplierName = suppName;
    }
    public int getID() // Interface getID function
    {
        return productID;
    }
    /*
    public String prodName()
    {
        return productName;
    }

    public String suppName()
    {
        return supplierName;
    }
    */
    public void printID() // Interface printID function
    {
        System.out.print("Product ID: " + productID + "\nProduct Name: " + productName + "\nSupplier Name: " + supplierName + "\n");
    }

} // End of Product Class
