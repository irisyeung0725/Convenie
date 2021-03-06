package library.convenie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import library.convenie.constant.SQLCommand;
import library.convenie.view.TableView;
import library.convenie.util.DBOperator;
import android.database.Cursor;
import android.view.View;
import android.widget.ScrollView;
import android.view.View.OnClickListener;
import android.widget.Button;


public class TransactionActivity extends AppCompatActivity implements OnClickListener{

    Button gobackBtn;

    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        gobackBtn = (Button)this.findViewById(R.id.goback_btn);
        gobackBtn.setOnClickListener(this);

//        copy database file
        try{
            DBOperator.copyDB(getBaseContext());
        }catch(Exception e){
            e.printStackTrace();
        }

//        implement SQL query and get cursor of resultset
        Cursor cursor = DBOperator.getInstance().execQuery(SQLCommand.QUERY_TRANSACTION);
        TableView tableView = new TableView(this, cursor);
//        show data in tableview
        ScrollView scrollView = (ScrollView)this.findViewById(R.id.transaction_scrollview);
        scrollView.addView(tableView);
    }

    public void onClick(View v){
        int id=v.getId();
        if (id==R.id.goback_btn) {
            Intent intent = new Intent(this, ButtonActivity.class);
            this.startActivity(intent);
        }
    }


}


