package info.devexchanges.slectionwidgetandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View textAutoCompleteTextView = findViewById(R.id.autocomplete_textview);
        View textGridViewActivity = findViewById(R.id.gridview);
        View textSpinner = findViewById(R.id.spinner);
        View textListViewWithCheckBox = findViewById(R.id.listview_checkbox);

        textAutoCompleteTextView.setOnClickListener(this);
        textGridViewActivity.setOnClickListener(this);
        textSpinner.setOnClickListener(this);
        textListViewWithCheckBox.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.autocomplete_textview:
                gotoActivity(AutoCompleteActivity.class);
                break;

            case R.id.gridview:
                gotoActivity(GridViewActivity.class);
                break;

            case R.id.listview_checkbox:
                gotoActivity(CheckBoxListViewActivity.class);
                break;

            case R.id.spinner:
                gotoActivity(SpinnerActivity.class);
                break;

            default:
                break;
        }
    }

    private void gotoActivity(Class<?> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
