package info.devexchanges.slectionwidgetandroid;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private TextView selectedText;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_autocomplete_textview);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocomplete_textview);
        selectedText = (TextView)findViewById(R.id.text_result);

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
