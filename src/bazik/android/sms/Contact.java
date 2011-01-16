package bazik.android.sms;

public class Contact 
{
	private String display_name;
	private String number;
	private String photo;
	
	/**
	 * @param display_name
	 * @param number
	 * @param photo
	 */
	public Contact(String display_name, String number, String photo) {
		super();
		this.display_name = display_name;
		this.number = number;
		this.photo = photo;
	}
	/**
	 * @return the display_name
	 */
	public String getDisplay_name() {
		if(this.display_name == null) return this.number;
		return this.display_name;
	}
	/**
	 * @param display_name the display_name to set
	 */
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
