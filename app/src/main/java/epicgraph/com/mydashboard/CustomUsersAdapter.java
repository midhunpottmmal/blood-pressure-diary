package epicgraph.com.mydashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import epicgraph.com.objects.ListData;

/**
 * Created by Midhun on 10-09-2015.
 */
public class CustomUsersAdapter extends ArrayAdapter<ListData> {

    public CustomUsersAdapter(Context context, ArrayList<ListData> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ListData listData = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }



        // Lookup view for data population
         TextView systolic = (TextView) convertView.findViewById(R.id.sys);
         TextView diastolic = (TextView) convertView.findViewById(R.id.dia);
         TextView pulse = (TextView) convertView.findViewById(R.id.pulse);
         TextView date = (TextView) convertView.findViewById(R.id.date);
         TextView time = (TextView) convertView.findViewById(R.id.time);

        // Populate the data into the template view using the data object
            systolic.setText(listData.sys);
            diastolic.setText(listData.dia);
            pulse.setText(listData.pulse);
            date.setText(listData.date);
            time.setText(listData.time);

            systolicColor(systolic);
            pulseColor(pulse);
            diaColor(diastolic);
//        site.setText(listData.site);
//        date.setText(listData.date);



        // Return the completed view to render on screen
        return convertView;
    }

    private void systolicColor(TextView new_measure_sys) {

        String sys=String.valueOf(new_measure_sys.getText());
        int sysInNum;
        try {
            sysInNum = Integer.parseInt(sys);
        }catch (Exception e){
            sysInNum=0;
        }
        if(sysInNum<=90){
            System.out.println("inside first if condition");
            new_measure_sys.setBackgroundResource(R.color.white);
        }else if(sysInNum<=110){
            new_measure_sys.setBackgroundResource(R.color.blue);
        }else if (sysInNum<=130){
            new_measure_sys.setBackgroundResource(R.color.green);
        }else {
            new_measure_sys.setBackgroundResource(R.color.red);
        }
    }
    private void pulseColor(TextView new_measure_pulse) {

        String sys=String.valueOf(new_measure_pulse.getText());
        int sysInNum;
        try {
            sysInNum = Integer.parseInt(sys);
        }catch (Exception e){
            sysInNum=0;
        }
        if(sysInNum<=50){
            System.out.println("inside first if condition");
            new_measure_pulse.setBackgroundResource(R.color.white);
        }else if(sysInNum<65){
            new_measure_pulse.setBackgroundResource(R.color.blue);
        }else if (sysInNum<=85){
            new_measure_pulse.setBackgroundResource(R.color.green);
        }else {
            new_measure_pulse.setBackgroundResource(R.color.red);
        }
    }

    private void diaColor(TextView new_measure_dia) {

        String sys=String.valueOf(new_measure_dia.getText());
        int sysInNum;
        try {
            sysInNum = Integer.parseInt(sys);
        }catch (Exception e){
            sysInNum=0;
        }
        if(sysInNum<=50){
            System.out.println("inside first if condition");
            new_measure_dia.setBackgroundResource(R.color.white);
        }else if(sysInNum<=70){
            new_measure_dia.setBackgroundResource(R.color.blue);
        }else if (sysInNum<=90){
            new_measure_dia.setBackgroundResource(R.color.green);
        }else {
            new_measure_dia.setBackgroundResource(R.color.red);
        }
    }
}
