package library.convenie;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import library.convenie.util.DBOperator;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Intent;



public class ButtonActivity extends AppCompatActivity implements OnClickListener {

    Button employeeBtn, expireBtn, itemsBtn, saleBtn, transactionBtn, vendorBtn;
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        employeeBtn =(Button)this.findViewById(R.id.Employee_Btn);
        employeeBtn.setOnClickListener(this);
        expireBtn = (Button)this.findViewById(R.id.Expire_Btn);
        expireBtn.setOnClickListener(this);
        itemsBtn = (Button)this.findViewById(R.id.Items_Btn);
        itemsBtn.setOnClickListener(this);
        saleBtn = (Button)this.findViewById(R.id.Sale_Btn);
        saleBtn.setOnClickListener(this);
        transactionBtn = (Button)this.findViewById(R.id.Transaction_Btn);
        transactionBtn.setOnClickListener(this);
        vendorBtn = (Button)this.findViewById(R.id.Vendor_Btn);
        vendorBtn.setOnClickListener(this);

//        copy database file
        try{
            DBOperator.copyDB(getBaseContext());
        }catch(Exception e){
            e.printStackTrace();
        }

////        implement SQL query and get cursor of resultset
//        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_EMPLOYEE);
//        TableView tableView = new TableView(this, cursor);
////        show data in tableview
//        ScrollView scrollView = (ScrollView)this.findViewById(R.id.query_scrollview);
//        scrollView.addView(tableView);
    }

    public void onClick(View v)
    {
        int id=v.getId();
        if (id==R.id.Employee_Btn){
            Intent intent = new Intent (this, EmployeeActivity.class);
            this.startActivity(intent);
        }else if (id==R.id.Sale_Btn){
            Intent intent = new Intent (this, SaleActivity.class);
            this.startActivity(intent);
        }else if (id==R.id.Expire_Btn){
            Intent intent = new Intent (this, ExpireActivity.class);
            this.startActivity(intent);
        }else if (id==R.id.Items_Btn){
            Intent intent = new Intent (this, ItemsActivity.class);
            this.startActivity(intent);
        }else if (id==R.id.Transaction_Btn){
            Intent intent = new Intent (this, TransactionActivity.class);
            this.startActivity(intent);
        }else if (id==R.id.Vendor_Btn){
            Intent intent = new Intent (this, VendorActivity.class);
            this.startActivity(intent);
        }

    }

}
