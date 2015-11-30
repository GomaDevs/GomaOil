package l1ig.dev.isig.gomaoil.gui;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import l1ig.dev.isig.gomaoil.Design.GomaOilDashboard;
import l1ig.dev.isig.gomaoil.R;

/**
 * Created by Michel on 05/11/2015.
 */
public class sendMessageActivity extends GomaOilDashboard{

    private EditText phoneNumber,msgText;
    private Button sendMesg;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendsms_activity);

        phoneNumber = (EditText)findViewById(R.id.phoneNumber);
        msgText = (EditText)findViewById(R.id.messageText);

        sendMesg = (Button) findViewById(R.id.codeButton);

        sendMesg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(phoneNumber.getText().toString().trim().length() ==0){
                    Toast.makeText(getApplicationContext(), "Please enter a phone number.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(phoneNumber.getText().toString().trim().length() > 13 || phoneNumber.getText().toString().trim().length() < 10){
                    Toast.makeText(getApplicationContext(), "Please enter a valide phone number.", Toast.LENGTH_LONG).show();
                    return;
                }

                if(msgText.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter your message.", Toast.LENGTH_LONG).show();
                    return;
                }

                if(msgText.getText().toString().trim().length() > 160) {
                    sendMultiSMS();
                    //Save in SENT folder
                    saveInSent();
                }
                else {
                    sendSMS();
                    //Save in SENT folder
                    saveInSent();
                }
            }
        }); //end of setOnClickListener()

    } // end of onCreate()


    public void sendSMS(){
        SmsManager smsManager= SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber.getText().toString(), null, msgText.getText().toString(), null, null);

        Toast.makeText(getApplicationContext(), "Message sent!", Toast.LENGTH_SHORT).show();
    }

    public void sendMultiSMS() {

        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> parts = smsManager.divideMessage(msgText.getText().toString());
        smsManager.sendMultipartTextMessage(phoneNumber.getText().toString(), null, parts, null, null);

        Toast.makeText(getApplicationContext(), "Message Sent!", Toast.LENGTH_LONG).show();
    }


    public void saveInSent(){
        ContentValues cv=new ContentValues();
        cv.put("address", phoneNumber.getText().toString());
        cv.put("body", msgText.getText().toString());

        getContentResolver().insert(Uri.parse("content://sms/sent"), cv);

    }

}

