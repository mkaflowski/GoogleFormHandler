package googleformhandler;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Locale;

import googleformhandler.lib.FormHandler;

public class SampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FormHandler formHandler = FormHandler.getInstance();
        formHandler.setActionUrl("https://docs.google.com/forms/d/e/1FAIpQLScbGjIM2TeZR1cw1ntkUboMU3NqE1Di6XaCcWwmnPfGeJTUcQ/formResponse");
        formHandler.setEntries("entry.184960424","entry.193071214");
        formHandler.setValues(Locale.getDefault().getLanguage(), String.valueOf("test"));
        formHandler.setListener(new FormHandler.FormHandlerListener() {
            @Override
            public void onPostComplete() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(SampleActivity.this, "OK", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
            }

            @Override
            public void onPostError() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(SampleActivity.this, "Error", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
            }
        });
        formHandler.post();
    }
}
