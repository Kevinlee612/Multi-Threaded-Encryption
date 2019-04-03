/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that extends Thread and is used to decrypt a UserDetail object's
 * password string and username char[].
 * Will decrypt only if not yet encrypted.
 */
public class UserDecrypterUtil extends Thread {
	private UserDetails obj = null;
	private int timesToLoop = 10; //Times to loop decrypting

	/*
	 * Constructor method for UserDecrypterUtil
	 * Parameters: UserDetails obj (Contains username and password)
	 */
	public UserDecrypterUtil(UserDetails obj) 
	{
		this.obj = obj;
	}
	
	/*
	 * Getter method for UserDetails obj.
	 * Parameters: N/A
	 * Return: UserDetails obj
	 */
	public UserDetails getUserDetails() {
		return obj;
	}

	/*
	 * Run method of UserDecrypterUtil
	 * will Decrypt the UserDetails if not yet Decrypted by
	 * subtracting 5 to every character in the 
	 * username and password ASCII value.
	 * Parameters: N/A
	 * Return: N/A
	 */
	@Override
	public void run() {
			
		synchronized(obj.getUsername()) {
			for(int i = 0; i < timesToLoop; i++) {
				if (obj.getEncrypted()) { //Check if encrypted
					for (int k = 0;k < obj.getUsername().length;k++) {
						obj.getUsername()[k] = (char)(((int)(obj.getUsername()[k])) - 5);
						//subtract 5 to every character's ASCII value
						}
					obj.setEncrypted(false);
				}
				else {
					return; //If not encrypted, return
				}		
			}
		
		}
	}
}