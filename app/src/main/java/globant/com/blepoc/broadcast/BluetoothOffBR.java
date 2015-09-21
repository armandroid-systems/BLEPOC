package globant.com.blepoc.broadcast;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by armando.dominguez on 21/09/2015.
 */
public class BluetoothOffBR extends BroadcastReceiver {
    private final static String TAG = BluetoothOffBR.class.getSimpleName();

    private BluetoothAdapter mBtAdapter;

    public BluetoothOffBR(BluetoothAdapter mBtAdapter) {
        this.mBtAdapter = mBtAdapter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String actionString = intent.getAction();

        if(actionString.equals(BluetoothAdapter.ACTION_STATE_CHANGED)){

            if(mBtAdapter.getState() == BluetoothAdapter.STATE_TURNING_OFF){
                Log.d(TAG,"ESTA APAGANDO...");
            }

            if(mBtAdapter.getState() == BluetoothAdapter.STATE_OFF){
                Log.d(TAG,"COÑO QUE SE HA APAGADO...");
            }

        }//END...
    }
}
