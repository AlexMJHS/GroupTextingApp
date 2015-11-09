package activity.ctec.groupproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.app.Activity;
import android.widget.Toast;
import android.telephony.SmsManager;
import java.util.ArrayList;


public class SendTextActivity extends Activity
{
    private Button sendButton;
    private Button AlexButton;
    private Button JoshButton;
    private EditText phoneNumber;
    private EditText messageText;
    private ArrayList<String> defaultList;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        sendButton = (Button) findViewById(R.id.sendButton);
        AlexButton = (Button) findViewById(R.id.AlexButton);
        JoshButton = (Button) findViewById(R.id.JoshButton);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        messageText = (EditText) findViewById(R.id.messageText);
        defaultList = new ArrayList<String>();

        buildDefaultList();
        setupListeners();
    }

    /**
     *constructing the arrayList defaultList
     */
    private void buildDefaultList()
    {
        this.defaultList.add("hows it going");
        this.defaultList.add("how has your day been");
        this.defaultList.add("Whats up");
    }
    private void setupListeners()
    {
        /**
         * button for the first preprogramed
         */
        AlexButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View currentView) {
                int randomMessage = (int) (Math.random() * 3);
                if (messageText.getText().toString().equals("")) {
                    messageText.setText(defaultList.get(randomMessage));
                }
                try {
                    String contact = "8017181459";
                    String message = messageText.getText().toString();
                    sendSMS(contact, message);

                    Toast.makeText(currentView.getContext(), "message was sent", Toast.LENGTH_SHORT).show();
                } catch (Exception currentException) {
                    Toast.makeText(currentView.getContext(), "message was not sent", Toast.LENGTH_LONG).show();
                    Toast.makeText(currentView.getContext(), currentException.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        /**
         * the second button for the preprogramed number
         */
        JoshButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View currentView) {
                int randomMessage = (int) (Math.random() * 3);
                if (messageText.getText().toString().equals("")) {
                    messageText.setText(defaultList.get(randomMessage));
                }
                try {
                    String contact = "8018820589";
                    String message = messageText.getText().toString();
                    sendSMS(contact, message);

                    Toast.makeText(currentView.getContext(), "message was sent", Toast.LENGTH_SHORT).show();
                } catch (Exception currentException) {
                    Toast.makeText(currentView.getContext(), "message was not sent", Toast.LENGTH_LONG).show();
                    Toast.makeText(currentView.getContext(), currentException.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });



        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View currentView) {
                // sends a random message from the array if none is supplied
                int randomMessage = (int) (Math.random() * 3);
                if (messageText.getText().toString().equals("")) {
                    messageText.setText(defaultList.get(randomMessage));
                }


                try {
                    String contact = phoneNumber.getText().toString();
                    String message = messageText.getText().toString();
                    sendSMS(contact, message);

                    Toast.makeText(currentView.getContext(), "message was sent", Toast.LENGTH_SHORT).show();
                } catch (Exception currentException) {
                    Toast.makeText(currentView.getContext(), "message was not sent", Toast.LENGTH_LONG).show();
                    Toast.makeText(currentView.getContext(), currentException.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

           /**
     * Sends a Text based SMS to a specified number.
     * @param messageAddress the number this app sends a text to.
     *@param messageContent The message being sent.
     */
    private void sendSMS(String messageAddress, String messageContent)
    {
        SmsManager mySMSManager = SmsManager.getDefault();
        mySMSManager.sendTextMessage(messageAddress, null, messageContent,null,null);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}

