package com.max.ecomaxgo.maxpe.expenses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.max.ecomaxgo.maxpe.R;

public class ExpensesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        PieChart expen_chart=findViewById(R.id.expen_chart);

        /* tvJava.setText(Integer.toString(25));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(
            new PieModel(
                "R",
                Integer.parseInt(tvR.getText().toString()),
                Color.parseColor("#FFA726")));*/

    }
}