package epicgraph.com.mydashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable(){
                public void run(){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(getApplicationContext(),Dash_Board_Activity.class);
                  //  getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                    startActivity(intent);
                    finish();
                }
        }).start();
//        ViewStub stub = (ViewStub) findViewById(R.id.vsHeader);
//        View inflated = stub.inflate();



    }

    protected void onPause() {
        super.onPause();
        //Log.d(getClass().getSimpleName(), "---onPause() method called ---");
    }

    /**
     * When the task resumes (which is also on creation), try and launch LT
     */
    protected void onResume() {
        super.onResume();
        //checkConnection();
        // Log.d(getClass().getSimpleName(), "---onResume() method called ---");

    }


}
