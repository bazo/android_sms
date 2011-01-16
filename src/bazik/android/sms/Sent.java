package bazik.android.sms;

import java.util.ArrayList;

import android.app.Activity;
//import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
//import android.net.Uri;
//import android.widget.Toast;

public class Sent extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	
        Layout layout = LayoutManager.getLayout(this, getWindowManager());
        
        Model model = new Model(this, "sent");
        
        try
        {
	        ArrayList<Message> messages = model.getMessages("sent");
	        for (int i = 0; i < messages.size(); i++) { 
	        	Message message = messages.get(i);
	        	layout.addMessage(message);
	        }
        }
        catch(Exception e)
        {
        	//Toast.makeText(getApplicationContext(), "Error: "+ e.toString()+" "+ e.getLocalizedMessage(), Toast.LENGTH_LONG);
        }
        
        this.setContentView(layout.getView());
    }
}