package io.github.jobseq;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    private PieChart jobLossPieChart;
    private PieChart jobGainPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // set ids
        jobLossPieChart = findViewById(R.id.jobLossChart);
        jobGainPieChart = findViewById(R.id.jobGainChart);

        jobLossPieChartBuild();
        jobGainPieChartBuild();
    }

    // set pieChart properties
    private void setChartProperty(PieChart chart, String title) {
        chart.setDrawHoleEnabled(true);
        chart.setUsePercentValues(true);
        chart.setEntryLabelColor(Color.BLACK);
        chart.setCenterText(title);
        chart.setCenterTextSize(20);
        chart.getDescription().setEnabled(false);
        chart.setDrawEntryLabels(false);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
        l.setTextSize(18f);
    }

    private void jobLossPieChartBuild() {

        // set properties
        setChartProperty(jobLossPieChart, "Job\nLosses");

        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.25f, "Civil"));
        entries.add(new PieEntry(0.17f, "Construction"));
        entries.add(new PieEntry(0.30f, "Entertainment"));
        entries.add(new PieEntry(0.25f, "Electricity"));
        entries.add(new PieEntry(0.40f, "Labours"));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS)
            colors.add(color);

        for (int color: ColorTemplate.VORDIPLOM_COLORS)
            colors.add(color);

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(jobLossPieChart));
        data.setValueTextSize(14f);
        data.setValueTextColor(Color.BLACK);

        jobLossPieChart.setData(data);
        jobLossPieChart.invalidate();

        jobLossPieChart.animateY(1400, Easing.EaseInOutQuad);
    }

    private void jobGainPieChartBuild() {

        // set properties
        setChartProperty(jobGainPieChart, "Job\nGains");

        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.35f, "I.T."));
        entries.add(new PieEntry(0.7f, "Medical"));
        entries.add(new PieEntry(0.6f, "Agricultural"));
        entries.add(new PieEntry(0.4f, "Start-ups"));
        entries.add(new PieEntry(0.9f, "Digital"));

        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.MATERIAL_COLORS)
            colors.add(color);

        for (int color: ColorTemplate.VORDIPLOM_COLORS)
            colors.add(color);

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(jobGainPieChart));
        data.setValueTextSize(14f);
        data.setValueTextColor(Color.BLACK);

        jobGainPieChart.setData(data);
        jobLossPieChart.invalidate();

        jobGainPieChart.animateY(1400, Easing.EaseInOutQuad);
    }
}