package l1ig.dev.isig.gomaoil.Design;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import l1ig.dev.isig.gomaoil.MainActivity;
import l1ig.dev.isig.gomaoil.R;
import l1ig.dev.isig.gomaoil.gui.AbonneActivity;
import l1ig.dev.isig.gomaoil.gui.MapsActivity;
import l1ig.dev.isig.gomaoil.gui.StationActivity;
import l1ig.dev.isig.gomaoil.gui.sendMessageActivity;

/**
 * Created by Michel on 04/11/2015.
 */
public abstract class GomaOilDashboard extends Activity {


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    protected void onDestroy ()
    {
        super.onDestroy();
    }

    protected void onPause ()
    {
        super.onPause();
    }

    protected void onRestart ()
    {
        super.onRestart();
    }

    protected void onResume ()
    {
        super.onResume();
    }

    protected void onStart ()
    {
        super.onStart();
    }

    protected void onStop ()
    {
        super.onStop();
    }

    public void onClickButton(View v){
        int id=v.getId();
        switch (id){
            case R.id.btn_search:
               // Toast.makeText(getApplicationContext(),"Bouton de recherche",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), StationActivity.class));
                break;
            case R.id.btn_abonner:
                startActivity(new Intent(getApplicationContext(),AbonneActivity.class));
                break;
            case R.id.btn_pmt:
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                break;
            case R.id.btn_infos:
                Toast.makeText(getApplicationContext(), "Bouton Information", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),sendMessageActivity.class));
                break;
            default:
                break;
        }
    }


    public void goHome(Context context)
    {
        final Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public void onClickHome (View v)
    {
        goHome(this);
    }

}
