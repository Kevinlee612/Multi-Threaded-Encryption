/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that that stores the username and a Password object.
 * Contains a boolean encrypted that checks if the username and password is already encrypted.
 * Contains methods encrypt() and decrypt() that executes the encrypt and decrypt.
 */
public class UserDetails {
	
	private char username[]; //Username stored as a char array
	private Password password; //Password object that intakes a String password as a parameter
	private boolean encrypted; //True if encrypted, false if not
	
	/*
	 * Constructor for UserDetails. Instantiates a UserDetails object
	 * with specified strings username and password.
	 * Parameters: String Username, String Password
	 */
	public UserDetails(String username, String password) {
		this.password = new Password(password);
		this.username = username.toCharArray();
		this.encrypted = false;
	}
	
	/*
	 * Getter for Password Object
	 * Parameters: N/A
	 * Return: password
	 */
	public Password getPassword() {
		return password;
	}
	
	/*
	 * Getter for username char[]
	 * Parameters: N/A
	 * Return: username
	 */
	public char[] getUsername(){
		return username;
	}
	
	/*
	 * Setter for encrypted boolean
	 * Parameters: boolean val (value to set boolean)
	 * Return: N/A
	 */
	public void setEncrypted(boolean val) {
		encrypted = val;
	}
	
	/*
	 * Getter for encrypted boolean
	 * Parameters: N/A
	 * Return: boolean encrypted
	 */
	public boolean getEncrypted() {
		return encrypted;
	}
	
	/*
	 * Returns UserDetail object's username and password as a string
	 * Paramters: N/A
	 * Return: String representation of UserDetail's username and password
	 */
	public String getUserDetails()
	{
		String convert = new String(username);
		return convert + "|" + password.showPassword();//combines username and password
	}
	
	/*
	 * Using 2 threads, encrypts the UserDetail's username and password by adding 
	 * 5 to its characters' ASCII values. Will not encrypt if already encrypted.
	 * Parameters: N/A
	 * Return: N/A
	 */
	@SuppressWarnings("static-access")
	public void encrypt() throws InterruptedException
	{
		if (!encrypted) {
			UserEncrypterUtil temp1 = new UserEncrypterUtil(new UserDetails
					(new String(username),password.showPassword()));
			temp1.getUserDetails().setEncrypted(encrypted);
			Thread threadUser = new Thread(temp1);//Checks encryption
			Password placeholder = new Password(password.showPassword());
			placeholder.setEncrypted(encrypted); //Checks encryption
			EncrypterUtil temp2 = new EncrypterUtil(placeholder);
			Thread threadPass = new Thread(temp2);
			threadUser.start(); //Starts Thread
			threadUser.sleep(6);//Sleeps Thread for 6 milliseconds
			threadUser.join();
			threadPass.start();//Starts Thread
			threadPass.join();
			this.username = temp1.getUserDetails().getUsername();
			this.password = temp2.getPassword();
			this.encrypted = true;
		}
	}
	
	/*
	 * Using 2 threads, decrypts the UserDetail's username and password by subtracting 5 to
	 * its characters' ASCII values. Will not decrypt if already decrypted.
	 * Parameters: N/A
	 * Return: N/A
	 */
	@SuppressWarnings("static-access")
	public void decrypt() throws InterruptedException
	{
		if (encrypted) {
			UserDecrypterUtil temp1 = new UserDecrypterUtil(new UserDetails
					(new String(this.username),this.password.showPassword()));
			temp1.getUserDetails().setEncrypted(encrypted);//Checks encryption
			Thread threadUser = new Thread(temp1);
			Password placeholder = new Password(password.showPassword());
			placeholder.setEncrypted(encrypted);//Checks encryption
			DecrypterUtil temp2 = new DecrypterUtil(placeholder);
			Thread threadPass = new Thread(temp2);
			threadUser.start();//Starts Thread
			threadUser.sleep(11);//Sleeps Thread for 11 milliseconds
			threadUser.join();
			threadPass.start();//Starts Thread
			threadPass.join();
			this.username = temp1.getUserDetails().getUsername();
			this.password = temp2.getPassword();
			this.encrypted = false;
		}
	}
}
