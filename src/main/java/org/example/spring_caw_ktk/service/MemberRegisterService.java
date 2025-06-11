package org.example.spring_caw_ktk.service;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.example.spring_caw_ktk.dao.MemberDao;
import org.example.spring_caw_ktk.dto.Member;
import org.example.spring_caw_ktk.dto.RegisterRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MemberRegisterService {
	
	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
	this.memberDao = memberDao;
	}
	
	public int regist(RegisterRequest req) throws Exception {
		 Member memberID = memberDao.selectByUserid(req.getUserid());
		 Member memberNickname = memberDao.selectByNickname(req.getNickname());
		 
		 // 중복 아이디 
		 if (memberID != null) {
			 throw new Exception("DuplicateUserID");
		 }
		 
		 // 중복 닉네임
		 if (memberNickname != null) {
		    throw new Exception("DuplicateNickname");
		 }
		
		 Member newMember = new Member(req.getId(), req.getUserid(), req.getPassword(), req.getNickname(), req.getName(), req.getAge(), req.getGender(), Timestamp.valueOf(LocalDateTime.now()));
		 memberDao.insert(newMember);
		 return newMember.getId();
		 }
}
