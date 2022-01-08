package com.javaex.dao;

import java.util.List;

import com.javaex.vo.PersonVo;

public class TestDao {
	public static void main(String[] args) {
		
		PhoneDao phoneDao = new PhoneDao();
		
		List<PersonVo> list = phoneDao.selectPerson();
		
		for(PersonVo pvo : list) {
			pvo.print();
		}
		
		/*
		PersonVo pvo = phoneDao.getPerson(7);
		
		System.out.println(pvo.toString());
		*/
	}
}
