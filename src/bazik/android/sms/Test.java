package bazik.android.sms;

import android.app.Activity;
//import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
//import android.widget.Toast;
//import android.net.Uri;
//import android.widget.Toast;
import bazik.android.sms.LayoutManager;
import bazik.android.sms.Layout;

public class Test extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	
        Layout layout = LayoutManager.getLayout(this, getWindowManager());
        /*
        Model model = new Model("received");
        
        Cursor cur = managedQuery(model.getUri(), 
                model.getColumns(), // Which columns to return
                null, // WHERE clause; which rows to return(all rows)
                null, // WHERE clause selection arguments (none)
                null); // Order-by clause (ascending by name)
        
        //int count = cur.getCount();
        
        for (int i = 0; i < cur.getCount() - 1; i++) { 
        	cur.move(1);
        	String text = cur.getString(cur.getColumnIndex("body"));
        	layout.addItem(text);
        }
        cur.close();
        */
        this.setContentView(layout.getView());
    }
}