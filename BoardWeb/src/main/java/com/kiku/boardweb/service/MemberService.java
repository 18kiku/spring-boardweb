package com.kiku.boardweb.service;

import java.util.List;

public interface MemberService {
	MemberDTO login(MemberDTO dto);
	void join(MemberDTO dto);
	void update(MemberDTO dto);
	void delete(MemberDTO dto);
	MemberDTO getMember(MemberDTO dto);
	List<MemberDTO> getMemberList(MemberDTO dto);
	
}
