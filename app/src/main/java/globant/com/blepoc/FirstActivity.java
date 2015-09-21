package globant.com.blepoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import globant.com.blepoc.fragments.FragmentScan;
import globant.com.blepoc.utils.Navigator;

public class FirstActivity extends AppCompatActivity {
    public final static String TAG = FirstActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if(findViewById(R.id.FragmentWrapper) != null){
            if(savedInstanceState == null){
                try {
                    Navigator.screenChange(FirstActivity.this,FragmentScan.class,null);
                } catch (IllegalAccessException e) {
                    Log.e(TAG,"NAVIGATION ACCES FRAGMENT ERROR ["+e+"]");
                } catch (InstantiationException e) {
                    Log.e(TAG,"INSTANTIATION FRAGMENT EXCEPTION ["+e+"]");
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
