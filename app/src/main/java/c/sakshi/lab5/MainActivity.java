package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString(usernameKey, "").equals("")){
//            if(sharedPreferences.getString("username", "").equals("hello")){
                startActivity(new Intent(this, Main2Activity.class));
//            }
        } else {
            setContentView(R.layout.activity_main);
        }

        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

    }
    public String getUserInfo(){
        return username.getText().toString();
    }

    public void login(View view){
        String user = username.getText().toString();
        String pass = password.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", user).apply();

        Toast toast = Toast.makeText(this, user + " " + pass, Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }
}
