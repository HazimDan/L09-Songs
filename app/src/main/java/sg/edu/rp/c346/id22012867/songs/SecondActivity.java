package sg.edu.rp.c346.id22012867.songs;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

    ListView lvSongs;
    ArrayAdapter<Song> aaSongs;
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lvSongs = findViewById(R.id.lvSongs);

        DBHelper dbHelper = new DBHelper(this);
        songs = dbHelper.getSongs();
        dbHelper.close();

        aaSongs = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songs);
        lvSongs.setAdapter(aaSongs);
    }
}
