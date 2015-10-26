package epicgraph.com.mydashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Entity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Midhun on 09-09-2015.
 */
public class Graph_Activity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);

        ViewStub stub = (ViewStub) findViewById(R.id.vsHeader);
        View inflated = stub.inflate();
          LineChart chart = (LineChart) findViewById(R.id.chart);

           LineData data = new LineData(getXAxisValues(), getDataSet());
           chart.setData(data);
             chart.setDescription("My Chart");
         chart.animateXY(2000, 2000);
         chart.invalidate();
    }

    private ArrayList<LineDataSet> getDataSet() {
        ArrayList<LineDataSet> dataSets = null;

        ArrayList<Entry> valueSet1 = new ArrayList<>();

        Entry v1e1 = new Entry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        Entry v1e2 = new Entry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        Entry v1e3 = new Entry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        Entry v1e4 = new Entry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        Entry v1e5 = new Entry(90.000f, 4); // May
        valueSet1.add(v1e5);
        Entry v1e6 = new Entry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList<Entry> valueSet2 = new ArrayList<>();
        Entry v2e1 = new Entry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        Entry v2e2 = new Entry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        Entry v2e3 = new Entry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        Entry v2e4 = new Entry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        Entry v2e5 = new Entry(20.000f, 4); // May
        valueSet2.add(v2e5);
        Entry v2e6 = new Entry(80.000f, 5); // Jun
        valueSet2.add(v2e6);

        LineDataSet lineDataSetSet1 = new LineDataSet(valueSet1, "Brand 1");
        lineDataSetSet1.setColor(Color.rgb(0, 155, 0));
        LineDataSet lineDataSetSet2 = new LineDataSet(valueSet2, "Brand 2");
        lineDataSetSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(lineDataSetSet1);
        dataSets.add(lineDataSetSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }
}
