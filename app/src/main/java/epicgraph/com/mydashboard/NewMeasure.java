package epicgraph.com.mydashboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

/**
 * Created by Midhun on 21-09-2015.
 */
public class NewMeasure extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_messure);
        ViewStub stub = (ViewStub) findViewById(R.id.vsHeader);
        View inflated = stub.inflate();
    }
}
