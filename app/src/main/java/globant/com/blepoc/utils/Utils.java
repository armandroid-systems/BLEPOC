package globant.com.blepoc.utils;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanCallback;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;


/**
 * Created by armando.dominguez on 21/09/2015.
 */
public class Utils {

    public static boolean isBlueToothReady(Context ctx){
        if(!ctx.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)){
            return false;
        }else{
            return true;
        }
    }

    @TargetApi(21)
    public static void startScan(boolean flag,
                                 final ScanCallback mCallback,
                                 final BluetoothAdapter mAdapter){

        Handler mHandler = new Handler();

        if(flag){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                   mAdapter.getBluetoothLeScanner().stopScan(mCallback);
                }
            }, Constants.SCAN_PERIOD);
            mAdapter.getBluetoothLeScanner().startScan(mCallback);
        }else{
            mAdapter.getBluetoothLeScanner().stopScan(mCallback);
        }

    }

    public static void startScan(boolean flag,
                                 final BluetoothAdapter.LeScanCallback mCallBack,
                                 final BluetoothAdapter mAdapter){

        Handler mHandler = new Handler();

        if(flag){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mAdapter.stopLeScan(mCallBack);
                }
            }, Constants.SCAN_PERIOD);
            mAdapter.startLeScan(mCallBack);
        }else{
            mAdapter.stopLeScan(mCallBack);
        }

    }

}
