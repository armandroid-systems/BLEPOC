package globant.com.blepoc.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import globant.com.blepoc.R;

/**
 * Created by armando.dominguez on 21/09/2015.
 */
public class Navigator {

    public static void screenChange(FragmentActivity origin, Class fragment, Object param) throws IllegalAccessException, InstantiationException {

        FragmentTransaction transaction = origin.getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(Constants.START_VIEW);
        Fragment mFragment = (Fragment)fragment.newInstance();
        if(param != null){
            Bundle paramWrapper = new Bundle();
            paramWrapper.putParcelable(Constants.KEY_PARAMS, (Parcelable)param);
            mFragment.setArguments(paramWrapper);
        }
        transaction.replace(R.id.FragmentWrapper,mFragment);
        transaction.commit();
    }
}
