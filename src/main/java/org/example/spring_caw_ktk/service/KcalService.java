package org.example.spring_caw_ktk.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.example.spring_caw_ktk.dao.KcalDao;
import org.example.spring_caw_ktk.dao.MemberDao;
import org.example.spring_caw_ktk.dto.Kcal;
import org.example.spring_caw_ktk.dto.KcalRequest;
import org.example.spring_caw_ktk.dto.Member;
import org.springframework.stereotype.Service;

@Service
public class KcalService {
	private MemberDao memberDao;
	private KcalDao kcalDao;
	
	public KcalService(MemberDao memberDao, KcalDao kcalDao) {
		this.memberDao = memberDao;
		this.kcalDao = kcalDao;
	}
	
	
	public int saveKcal(KcalRequest req) throws Exception {
	    // 회원 정보 확인
	    Member member = memberDao.selectByUserid(req.getUserid());
	    if (member == null) {
	        throw new Exception("해당 사용자가 존재하지 않습니다: " + req.getUserid());
	    }

	    // BMI 객체 생성 및 저장
	    Kcal newkcal = new Kcal(
	        req.getId(),
	        req.getUserid(),
	        req.getDate(),
	        req.getFood_name(),
	        req.getCalories(),
	        Timestamp.valueOf(LocalDateTime.now()),
	        req.getClassify()
	    );
	    kcalDao.insert(newkcal);

	    return newkcal.getId();
	}
	
	public List<Kcal> showKcal(KcalRequest req) throws Exception {
	    // 사용자 존재 여부 확인
	    Member member = memberDao.selectByUserid(req.getUserid());
	    if (member == null) {
	        throw new Exception("해당 사용자가 존재하지 않습니다: " + req.getUserid());
	    }

	    // 해당 사용자 BMI 이력 조회
	    return kcalDao.selectByUserid(req.getUserid());
	}
}
