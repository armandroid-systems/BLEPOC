package globant.com.blepoc.adapters;

import android.bluetooth.BluetoothDevice;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import globant.com.blepoc.R;
import globant.com.blepoc.utils.CardViewHolder;

/**
 * Created by zadtanikus on 21/09/15.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private final static String TAG = CustomRecyclerAdapter.class.getSimpleName();

    private ArrayList<BluetoothDevice> leDataSet;

    public CustomRecyclerAdapter(ArrayList<BluetoothDevice> leDataSet) {
        this.leDataSet = leDataSet;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View cardView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_device_info,viewGroup,false);
        return new CardViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int position) {
        cardViewHolder.mTextName.setText(leDataSet.get(position).getName());
        Log.d(TAG, "THIS IS THE FUCKING ADRESS ["+leDataSet.get(position).toString()+"]");
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

    private void addDevice(BluetoothDevice leDevice){
        leDataSet.add(leDevice);
        notifyItemInserted(leDataSet.size()-1);
    }
}
