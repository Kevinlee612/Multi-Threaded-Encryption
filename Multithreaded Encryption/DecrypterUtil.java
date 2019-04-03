/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that extends Thread and is used to decrypt a Password object's
 * password string.
 * Will decrypt only if not yet decrypted.
 */
public class DecrypterUtil extends Thread {
	private Password obj = null;
	private int timesToLoop = 10; //Times to loop decrypting

	/*
	 * Constructor for DecrypterUtil Thread
	 * Parameters: Password obj (Password to be decrypted)
	 */
	public DecrypterUtil(Password obj) {
		this.obj = obj;
	}

	/*
	 * Getter method for Password object
	 * Parameters: N/A
	 * Return: Password obj
	 */
	public Password getPassword() {
		return obj;
	}
	
	/*
	 * Run method of DecrypterUtil
	 * will Decrypt the password if not yet Decrypted by
	 * subtracting 5 to every character's ASCII value.
	 * Parameters: N/A
	 * Return: N/A
	 */
	@Override
	public void run() {
		synchronized(obj.array) {
			for(int i = 0; i < timesToLoop; i++) {
				if (obj.getEncrypted()) {//Check if already decrypted.
					try {
						obj.decrypt(); //Password Object decrypt method
						obj.setEncrypted(false); //No longer encrypted
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}