package com.nbclass.util;


import com.nbclass.model.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
/**
 * PasswordHelper进行密码加密
 */
public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator
			= new SecureRandomNumberGenerator();
	//加密方式
	private static String algorithmName = "md5";
	//加密次数
	private static int hashIterations = 2;

	public static void encryptPassword(User user) {
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
		user.setPassword(newPassword);
	}

	public static String getPassword(User user){
		String encryptPassword = new SimpleHash(algorithmName,user.getPassword(),ByteSource.Util.bytes(user.getCredentialsSalt()),hashIterations).toHex();
		return encryptPassword;
	}

	public static void main(String[] args) {
		User user = new User();
		user.setUsername("admin	");
		user.setPassword("123456");
		user.setSalt("sadasd");
		encryptPassword(user);
		System.out.println(user);
	}
}
