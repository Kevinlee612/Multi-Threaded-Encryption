# In the respective order, these classes are able to:

*Note:Every encrypt method will only encrypt if not already encrypted.
      Every decrypt method will only encrypt if not already decrypted.

Password:
	- Store the input String password as a char[] array
	- Encrypt the password by taking each character's ASCII value and adding 5
	- Decrypt the password by taking each character's ASCII value and subtracting 5

UserDetails:
	- Store the input Password Object and username.
	  Username will be stored as a username char[] array.
	- Encrypt and Decrypt methods use 2 threads threadUser and threadPass
	- Encrypt the password and username by taking each character's ASCII value and adding 5
	- Decrypt the password and username by taking each character's ASCII value and subtracting 5

*Note: For this assignment's sake, EncrypterUtil, DecrypterUtil, UserEncrypterUtil, UserDecrypterUtil
	execute their encryption/decryption methods 10 times. (Defined by integer timesToLoop variable found
	in their files)

EncrypterUtil:
	- Will encrypt the input password by calling the Password Object's encrypt method

DecrypterUtil
	- Will decrypt the input password by calling the Password Object's encrypt method

UserEncrypterUtil
	- Will encrypt the input UserDetails object's username by
	  taking each character's ASCII value and adding 5

UserDecrypterUtil
	- Will decrypt the input UserDetails object's username by
	  taking each character's ASCII value and subtracting 5

CipherShifter
	- Encrypts Password obj password when called an odd number of times
	  and decrypts when called an even number of times.
 	- Each call to CipherShifter adds 1 to each character's even ASCII value
	  while subtracting one to each odd ASCII value.
 	- Therefore an even number of calls to CipherShifter will decrypt the password.
	- An odd number of calls to CipherShifter will encrypt the password.

## Author

* **Suk Chan Lee** (mailto:scl002@ucsd.edu)


## Acknowledgments

* A thank you to freeCodeCamp 
and Professor James Gappy who taught me Java.
Gratitudes to Professor Zaitsev who is currently teaching me Java as well.
