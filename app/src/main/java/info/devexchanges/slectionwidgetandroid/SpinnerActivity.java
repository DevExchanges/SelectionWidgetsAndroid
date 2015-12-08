package info.devexchanges.slectionwidgetandroid;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayAdapter<String> spinnerAdapter;
    private TextView selectedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = (Spinner)findViewById(R.id.spinner);
        selectedText = (TextView)findViewById(R.id.select_text);

        String[] alphabetArray = Utils.readTextFromAssets(this, "vi_alphabet.txt");

        if (alphabetArray != null) {
            spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alphabetArray);
            spinner.setAdapter(spinnerAdapter);
        }
        spinner.setOnItemSelectedListener(onItemSelected());
    }

    private AdapterView.OnItemSelectedListener onItemSelected() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedText.setText(adapterView.getSelectedItem() + " selected!");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }
}