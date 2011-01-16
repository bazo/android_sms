package bazik.android.sms;

import android.app.Activity;
import android.view.WindowManager;
//import bazik.android.sms.Layout;

public final class LayoutManager 
{
	// static Layout layout;
	
	public static Layout getLayout(Activity context, WindowManager windowManager)
	{
		return new Layout(context, windowManager);
		/*
		try 
		{
			if (LayoutManager.layout == null) LayoutManager.layout = new Layout(context, rotation);
		} 
		catch (NullPointerException e) 
		{
		    System.out.println("Chyba: "+ e.getMessage());
		}
		return LayoutManager.layout;
		*/
	}
}
