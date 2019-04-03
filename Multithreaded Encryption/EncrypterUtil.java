/**
 * @author Suk Chan Lee A15427567 Sukchan.kevin@gmail.com
 * Class that extends Thread and is used to encrypt a Password object's
 * password string.
 * Will encrypt only if not yet encrypted.
 */
public class EncrypterUtil extends Thread {
	private Password obj = null;
	private int timesToLoop = 10; //Times to loop encrypting

	/*
	 * Constructor for EncrypterUtil Thread
	 * Parameters: Password obj (Password to be encrypted)
	 */
	public EncrypterUtil(Password obj) {
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
	 * Run method of EncrypterUtil
	 * will encrypt the password if not yet encrypted by
	 * adding 5 to every character's ASCII value.
	 * Parameters: N/A
	 * Return: N/A
	 */
	@Override
	public void run() {
		synchronized(obj.array) {
			for(int i = 0; i < timesToLoop; i++) {
				if (!obj.getEncrypted()) { //Check if already encrypted
					try {
						obj.encrypt(); //Password Object encrypt method
						obj.setEncrypted(true);//encrypted
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}
}