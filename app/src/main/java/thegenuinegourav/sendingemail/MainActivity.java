package thegenuinegourav.sendingemail;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

        //Declare GUI variables to store user data for sending email
        EditText editTextEailTo;
        EditText editTextEmailSubject;
        EditText editTextEmailContent;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //get reference of GUI controls for retrieving user data from screen
            editTextEailTo = (EditText) findViewById(R.id.editTextEmailTo);
            editTextEmailSubject = (EditText) findViewById(R.id.editTextEmailSubject);
            editTextEmailContent = (EditText) findViewById(R.id.editTextEmailContent);
        }

        public void onButtonClickSend(View v)
        {
            //get to, subject and content from the user input and store as string.
            String emailTo 		= editTextEailTo.getText().toString();
            String emailSubject 	= editTextEmailSubject.getText().toString();
            String emailContent 	= editTextEmailContent.getText().toString();

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailTo});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            emailIntent.putExtra(Intent.EXTRA_TEXT, emailContent);
            /// use below 2 commented lines if need to use BCC an CC feature in email
            //emailIntent.putExtra(Intent.EXTRA_CC, new String[]{ to});
            //emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{to});
            ////use below 3 commented lines if need to send attachment
//            emailIntent .setType("image/jpeg");
//            emailIntent .putExtra(Intent.EXTRA_SUBJECT, "My Picture");
//            emailIntent .putExtra(Intent.EXTRA_STREAM, Uri.parse("file://sdcard/captureimage.png"));

            //need this to prompts email client only
            emailIntent.setType("message/rfc822");

            startActivity(Intent.createChooser(emailIntent, "Select an Email Client:"));
        }


    }
