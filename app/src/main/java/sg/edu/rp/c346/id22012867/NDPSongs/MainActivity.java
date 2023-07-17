package sg.edu.rp.c346.id22012867.NDPSongs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import sg.edu.rp.c346.id22012867.songs.R;


public class MainActivity extends AppCompatActivity {

    EditText etTitle, etName, etYear;
    Button btnInsert, btnShow;
    RatingBar rb;
    ArrayAdapter<Song> aaSongs;
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.editSongTitle);
        etName = findViewById(R.id.editName);
        etYear = findViewById(R.id.editYear);
        btnInsert = findViewById(R.id.insert);
        btnShow = findViewById(R.id.show);
        rb = findViewById(R.id.stars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                String newTitle = etTitle.getText().toString();
                String newName = etName.getText().toString();
                int newYear = Integer.parseInt(etYear.getText().toString());
                int newStars = (int) rb.getRating();


                db.insertSong(newTitle, newName, newYear, newStars);

            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<String> data = db.getSongsContent();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}