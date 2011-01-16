package bazik.android.sms;

import java.io.InputStream;

import android.net.Uri;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;

public class ContactsManager 
{
	public Contact getContact(Activity context, String phoneNumber)
	{
		String [] projection=new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,
										  ContactsContract.CommonDataKinds.Phone._ID,ContactsContract.CommonDataKinds.Phone.PHOTO_ID,
										  ContactsContract.CommonDataKinds.Photo.PHOTO};
		
		Uri content_uri =  ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
       
		Cursor cursor = context.managedQuery(content_uri, projection, ContactsContract.CommonDataKinds.Phone.NUMBER+"=?", new String[]{phoneNumber}, null); //DISPLAY_NAME+"=?",new String[]{"Jack"},null);
		Contact contact = new Contact(null, phoneNumber, null);
		try
		{
			for (int i = 0; i < cursor.getCount(); i++) 
			{ 
            	cursor.move(1);
            	String display_name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            	String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            	long id = Long.decode(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID)));
            	String photo_id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_ID));
            	String photo = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Photo.PHOTO));
            	
            	//Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, id);
            	//InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(cr, uri);
            	
            	contact = new Contact(display_name, number, photo);
			}
		}
		finally
		{
			cursor.close();
		}
		return contact;
	}
}