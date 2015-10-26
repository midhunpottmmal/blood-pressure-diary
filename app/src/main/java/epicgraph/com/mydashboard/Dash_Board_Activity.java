package epicgraph.com.mydashboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

/**
 * Created by Midhun on 12-09-2015.
 */
public class Dash_Board_Activity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        ViewStub stub = (ViewStub) findViewById(R.id.vsHeader);
        View inflated = stub.inflate();

        final Button main_btn_add = (Button) findViewById(R.id.main_btn_add);
        final Button main_btn_record = (Button) findViewById(R.id.main_btn_record);
        final Button main_btn_graph = (Button) findViewById(R.id.main_btn_graph);
        final Button main_btn_reminder = (Button) findViewById(R.id.main_btn_reminder);
        final Button main_btn_distribution= (Button) findViewById(R.id.main_btn_distribution);
        final Button main_btn_settings = (Button) findViewById(R.id.main_btn_settings);

        main_btn_add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Add_Data_Activity.class);
                startActivity(intent);
            }
        });

        main_btn_record.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),Record_Activity.class);
                startActivity(intent);
            }
        });

        main_btn_distribution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Distribution.class);
                startActivity(intent);
            }
        });


        main_btn_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Graph_Activity.class);
                startActivity(intent);
            }
        });

        main_btn_reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Remider.class);
                startActivity(intent);
            }
        });
        main_btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NewMeasure.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onStop() {


        super.onStop();
    }

    @Override
    protected void onDestroy() {


        super.onDestroy();
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Dash_Board_Activity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
