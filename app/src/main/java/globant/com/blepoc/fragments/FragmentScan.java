package globant.com.blepoc.fragments;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import globant.com.blepoc.R;
import globant.com.blepoc.broadcast.BluetoothOffBR;
import globant.com.blepoc.utils.Constants;
import globant.com.blepoc.utils.Utils;

/**
 * Created by armando.dominguez on 21/09/2015.
 */
public class FragmentScan extends Fragment {

    public static final String TAG = FragmentScan.class.getSimpleName();

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothOffBR mCustomBroadcast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View startView = inflater.inflate(R.layout.fragment_start,container, false);

        return startView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!Utils.isBlueToothReady(getContext())){
            Toast.makeText(getContext(), getContext().getString(R.string.noble_string), Toast.LENGTH_LONG).show();
        }else{
            final BluetoothManager bluetoothManager =
                    (BluetoothManager) getContext().getSystemService(Context.BLUETOOTH_SERVICE);
            mBluetoothAdapter = bluetoothManager.getAdapter();

            // Checks if Bluetooth is supported on the device.
            if (mBluetoothAdapter != null) {
                //Toast.makeText(getContext(), getContext().getString(R.string.noble_string), Toast.LENGTH_LONG).show();
                mCustomBroadcast = new BluetoothOffBR(mBluetoothAdapter);
                getActivity().registerReceiver(mCustomBroadcast,new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));
            }
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if (!mBluetoothAdapter.isEnabled()) {
            if (!mBluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, Constants.REQUEST_ENABLE_BT);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mCustomBroadcast != null) {
            getActivity().unregisterReceiver(mCustomBroadcast);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // User chose not to enable Bluetooth.
        if (requestCode == Constants.REQUEST_ENABLE_BT && resultCode == Activity.RESULT_CANCELED) {
            getActivity().finish();
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
