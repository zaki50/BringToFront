
package org.zakky.bringtofront;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;

public class MyDialogActivity extends Activity {
    private final MyDialogActivity self = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("ちょっといいですか");
        adb.setMessage("BringToFrontActivity を表示したいです");
        adb.setPositiveButton("いーよ", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final Intent intent = new Intent(self, BringToFrontActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
        adb.setNegativeButton("ねーよ", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        adb.create().show();
    }
}
