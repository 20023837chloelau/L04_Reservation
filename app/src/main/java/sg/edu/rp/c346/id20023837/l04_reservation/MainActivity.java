package sg.edu.rp.c346.id20023837.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNumber;
    EditText etSize;
    RadioButton rbSmoking;
    RadioButton rbNoSmoking;
    DatePicker datePicker;
    TimePicker timePicker;
    Button btnConfirm;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.inputPersonName);
        etNumber = findViewById(R.id.inputMobileNo);
        etSize = findViewById(R.id.inputPersonNo);
        rbSmoking = findViewById(R.id.radioButton);
        rbNoSmoking = findViewById(R.id.radioButton2);
        datePicker = findViewById(R.id.DatePicker);
        timePicker = findViewById(R.id.TimePicker);
        btnConfirm = findViewById(R.id.submitBtn);
        btnReset = findViewById(R.id.resetBtn);

        datePicker.updateDate(2021, 5, 1);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String mobileNum = etNumber.getText().toString();
                String size = etSize.getText().toString();

                String date = datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth();
                String time = timePicker.getCurrentHour() + ":" + String.format("%02d", timePicker.getCurrentMinute());

                String isSmoke = "";
                if (rbSmoking.isChecked()) {
                    isSmoke = "smoking";
                } else {
                    isSmoke = "non-smoking";
                }

                String msg = "Hello, " + name + ", you have booked a " + isSmoke + " table of " + size + " person(s) on " + date + " at " + time + ". Your phone number is " + mobileNum + ".";

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

            }

        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etName.setText("");
                etNumber.setText("");
                etSize.setText("");
                rbSmoking.setChecked(false);
                rbNoSmoking.setChecked(false);
                datePicker.updateDate(2021, 5, 1);
                timePicker.setCurrentHour(7);
                timePicker.setCurrentMinute(30);


            }
        });
    }
}
