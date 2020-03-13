package com.dotinfiny.mvvmexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.dotinfiny.mvvmexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.dotinfiny.mvvmexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.dotinfiny.mvvmexample.EXTRA_PRIORITY";

    EditText editTitle;
    EditText editDescription;
    NumberPicker numberPicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTitle = findViewById(R.id.title_edt);
        editDescription = findViewById(R.id.desc_edt);
        numberPicker = findViewById(R.id.number_picker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24dp);
        setTitle("Add Note");

    }

    private void saveNote(){
        String title = editTitle.getText().toString();
        String descripiton = editDescription.getText().toString();
        int priority = numberPicker.getValue();

        if(title.trim().isEmpty() || descripiton.trim().isEmpty()){
            Toast.makeText(this, "Please insert detail", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESCRIPTION,descripiton);
        data.putExtra(EXTRA_PRIORITY,priority);

        setResult(RESULT_OK,data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
