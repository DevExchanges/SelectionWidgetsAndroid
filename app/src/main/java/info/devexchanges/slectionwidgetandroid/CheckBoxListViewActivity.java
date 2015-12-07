package info.devexchanges.slectionwidgetandroid;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CheckBoxListViewActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = (ListView) findViewById(R.id.list);

        String[] itemsListView = Utils.readTextFromAssets(this, "lorem_ipsum_text.txt");
        if (itemsListView != null) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, itemsListView);
            listView.setAdapter(adapter);
        }
    }
}
