package info.devexchanges.slectionwidgetandroid;

import android.os.Bundle;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        gridView = (GridView) findViewById(R.id.gridview);

        String[] alphabetArray = Utils.readTextFromAssets(this, "vi_alphabet.txt");

        if (alphabetArray != null) {
            adapter = new ArrayAdapter<>(this, R.layout.item_gridview, R.id.text_view, alphabetArray);
            gridView.setAdapter(adapter);
        }

        gridView.setOnItemClickListener(onItemClickListener());
    }

    private AdapterView.OnItemClickListener onItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedLetter = adapterView.getAdapter().getItem(i).toString();
                Toast.makeText(GridViewActivity.this, selectedLetter, Toast.LENGTH_SHORT).show();
            }
        };
    }
}
