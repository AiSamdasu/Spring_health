package org.example.spring_caw_ktk.service;

import org.example.spring_caw_ktk.dao.MemberDao;
import org.example.spring_caw_ktk.dto.LoginRequest;
import org.example.spring_caw_ktk.dto.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginService {
    private MemberDao memberDao;

    public MemberLoginService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Member login(LoginRequest req) throws Exception {
        // userid로 DB에서 회원 찾기
        Member member = memberDao.selectByUserid(req.getUserid());

        // 회원이 존재하지 않으면 로그인 실패
        if (member == null) {
            throw new Exception("UserNotFoundException");
        }

        // 비밀번호가 다르면 로그인 실패
        if (!member.getPassword().equals(req.getPassword())) {
            throw new Exception("WrongPasswordException");
        }

        // 로그인 성공
        return member;
    }
}
