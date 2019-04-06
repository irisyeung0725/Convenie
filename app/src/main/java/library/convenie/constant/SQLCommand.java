package library.convenie.constant;

/**
 *  SQL commands
 *  Including select/delete/update/insert
 */

public abstract class SQLCommand {

//    get employee information
    public static String QUERY_EMPLOYEE = "select Emp_Name, Emp_Role, Salary from Employee order by Salary";
    public static String QUERY_VENDOR = "select Vendor_Name, Vendor_Type from Vendor";
    public static String QUERY_TRANSACTION = "select count(InvoiceID), Sales_Date from Invoice group by Sales_Date";
    public static String QUERY_ITEMS = "select Items_Name, Item_QOH from Items order by Item_QOH";
    public static String QUERY_EXPIRE = "select Items_Name, Item_QOH from Items order by Expire_Date";
    public static String QUERY_SALE = "select sum(Line_QTY * Line_Price) as Total_Sales from InvoiceLines, Invoice where InvoiceLines.InvoiceID = InvoiceLines.InvoiceID group by Invoice.Sales_Date";
}
