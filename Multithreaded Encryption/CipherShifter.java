/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that encrypts Password obj password when called an odd number of times
 * and decrypts when called an even number of times.
 * Each call to CipherShifter adds 1 to each character's even ASCII value
 * while subtracting one to each odd ASCII value.
 * Therefore an even number of calls to CipherShifter will decrypt the password.
 * An odd number of calls to CipherShifter will encrypt the password.
 */
public class CipherShifter extends Thread
{
	private Password obj = null;
	
	/*
	 * Constructor for CipherShifter
	 * Will intake given Password Object obj and
	 * store it as this.obj
	 * Parameters: Password obj
	 */
	public CipherShifter(Password obj)
	{
		this.obj = obj;
	}
	
	/* The run method of CipherShifter
	 * Each call to CipherShifter adds 1 to each character's even ASCII value
	 * while subtracting one to each odd ASCII value.
	 * Therefore an even number of calls to CipherShifter will decrypt the password.
	 * An odd number of calls to CipherShifter will encrypt the password.
	 */
	@Override
	public void run() {
		synchronized(obj) {
			char[] pass = obj.array;
			for (int i = 0; i < pass.length; i++) {
				if (((int)pass[i]) % 2 == 0) {
					pass[i] = (char)((int)pass[i] + 1); //Adds 1 to each even ASCII number
				}
				else if (((int)pass[i]) % 2 == 1) {
					pass[i] = (char)((int)pass[i] - 1); //Subtracts 1 from each odd ASCII number
				}
			}
			obj.array = pass;
		}
	}
}