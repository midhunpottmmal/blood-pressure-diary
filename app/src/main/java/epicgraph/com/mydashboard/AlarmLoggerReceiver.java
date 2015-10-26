package epicgraph.com.mydashboard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Midhun on 21-09-2015.
 */
public class AlarmLoggerReceiver extends BroadcastReceiver {
    private static final String TAG = "AlarmLoggerReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Logging alarm at:" + DateFormat.getDateTimeInstance().format(new Date()));
    }
}
