package cedroart.lucas.servicelog;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class DelayMessageService extends IntentService {
    public static final String EXTRA_MESSAGE = "mensagem";
    public DelayMessageService() {
        super("DelayMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this){
            try{
                wait(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }

    private void showText(final String text) {
        Log.v("DelayMessageService", "Nossa mensagem é: " + text);
    }
}
