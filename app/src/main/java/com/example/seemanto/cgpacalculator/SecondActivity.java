package com.example.seemanto.cgpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    String[] grades;
    private Spinner first_spinner, second_spinner;
    private EditText first_edittext, second_edittext;
    private Button calculate_button, cgpa_calculate;
    private TextView result_textview;
    double first_grade_point, second_grade_point;
    double value_1, value_2;
    double result;

    DecimalFormat final_result = new DecimalFormat("###,###.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        first_edittext = findViewById(R.id.third_activity_edittextID);
        second_edittext = findViewById(R.id.third_activity_edittext2ID);

        first_spinner = findViewById(R.id.first_spinnerID);
        second_spinner = findViewById(R.id.second_spinnerID);

        result_textview = findViewById(R.id.third_activity_resultID);

        calculate_button = findViewById(R.id.third_activity_calculateID);
        cgpa_calculate = findViewById(R.id.calculatecgpaID);
        cgpa_calculate.setVisibility(View.INVISIBLE);

        grades = getResources().getStringArray(R.array.all_grades);

        ArrayAdapter<String> first_adapter = new ArrayAdapter<String>(this, R.layout.sample_spinner_view, R.id.samplespinnerviewID, grades);

        first_spinner.setAdapter(first_adapter);

        second_spinner.setAdapter(first_adapter);

    }


    public void third_process(View view)
    {

        String first_grade = first_spinner.getSelectedItem().toString();

        if(first_grade.equals("A")){

            first_grade_point = 4;
        }

        if(first_grade.equals("A-")){

            first_grade_point = 3.70;
        }

        if (first_grade.equals("B+")){

            first_grade_point = 3.30;
        }

        if(first_grade.equals("B")){

            first_grade_point = 3;
        }

        if(first_grade.equals("B-")){

            first_grade_point = 2.70;
        }

        if (first_grade.equals("C+")){

            first_grade_point =2.30;
        }

        if(first_grade.equals("C")){

            first_grade_point = 2;
        }

        if(first_grade.equals("C-")){

            first_grade_point = 1.70;
        }

        if (first_grade.equals("D+")){

            first_grade_point = 1.30;
        }

        if (first_grade.equals("D")){

            first_grade_point = 1;
        }




        String second_grade = second_spinner.getSelectedItem().toString();

        if(second_grade.equals("A")){

            second_grade_point = 4;
        }

        if(second_grade.equals("A-")){

            second_grade_point = 3.70;
        }

        if (second_grade.equals("B+")){

            second_grade_point = 3.30;
        }

        if(second_grade.equals("B")){

            second_grade_point = 3;
        }

        if(second_grade.equals("B-")){

            second_grade_point = 2.70;
        }

        if (second_grade.equals("C+")){

            second_grade_point =2.30;
        }

        if(second_grade.equals("C")){

            second_grade_point = 2;
        }

        if(second_grade.equals("C-")){

            second_grade_point = 1.70;
        }

        if (second_grade.equals("D+")){

            second_grade_point = 1.30;
        }

        if (second_grade.equals("D")){

            second_grade_point = 1;
        }


        try
        {
            String first_credit = first_edittext.getText().toString();
            String second_credit = second_edittext.getText().toString();

            double credit_1 = Double.parseDouble(first_credit);
            double credit_2 = Double.parseDouble(second_credit);

            if ( credit_1>4 || credit_1<1 || credit_2>4 || credit_2<1)
            {
                Toast.makeText(this, "INVALID CREDIT", Toast.LENGTH_SHORT).show();
            }

            else
            {
                double sumofcredit = credit_1 + credit_2;
                double sum = (credit_1*first_grade_point) + (credit_2*second_grade_point);
                result = sum/sumofcredit;


                result_textview.setText("Term GPA :" +final_result.format(result));

                value_1 = sumofcredit;
                value_2 = result;
            }

            if(final_result != null)
            {
                cgpa_calculate.setVisibility(View.VISIBLE);

            }

        }

        catch (Exception e)
        {
            Toast.makeText(this, "FILL ALL VALUES", Toast.LENGTH_SHORT).show();
        }


    }


    public void cgpa_process(View view)
    {
        Intent intent = new Intent(this,CgpaCalculatinActivity.class);

        Bundle b = new Bundle();

        b.putDouble("first",value_1);
        b.putDouble("second",value_2);
        intent.putExtras(b);

        startActivity(intent);
    }
}
