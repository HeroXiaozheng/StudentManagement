package com.StuManageSystem.dao;

import java.util.regex.Pattern;

public class StringDAO {

	// �ж��Ƿ��Ǵ�����
	/*
	 * ���������Ƽ����ٶ���� �ж��Ƿ�Ϊ����
	 * 
	 * @param str ������ַ���
	 * 
	 * @return ����������true,���򷵻�false
	 */

	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

}
