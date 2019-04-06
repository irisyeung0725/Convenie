package library.convenie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import library.convenie.util.DBOperator;


public class ConvenieActivity extends AppCompatActivity implements OnClickListener{

    Button enterBtn;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convenie);
        enterBtn =(Button)this.findViewById(R.id.MainPage_Button);
        enterBtn.setOnClickListener(this);

        try{
            DBOperator.copyDB(getBaseContext());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClick(View v){

        int id=v.getId();
        if (id==R.id.MainPage_Button){
            Intent intent = new Intent(this, ButtonActivity.class);
            this.startActivity(intent);

        }
    }
}



