package library.convenie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import library.convenie.constant.SQLCommand;
import library.convenie.view.TableView;
import library.convenie.util.DBOperator;
import android.database.Cursor;
import android.widget.ScrollView;


public class EmployeeActivity extends AppCompatActivity{

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emloyee);

//        copy database file
        try{
            DBOperator.copyDB(getBaseContext());
        }catch(Exception e){
            e.printStackTrace();
        }

//        implement SQL query and get cursor of resultset
        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_EMPLOYEE);
        TableView tableView = new TableView(this, cursor);
//        show data in tableview
        ScrollView scrollView = (ScrollView)this.findViewById(R.id.employee_scrollview);
        scrollView.addView(tableView);
    }


}
