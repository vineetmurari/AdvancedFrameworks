package com.automate.withme.Utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Decode {

	public static  String decypt_data(String encrypt_data) throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException{
		byte[] decodeBytes = Base64.getDecoder().decode(encrypt_data.getBytes());
		String res = new String(decodeBytes);
		return res;
}
}
