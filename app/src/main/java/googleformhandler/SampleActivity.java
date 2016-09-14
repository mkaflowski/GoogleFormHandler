package googleformhandler;

import android.app.Activity;
import android.os.Bundle;

import googleformhandler.lib.FormHandler;

public class SampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FormHandler formHandler = FormHandler.getInstance();
        formHandler.setURL("https://docs.google.com/forms/d/e/1FAIpQLSckxYU7gI1B8nZzWQvGe7Vk6Lb6Uko1fF8l_ryKL52TVJUzLw/formResponse");
        formHandler.setEntries("entry.714513599");
        formHandler.setValues("One");
        formHandler.post();


//        FormHandler formHandler = FormHandler.getInstance();
//        formHandler.setListener(new FormHandler.FormHandlerListener() {
//            @Override
//            public void onPostComplete() {
//                Log.i("TAG","complete");
//            }
//
//            @Override
//            public void onPostError() {
//                Log.i("TAG","complete");
//            }
//        });
//        formHandler.post("https://docs.google.com/forms/d/e/1FAIpQLSckxYU7gI1B8nZzWQvGe7Vk6Lb6Uko1fF8l_ryKL52TVJUzLw/formResponse", "entry.714513599", getPackageName());
    }
}
