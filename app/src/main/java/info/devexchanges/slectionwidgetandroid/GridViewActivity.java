package info.devexchanges.slectionwidgetandroid;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_gridview);

        gridView = (GridView) findViewById(R.id.gridview);

        String[] alphabetArray = Utils.readTextFromAssets(this, "vi_alphabet.txt");

        if (alphabetArray != null) {
            adapter = new ArrayAdapter<>(this, R.layout.item_gridview, alphabetArray);
            gridView.setAdapter(adapter);
        }

        gridView.setOnItemClickListener(onItemClickListener());
    }

    private AdapterView.OnItemClickListener onItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedLetter = (String) adapterView.getSelectedItem();
                Toast.makeText(GridViewActivity.this, selectedLetter, Toast.LENGTH_SHORT).show();
            }
        };
    }
}
