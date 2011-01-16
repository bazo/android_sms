package bazik.android.sms;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import bazik.android.sms.LayoutManager;
import bazik.android.sms.Layout;

public class Received extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	
        Layout layout = LayoutManager.getLayout(this, getWindowManager());
        
        Model model = new Model(this, "received");
        
        try
        {
	        ArrayList<Message> messages = model.getMessages("received");
	        for (int i = 0; i < messages.size(); i++) { 
	        	Message message = messages.get(i);
	        	layout.addMessage(message);
	        }
        }
        catch(Exception e)
        {
        	Toast.makeText(getApplicationContext(), "Error: "+ e.toString()+" "+ e.getLocalizedMessage(), Toast.LENGTH_LONG);
        }
        this.setContentView(layout.getView());
    }
}