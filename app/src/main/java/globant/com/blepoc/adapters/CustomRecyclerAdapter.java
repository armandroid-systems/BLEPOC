package globant.com.blepoc.adapters;

import android.bluetooth.BluetoothDevice;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import globant.com.blepoc.R;
import globant.com.blepoc.fragments.FragmentLEControl;
import globant.com.blepoc.utils.CardViewHolder;
import globant.com.blepoc.utils.Constants;
import globant.com.blepoc.utils.Navigator;

/**
 * Created by zadtanikus on 21/09/15.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private final static String TAG = CustomRecyclerAdapter.class.getSimpleName();

    private ArrayList<BluetoothDevice> leDataSet;
    private FragmentActivity navigatorParam;

    public CustomRecyclerAdapter(ArrayList<BluetoothDevice> leDataSet, FragmentActivity mActivity) {
        this.leDataSet = leDataSet;
        this.navigatorParam = mActivity;
    }

    public CustomRecyclerAdapter(FragmentActivity mActivity) {
        this.leDataSet = new ArrayList<>();
        this.navigatorParam = mActivity;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View cardView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_device_info,viewGroup,false);
        return new CardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, final int position) {
        cardViewHolder.mTextName.setText(leDataSet.get(position).getName());
        cardViewHolder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Navigator.screenChange(navigatorParam, FragmentLEControl.class, leDataSet.get(position), Constants.CONTROL_VIEW);
                } catch (IllegalAccessException e) {
                    Log.e(TAG,"ERROR NAVIGATION ["+e+"]");
                } catch (InstantiationException e) {
                    Log.e(TAG,"ERROR NAVIGATION ["+e+"]");
                }
            }
        });
        Log.d(TAG, "THIS IS THE FUCKING ADRESS ["+leDataSet.get(position).getAddress()+"]");
    }

    @Override
    public int getItemCount() {
        if(this.leDataSet != null){
            return this.leDataSet.size();
        }else{
            return 0;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void addDevice(BluetoothDevice leDevice){
        if(!leDataSet.contains(leDevice)){
            leDataSet.add(leDevice);
            notifyItemInserted(leDataSet.size()-1);
        }
    }
}
