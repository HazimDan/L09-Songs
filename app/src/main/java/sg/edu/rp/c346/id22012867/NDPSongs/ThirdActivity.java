package sg.edu.rp.c346.id22012867.NDPSongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import sg.edu.rp.c346.id22012867.songs.R;

public class ThirdActivity extends AppCompatActivity {

    TextView songID;
    EditText etTitle, etSinger, etYear;
    RatingBar etRB;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        songID = findViewById(R.id.songID);
        etTitle = findViewById(R.id.editSongTitle);
        etSinger = findViewById(R.id.editName);
        etYear = findViewById(R.id.editYear);
        etRB = findViewById(R.id.stars);
        btnUpdate = findViewById(R.id.update);
        btnDelete = findViewById(R.id.delete);
        btnCancel = findViewById(R.id.cancel);

        Intent intent = getIntent();
        data = (Song) intent.getSerializableExtra("data");

        songID.setText("Song ID: " + data.get_id());
        etTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(String.valueOf(data.getYear()));
        etRB.setRating(data.getStars());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                data.setTitle(etTitle.getText().toString());
                data.setSingers(etSinger.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                data.setStars((int) etRB.getRating());
                dbh.updateSong(data);
                Intent i = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                dbh.deleteNote(data.get_id());
                Intent i = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(i);

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}