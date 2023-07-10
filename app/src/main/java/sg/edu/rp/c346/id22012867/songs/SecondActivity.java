package sg.edu.rp.c346.id22012867.songs;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;


public class SecondActivity extends AppCompatActivity {

    ListView lvSongs;
    ArrayAdapter<Song> aaSongs;
    ArrayList<Song> songs;

    Spinner spnSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

            lvSongs = findViewById(R.id.lvSongs);
            spnSongs = findViewById(R.id.spinnerYear);

            DBHelper dbHelper = new DBHelper(this);
            songs = dbHelper.getSongs();
            dbHelper.close();

            aaSongs = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songs);
            lvSongs.setAdapter(aaSongs);

            ArrayList<String> years = new ArrayList<String>();
            int thisYear = Calendar.getInstance().get(Calendar.YEAR);
            for (int i = 2000; i <= thisYear; i++) {
            years.add(Integer.toString(i));
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
            spnSongs.setAdapter(adapter);

    }

}
