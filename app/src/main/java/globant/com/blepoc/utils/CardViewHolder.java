package globant.com.blepoc.utils;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import globant.com.blepoc.R;

/**
 * Created by zadtanikus on 21/09/15.
 */
public class CardViewHolder extends RecyclerView.ViewHolder {

    public CardView mCardView;
    public TextView mTextName;
    public Button   mButton;

    public CardViewHolder(View itemView) {
        super(itemView);
        this.mCardView = (CardView) itemView.findViewById(R.id.cardDevice);
        this.mTextName = (TextView) itemView.findViewById(R.id.deviceTextView);
        this.mButton = (Button) itemView.findViewById(R.id.connectionButton);
    }
}
