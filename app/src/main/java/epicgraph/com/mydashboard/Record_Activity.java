package epicgraph.com.mydashboard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

import epicgraph.com.objects.ListData;
import epicgraph.com.process.GetDataProcess;
import epicgraph.com.sevicehanler.DatabaseOpenHelper;

/**
 * Created by Midhun on 09-09-2015.
 */
public class Record_Activity extends Activity {

    private SQLiteDatabase mDB = null;
    private DatabaseOpenHelper mDbHelper;
    private SimpleCursorAdapter mAdapter;
    ArrayList<ListData> arrayOfUsers;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        // Create a new DatabaseHelper
        mDbHelper = new DatabaseOpenHelper(this);

        // Get the underlying database for writing
        mDB = mDbHelper.getWritableDatabase();

        new GetDataBackgroundTask().execute();
        new GetDataBackgroundTask().execute();
        ViewStub stub = (ViewStub) findViewById(R.id.vsHeader);
        View inflated = stub.inflate();



    }

    private void populateUsersList() {
        // Construct the data source

        // Create the adapter to convert the array to views
        CustomUsersAdapter adapter = new CustomUsersAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
    }


    protected class GetDataBackgroundTask extends AsyncTask<Void, Void, Void> {
        private final ProgressDialog dialog = new ProgressDialog(Record_Activity.this, AlertDialog.THEME_HOLO_LIGHT);

        @Override
        protected Void doInBackground(Void... params) {

            arrayOfUsers = new GetDataProcess().getData(mDB);
            return null;
        }
        protected void onPostExecute(Void result) {
            dialog.dismiss();
            populateUsersList();

        }


    }

}
