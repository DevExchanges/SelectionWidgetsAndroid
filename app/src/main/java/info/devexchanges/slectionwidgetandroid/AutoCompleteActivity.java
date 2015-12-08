package info.devexchanges.slectionwidgetandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private TextView selectedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete_textview);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocomplete_textview);
        selectedText = (TextView)findViewById(R.id.text_result);

        String[] alphabetArray = Utils.readTextFromAssets(this, "lorem_ipsum_text.txt");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alphabetArray);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.addTextChangedListener(onTextWatcher());
    }

    private TextWatcher onTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                selectedText.setText(autoCompleteTextView.getText().toString());
            }
        };
    }
}
