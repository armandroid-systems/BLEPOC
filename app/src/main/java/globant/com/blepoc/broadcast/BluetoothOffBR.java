package globant.com.blepoc.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by armando.dominguez on 21/09/2015.
 */
public class BluetoothOffBR extends BroadcastReceiver {
    private final static String TAG = BluetoothOffBR.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"COÑO HE RECIBIDO UNA TRANSMISION :O ");
    }
}
