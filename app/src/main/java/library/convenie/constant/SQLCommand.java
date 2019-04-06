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
    public static String QUERY_EXPIRE = "select Item_Category, Items_Name, cast((julianday(date(Expire_date)) - julianday('2017-07-20')) as int) as \"Days to expire\" from Items where \"Days to expire\" > 0 order by Item_Category";
    public static String QUERY_SALE = "select sum(Line_Qty * Line_Price) as Total_Sales, Sales_Date from InvoiceLines, " +
            "Invoice where InvoiceLines.InvoiceID = Invoice.InvoiceID group by Invoice.Sales_Date";
}
