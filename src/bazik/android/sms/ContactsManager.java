package bazik.android.sms;

import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;

public class ContactsManager 
{
	public void getPerson(Activity context, String phoneNumber)
	{
		Uri uri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
		ContentResolver resolver = context.getContentResolver();
		Cursor cursor = resolver.query(uri, new String[]{PhoneLookup.DISPLAY_NAME}, phoneNumber, null, phoneNumber);
		for (int i = 0; i < cursor.getCount() - 1; i++) { 
        	cursor.move(1);
        	
        	String id = cursor.getString(cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME));
        	System.out.println(id);
		}
	}
}
