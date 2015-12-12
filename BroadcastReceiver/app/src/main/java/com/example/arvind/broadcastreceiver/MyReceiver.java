package com.example.arvind.broadcastreceiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


/* concepts: Intent Filter - register this app as capable of receiving sms
 *
 *
 */
/* 1. create subclass of BroadcastReceiver
 * 2. override onReceive
 * 3. get the intent. check if the action field is SMS_RECEIVED
 * 4. create <receiver> in manifest as direct child of <application>
 *
 *
 */
public class MyReceiver extends BroadcastReceiver{

    String action="android.provider.Telephony.SMS_RECEIVED";


    public void onReceive(Context c, Intent i) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = i.getExtras();

        if(i.getAction().equals(action))
        {
            Toast.makeText(c, "SMS Received2", Toast.LENGTH_SHORT).show();
            Log.e("SMS","SMS Received");
            String msg= parseSMS(bundle);
            Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();

        }


    }


    String parseSMS(Bundle bundle)
    {
        try {
            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    return message;
                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);

        }
        return "Unable to parse SMS";

    }

}
