package globant.com.blepoc.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import globant.com.blepoc.R;

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
}
