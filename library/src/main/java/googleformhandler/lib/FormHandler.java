package googleformhandler.lib;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class FormHandler {
    private static final MediaType FORM_DATA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    private static final FormHandler instance = new FormHandler();
    private static final OkHttpClient client = new OkHttpClient();

    private Boolean result;
    private FormHandlerListener listener;

    private String URL;
    private List<String> entries;
    private List<String> values;


    private FormHandler() {
        entries = new ArrayList<>();
        values = new ArrayList<>();
    }

    public static FormHandler getInstance() {
        return instance;
    }

    public boolean post(){
        post(URL,entries,values);
        return true;
    }

    public boolean post(String URL, String entry, String value) {
        List<String> entries = new ArrayList<>();
        entries.add(entry);
        List<String> values = new ArrayList<>();
        values.add(value);
        return post(URL, entries, values);
    }


    public boolean post(final String URL, final List<String> entries, final List<String> values) {
        result = true;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String postBody = "";

                try {
                    for (int i = 0; i < entries.size(); i++) {
                        postBody = entries.get(i) + "=" + URLEncoder.encode(values.get(i), "UTF-8");
                    }

                } catch (UnsupportedEncodingException ex) {
                    result = false;
                }

                try {
                    RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
                    Request request = new Request.Builder()
                            .url(URL)
                            .post(body)
                            .build();
                    Response response = client.newCall(request).execute();

                } catch (IOException exception) {
                    result = false;
                }
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (listener != null)
            if (result)
                listener.onPostComplete();
            else listener.onPostError();

        return result;
    }

    public FormHandlerListener getListener() {
        return listener;
    }

    public void setEntries(String... entries){
        Collections.addAll(this.entries, entries);
    }

    public void setValues(String... values){
        Collections.addAll(this.values, values);
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setListener(FormHandlerListener listener) {
        this.listener = listener;
    }

    public interface FormHandlerListener {
        public void onPostComplete();

        public void onPostError();
    }


}
