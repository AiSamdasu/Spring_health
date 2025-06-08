package org.example.spring_caw_ktk.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.example.spring_caw_ktk.dao.BmiDao;
import org.example.spring_caw_ktk.dao.MemberDao;
import org.example.spring_caw_ktk.dto.Bmi;
import org.example.spring_caw_ktk.dto.BmiRequest;
import org.example.spring_caw_ktk.dto.LoginRequest;
import org.example.spring_caw_ktk.dto.Member;
import org.example.spring_caw_ktk.dto.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class BmiService {
	private MemberDao memberDao;
	private BmiDao bmiDao;
	
	public BmiService(MemberDao memberDao, BmiDao bmiDao) {
		this.memberDao = memberDao;
		this.bmiDao = bmiDao;
	}
	
	
	public int saveBmi(BmiRequest req) throws Exception {
	    // 회원 정보 확인
	    Member member = memberDao.selectByUserid(req.getUserid());
	    if (member == null) {
	        throw new Exception("해당 사용자가 존재하지 않습니다: " + req.getUserid());
	    }

	    // BMI 계산
	    float heightInMeters = req.getHeight() / 100f;
	    float bmi = req.getWeight() / (heightInMeters * heightInMeters);
	    req.setBmi(bmi); // View에서도 사용 가능하게 저장

	    // BMI 객체 생성 및 저장
	    Bmi newBmi = new Bmi(
	        req.getId(),
	        req.getUserid(),
	        req.getHeight(),
	        req.getWeight(),
	        req.getDate(),
	        bmi, // 계산된 값 저장
	        Timestamp.valueOf(LocalDateTime.now())
	    );
	    bmiDao.insert(newBmi);

	    return newBmi.getId();
	}
	
	public List<Bmi> showBmi(BmiRequest req) throws Exception {
	    // 사용자 존재 여부 확인
	    Member member = memberDao.selectByUserid(req.getUserid());
	    if (member == null) {
	        throw new Exception("해당 사용자가 존재하지 않습니다: " + req.getUserid());
	    }

	    // 해당 사용자 BMI 이력 조회
	    return bmiDao.selectByUserid(req.getUserid());
	}


}
