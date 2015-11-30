package l1ig.dev.isig.gomaoil.gui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import l1ig.dev.isig.gomaoil.Design.GomaOilDashboard;
import l1ig.dev.isig.gomaoil.R;

/**
 * Created by Michelo on 07/11/15.
 */
public class AbonneActivity extends GomaOilDashboard{

    private EditText ednomclient,edlongi,edlati,edplaq,edtype;
    private Button btEnreg, btAnnul;
    private String message="";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abonnement_layout);

        ednomclient=(EditText)findViewById(R.id.edNomClient);
        edlongi=(EditText)findViewById(R.id.edLongitude);
        edlati=(EditText)findViewById(R.id.edLatitude);
        edplaq=(EditText)findViewById(R.id.edplaque);
        edtype=(EditText)findViewById(R.id.edTypeVeh);

        btEnreg=(Button)findViewById(R.id.btn_enregistrer);
        btAnnul=(Button)findViewById(R.id.btn_annuler);

        message="La plaque de Mr/Mme "+ ednomclient.getText().toString() + " est de " + edplaq.getText().toString();

        btEnreg.setOnClickListener(new View.OnClickListener(){
            @Override
           public void onClick(View v){
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG)
                        .show();
            }
        });


    }

}
