package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {
    int noteid = -1;

    EditText notes;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // 1.
        notes = (EditText) findViewById(R.id.editText);
        saveButton = (Button) findViewById(R.id.button);
        // 2.
        Intent intent = new Intent(this, Main3Activity.class);
        // 3.
        noteid = getIntent().getIntExtra("noteid", -1);
        // 4.

        if(noteid != -1) {
            Note note = Main2Activity.notes.get(noteid);
            String noteContent = note.getContent();
            //display the contents of the note on the screen
            notes.setText(noteContent);
        }
    }

    public void saveMethod(View view){
        // 1.
        String content = notes.getText().toString();
        // 2.
        SQLiteDatabase sqLiteDatabase = getApplicationContext().openOrCreateDatabase("notes", Context.MODE_PRIVATE, null);
        // 3.
        DBHelper dbHelper = new DBHelper(sqLiteDatabase);
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        // 4.
        String username = sharedPreferences.getString("username", "");
        // 5.
        String title;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String date = dateFormat.format(new Date());

        if(noteid == -1){
            title = "Note_" + (Main2Activity.notes.size() + 1);
            dbHelper.saveNotes(username, title, content, date);
        } else {
            title = "NOTE_" + (noteid + 1);
            dbHelper.updateNotes(title, date, content, username);
        }
        // 6.
        startActivity(new Intent(this, Main2Activity.class));
    }
}
