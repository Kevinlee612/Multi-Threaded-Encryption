/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that stores the password in Password Object as a char array.
 * Contains encrypt and decrypt methods for the Password Object.
 * Encrypts by adding 5 to each character's ASCII value.
 * Decrypts by subtracting 5 to each character's ASCII value.
 */
public class Password
{
	char array[]; //password String stored as an char array
	private boolean encrypted; //if password is encrypted
	
	/*
	 * Password Object constructor
	 * Takes password as parameter and stores it as char array
	 * Parameters: String password
	 */
	public Password(String password) {
		array = password.toCharArray();
	}
	
	/*
	 * Getter method of encrypted boolean
	 * Parameters: N/A
	 * Return: boolean encrypted
	 */
	public boolean getEncrypted() {
		return encrypted;
	}
	
	/*
	 * Setter method of encrypted boolean
	 * Parameters: boolean val (value to set boolean)
	 * Return: N/A
	 */
	public void setEncrypted(boolean val) {
		encrypted = val;
	}
	
	/*
	 * Converts char array into its String representation.
	 * Parameters: N/A
	 * Return: String convert (String representation of password)
	 */
	public String showPassword()
	{
		String convert = new String(array);
		return convert;
	}
	
	/*
	 * Encrypts the password by adding 5 to each character's ASCII value.
	 * Parameters: N/A
	 * Return: N/A
	 */
	public void encrypt() throws InterruptedException
	{
		synchronized(array) {
			for (int i = 0;i<array.length;i++) {
				array[i] = (char)(((int)array[i]) + 5);
				//add 5 to every character's ASCII value
			}
			Thread.sleep(5);//Pauses thread by 5 milliseconds.
		}
	}
	
	/*
	 * Decrypts the password by subtracting 5 to each character's ASCII value.
	 * Parameters: N/A
	 * Return: N/A
	 */
	public void decrypt() throws InterruptedException
	{
		synchronized(array) {
			for (int i = 0;i<array.length;i++) {
				array[i] = (char)(((int)array[i]) -5);
				//subtract 5 to every character's ASCII value
			}
		Thread.sleep(10); //Pauses thread by 10 milliseconds.
		}
	}
	
}