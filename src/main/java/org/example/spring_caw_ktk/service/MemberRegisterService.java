package org.example.spring_caw_ktk.service;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.example.spring_caw_ktk.dao.MemberDao;
import org.example.spring_caw_ktk.dto.Member;
import org.example.spring_caw_ktk.dto.RegisterRequest;
import org.springframework.stereotype.Service;


@Service
public class MemberRegisterService {
	
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
	this.memberDao = memberDao;
	}
	
	public int regist(RegisterRequest req) throws Exception {
		 Member member = memberDao.selectByUserid(req.getUserid());
		 
		 if (member != null) {
			 throw new Exception("DuplicateMemberException");
		 }
		 Member newMember = new Member(req.getId(), req.getUserid(), req.getPassword(), req.getNickname(), req.getName(), req.getAge(), req.getGender(), Timestamp.valueOf(LocalDateTime.now()));
		 memberDao.insert(newMember);
		 return newMember.getId();
		 }
}
