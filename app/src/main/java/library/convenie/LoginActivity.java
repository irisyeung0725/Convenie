package library.convenie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity{

    EditText Name;
    EditText Password;
    TextView Info;
    Button Login;
    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("Numbers of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("admin")) && (userPassword.equals("123"))) {
            Intent intent = new Intent(LoginActivity.this, ButtonActivity.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("No.attempts remaining: " + String.valueOf(counter));

            if(counter == 0 ){
                Login.setEnabled(false);
            }
        }
    }

}