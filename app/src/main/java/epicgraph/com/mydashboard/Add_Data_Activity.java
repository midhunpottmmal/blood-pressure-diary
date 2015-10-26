package epicgraph.com.mydashboard;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TimePicker;
import android.widget.Toast;
import android.database.Cursor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import epicgraph.com.objects.NewData;
import epicgraph.com.sevicehanler.DatabaseOpenHelper;

/**
 * Created by Midhun on 09-09-2015.
 */
public class Add_Data_Activity extends Activity{
    String HAND ="Hand Right";
    String HEART ="Heart Beat Normal";
    EditText new_measure_sys;
    EditText new_measure_dia;
    EditText new_measure_pulse;
    EditText new_measure_date;
    EditText new_measure_time;
    EditText new_measure_note;

    Button  new_measure_save;
    Button  new_measure_cancel;
    Button  new_measure_hand;
    Button  new_measure_heart_beat;

    private SQLiteDatabase mDB = null;
    private DatabaseOpenHelper mDbHelper;
    private SimpleCursorAdapter mAdapter;
    final Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_messure);
        ViewStub stub = (ViewStub) findViewById(R.id.vsHeader);
        View inflated = stub.inflate();

        new_measure_sys =(EditText)findViewById(R.id.new_measure_sys);
        new_measure_dia= (EditText)findViewById(R.id.new_measure_dia);
        new_measure_note =(EditText) findViewById(R.id.new_measure_note);
        new_measure_pulse= (EditText)findViewById(R.id.new_measure_pulse);
        new_measure_save = (Button)findViewById(R.id.new_measure_save);
        new_measure_hand =(Button) findViewById(R.id.new_measure_hand);
        new_measure_date =(EditText) findViewById(R.id.new_measure_date);
        new_measure_time =(EditText) findViewById(R.id.new_measure_time);
        new_measure_heart_beat=(Button) findViewById(R.id.new_measure_heart_beat);

        new_measure_sys.setBackgroundResource(R.color.green);
        new_measure_dia.setBackgroundResource(R.color.green);
        new_measure_pulse.setBackgroundResource(R.color.green);



        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();

        new_measure_date.setText(dateFormat.format(date));
        new_measure_time.setText(timeFormat.format(date));


        new_measure_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sys = String.valueOf(new_measure_sys.getText());
                String dia = String.valueOf(new_measure_dia.getText());
                String pulse = String.valueOf(new_measure_pulse.getText());
                String heart_beat = String.valueOf(new_measure_heart_beat.getText());
                String hand = String.valueOf(new_measure_hand.getText());
                String time = String.valueOf(new_measure_time.getText());
                String date= String.valueOf(new_measure_date.getText());
                String note = String.valueOf(new_measure_note.getText());

                NewData data =new NewData();

                data.setNote(note);
                data.setDate(date);
                data.setTime(time);
                data.setHand(1);
                data.setHeart_beat(1);
                data.setPulse(Integer.parseInt(pulse));
                data.setDia(Integer.parseInt(dia));
                data.setSys(Integer.parseInt(sys));

                insertArtists(data);

                Intent intent = new Intent(getApplicationContext(),Record_Activity.class);
                startActivity(intent);
            }
        });


        final DatePickerDialog.OnDateSetListener myDate = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updatelbl();
            }

        };

        new_measure_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Add_Data_Activity.this, myDate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        new_measure_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Add_Data_Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        new_measure_time.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });




        new_measure_hand.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String flag = String.valueOf(new_measure_hand.getText());
                if(flag.equals(HAND)){
                    System.out.println(flag);
                    new_measure_hand.setText("Hand Left");

                }else {
                    new_measure_hand.setText("Hand Right");
                }
            }
        });

        new_measure_heart_beat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String flag =String.valueOf(new_measure_heart_beat.getText());

                if(flag.equals(HEART)){
                    System.out.println(flag);
                    new_measure_heart_beat.setText("Heart Beat Arrhythmia");

                }else {
                    new_measure_heart_beat.setText("Heart Beat Normal");
                }
            }
        });

        new_measure_sys.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String sys=String.valueOf(new_measure_sys.getText());
                int sysInNum;
                try {
                     sysInNum = Integer.parseInt(sys);
                    }catch (Exception e){
                            sysInNum=0;
                     }
                if(sysInNum<90){
                    System.out.println("inside first if condition");
                    new_measure_sys.setBackgroundResource(R.color.white);
                }else if(sysInNum<110){
                    new_measure_sys.setBackgroundResource(R.color.blue);
                }else if (sysInNum<130){
                    new_measure_sys.setBackgroundResource(R.color.green);
                }else {
                    new_measure_sys.setBackgroundResource(R.color.red);
                }
            }
        });

        new_measure_dia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String sys=String.valueOf(new_measure_dia.getText());
                int sysInNum;
                try {
                    sysInNum = Integer.parseInt(sys);
                }catch (Exception e){
                    sysInNum=0;
                }
                if(sysInNum<50){
                    System.out.println("inside first if condition");
                    new_measure_dia.setBackgroundResource(R.color.white);
                }else if(sysInNum<70){
                    new_measure_dia.setBackgroundResource(R.color.blue);
                }else if (sysInNum<90){
                    new_measure_dia.setBackgroundResource(R.color.green);
                }else {
                    new_measure_dia.setBackgroundResource(R.color.red);
                }
            }
        });

        new_measure_pulse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String sys=String.valueOf(new_measure_pulse.getText());
                int sysInNum;
                try {
                    sysInNum = Integer.parseInt(sys);
                }catch (Exception e){
                    sysInNum=0;
                }
                if(sysInNum<50){
                    System.out.println("inside first if condition");
                    new_measure_pulse.setBackgroundResource(R.color.white);
                }else if(sysInNum<65){
                    new_measure_pulse.setBackgroundResource(R.color.blue);
                }else if (sysInNum<85){
                    new_measure_pulse.setBackgroundResource(R.color.green);
                }else {
                    new_measure_pulse.setBackgroundResource(R.color.red);
                }
            }
        });

// Create a new DatabaseHelper
        mDbHelper = new DatabaseOpenHelper(this);

        // Get the underlying database for writing
        mDB = mDbHelper.getWritableDatabase();


        //clearAll();




    }


    private void updatelbl(){
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        new_measure_date.setText(sdf.format(myCalendar.getTime()));
    }


    // Delete all records
    private void clearAll() {

        mDB.delete(DatabaseOpenHelper.TABLE_NAME, null, null);

    }

    // Insert several artist records
    private void insertArtists(NewData data) {

        ContentValues values = new ContentValues();

        values.put(DatabaseOpenHelper.DIA, data.getDia());
        values.put(DatabaseOpenHelper.SYS, data.getSys());

        values.put(DatabaseOpenHelper.HEART_BEAT,data.getHeart_beat());
        values.put(DatabaseOpenHelper.HAND,data.getHand());
        values.put(DatabaseOpenHelper.NOTE, data.getNote());
        values.put(DatabaseOpenHelper.DATE, data.getDate());
        values.put(DatabaseOpenHelper.TIME,data.getTime());
        values.put(DatabaseOpenHelper.PULSE,data.getPulse());
        mDB.insert(DatabaseOpenHelper.TABLE_NAME, null, values);
    }

    private Cursor readArtists() {
        return mDB.query(DatabaseOpenHelper.TABLE_NAME,
                DatabaseOpenHelper.columns, null, new String[] {}, null, null,
                null);
    }

}
