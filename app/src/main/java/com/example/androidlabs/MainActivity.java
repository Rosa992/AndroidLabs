package com.example.androidlabs;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_linear);

        CheckBox checkBox = findViewById(R.id.myCheckBox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
                String message = "The checkbox is now " + (isChecked ? "on" : "off");

                Snackbar.make(cb, message, Snackbar.LENGTH_LONG)
                        .setAction("Undo", v -> cb.setChecked(!isChecked))
                        .show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            EditText editText = findViewById(R.id.editTextInput);
            Button button = findViewById(R.id.buttonPressMe);
            TextView textView = findViewById(R.id.textViewOutput);

            button.setOnClickListener(v -> {
                String inputText = editText.getText().toString();
                textView.setText(inputText);

        });

    }
}