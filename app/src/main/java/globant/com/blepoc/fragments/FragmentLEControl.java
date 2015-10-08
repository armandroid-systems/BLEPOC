package globant.com.blepoc.fragments;

;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import globant.com.blepoc.R;
import globant.com.blepoc.utils.Constants;

/**
 * Created by armando.dominguez on 22/09/2015.
 */
public class FragmentLEControl extends Fragment {
    private static final String TAG = FragmentLEControl.class.getSimpleName();

    private TextView mTextView;
    private BluetoothDevice selectedDevice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View controlView = inflater.inflate(R.layout.fragment_control, container, false);

        mTextView = (TextView) controlView.findViewById(R.id.textViewDummy);

        if(getArguments() != null){
            selectedDevice = getArguments().getParcelable(Constants.KEY_PARAMS);

            mTextView.setText(selectedDevice.getAddress()+" | "+selectedDevice.getName());
        }

        return controlView;
    }


}
