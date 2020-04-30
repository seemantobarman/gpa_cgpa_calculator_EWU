package com.example.seemanto.cgpacalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CgpaCalculatinActivity extends AppCompatActivity {

    private Button calculate;
    private EditText previouscgpa,previouscredit;
    private TextView result,name;
    double sumofcredit,gpa,cgpa_one,total_credit,cgpa_final;

    DecimalFormat final_result = new DecimalFormat("###,###.00");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa_calculatin);

        calculate = findViewById(R.id.cgpa_calculateID);
        previouscgpa = findViewById(R.id.previouscgpaID);
        previouscredit = findViewById(R.id.creditearnedID);
        result = findViewById(R.id.cgparesultID);
        name = findViewById(R.id.my_name);

        Bundle b = getIntent().getExtras();

        sumofcredit = b.getDouble("first");

        gpa = b.getDouble("second");

    }

    public void cgpaprocess(View view)
    {
            try
            {

                String p_cgpa = previouscgpa.getText().toString();
                String credit = previouscredit.getText().toString();

                double previous_cgpa = Double.parseDouble(p_cgpa);
                double credit_earned = Double.parseDouble(credit);

                if(previous_cgpa<1 || previous_cgpa >4 || credit_earned >158 || credit_earned<0)
                {
                    Toast.makeText(this, "FIX THE VALUE", Toast.LENGTH_SHORT).show();
                }

                else

            {

                cgpa_one = (previous_cgpa * credit_earned) + (gpa * sumofcredit);


                total_credit = sumofcredit + credit_earned;

                cgpa_final = (cgpa_one) / total_credit;

                result.setText("CGPA is : " + final_result.format(cgpa_final));

            }

            }

            catch (Exception e)

            {
                Toast.makeText(this, "FILL ALL VALUES", Toast.LENGTH_SHORT).show();
            }

    }
}
