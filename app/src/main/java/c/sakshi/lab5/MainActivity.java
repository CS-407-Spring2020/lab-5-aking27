package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

    }

    public void login(View view){
        String user = username.getText().toString();
        String pass = password.getText().toString();
        Toast toast = Toast.makeText(this, user + " " + pass, Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }
}
