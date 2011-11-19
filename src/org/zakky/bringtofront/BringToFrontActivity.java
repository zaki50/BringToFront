
package org.zakky.bringtofront;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class BringToFrontActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 10 seconds later
        final long t = SystemClock.elapsedRealtime() + TimeUnit.SECONDS.toMillis(10L);

        final Intent intent = new Intent(this, MyDialogActivity.class);
        final PendingIntent pi = PendingIntent.getActivity(this, 1, intent, 0);

        final AlarmManager alermManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alermManager.set(AlarmManager.ELAPSED_REALTIME, t, pi);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "onNewIntent() called.", Toast.LENGTH_LONG).show();
    }
}
