package epicgraph.com.objects;

import java.util.ArrayList;

/**
 * Created by Midhun on 10-09-2015.
 */
public class ListData {


    public String sys;
    public String dia;
    public String pulse;
    public String heart_beat;
    public String hand;
    public String date;
    public String time;


    public ListData(String systolic, String diastolic, String pulse, String heart_beat, String hand,
                    String date, String time) {
        this.sys=systolic;
        this.dia=diastolic;
        this.pulse=pulse;
        this.heart_beat=heart_beat;
        this.hand=hand;
        this.date=date;
        this.time=time;
    }


}
