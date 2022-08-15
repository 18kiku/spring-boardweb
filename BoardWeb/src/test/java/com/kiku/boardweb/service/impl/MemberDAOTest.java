package com.kiku.boardweb.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kiku.boardweb.service.MemberDTO;

@WebAppConfiguration
@ContextConfiguration(locations = {"/WEB-INF/spring/*-context.xml", "/WEB-INF/spring/appServlet/servlet-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberDAOTest {
	
	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void test() {
		
		MemberDTO member = new MemberDTO();
		member.setId("chiroru");
		member.setPassword("1234");
		member.setName("치로루");
		member.setEmail("chiroru@naver.com");
		memberDAO.join(member);
		
		
		//fail("Not yet implemented");
	}

}
