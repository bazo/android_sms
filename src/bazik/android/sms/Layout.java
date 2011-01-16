package bazik.android.sms;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Layout 
{
	private ScrollView view;
	private TableLayout innerLayout;
	private Activity context;
	private WindowManager windowManager;
	
	public Layout(Activity context, WindowManager windowManager)
	{
		this.context = context;
		this.view = new ScrollView(context);
		this.innerLayout = new TableLayout(context);
		this.windowManager = windowManager;
		
		int rotation = windowManager.getDefaultDisplay().getRotation();
		int orientation = 0;
		
		switch (rotation) {
			case 0:
				orientation = TableLayout.VERTICAL;
			break;

			default:
				orientation = TableLayout.HORIZONTAL;
			break;
		}
		
		this.innerLayout.setOrientation(orientation);
		this.view.addView(this.innerLayout);
	}

	/**
	 * @return the view
	 */
	public ScrollView getView() 
	{
		return view;
	}
	
	public void addMessage(Message message)
	{
		TableRow row = new TableRow(this.context);
		ImageView picture = new ImageView(this.context);
		picture.setBackgroundResource(R.drawable.people);
		row.addView(picture, 48, 48);
		
		TableLayout innerTable = new TableLayout(this.context);
		
		TableRow header = new TableRow(this.context);
		TableRow text = new TableRow(this.context);

		TextView headerText = new TextView(this.context);
		headerText.setWidth(this.windowManager.getDefaultDisplay().getWidth() - 60);
		
		headerText.setText(message.getAddress());
		
		TextView text_span = new TextView(this.context);
		text_span.setWidth(this.windowManager.getDefaultDisplay().getWidth() - 60);
		text_span.setText(message.getBody());
		text_span.setClickable(true);
		text_span.setOnTouchListener(touchListener);
		
		header.addView(headerText);
		text.addView(text_span);
		
		innerTable.addView(header);
		innerTable.addView(text);
		
		row.addView(innerTable);
		
		this.innerLayout.addView(row);
	}
	
	private OnTouchListener touchListener = new OnTouchListener() 
	{
	    public boolean onTouch(View v, MotionEvent event) 
	    {
	    	v.setBackgroundColor(25);
	    	return false;
	    }
	};
	
}
