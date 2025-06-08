package org.example.spring_caw_ktk.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.example.spring_caw_ktk.dao.ExerciseDao;
import org.example.spring_caw_ktk.dao.KcalDao;
import org.example.spring_caw_ktk.dao.MemberDao;
import org.example.spring_caw_ktk.dto.Exercise;
import org.example.spring_caw_ktk.dto.ExerciseRequest;
import org.example.spring_caw_ktk.dto.Kcal;
import org.example.spring_caw_ktk.dto.KcalRequest;
import org.example.spring_caw_ktk.dto.Member;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
	private MemberDao memberDao;
	private ExerciseDao exerciseDao;
	
	public ExerciseService(MemberDao memberDao, ExerciseDao exerciseDao) {
		this.memberDao = memberDao;
		this.exerciseDao = exerciseDao;
	}
	
	
	public int saveExercise(ExerciseRequest req) throws Exception {
	    // 회원 정보 확인
	    Member member = memberDao.selectByUserid(req.getUserid());
	    if (member == null) {
	        throw new Exception("해당 사용자가 존재하지 않습니다: " + req.getUserid());
	    }

	    // BMI 객체 생성 및 저장
	    Exercise newExercise = new Exercise(
	        req.getId(),
	        req.getUserid(),
	        req.getDate(),
	        req.getExercise_name(),
	        req.getCalories(),
	        Timestamp.valueOf(LocalDateTime.now())
	    );
	    exerciseDao.insert(newExercise);

	    return newExercise.getId();
	}
	
	public List<Exercise> showExercise(ExerciseRequest req) throws Exception {
	    // 사용자 존재 여부 확인
	    Member member = memberDao.selectByUserid(req.getUserid());
	    if (member == null) {
	        throw new Exception("해당 사용자가 존재하지 않습니다: " + req.getUserid());
	    }

	    // 해당 사용자 BMI 이력 조회
	    return exerciseDao.selectByUserid(req.getUserid());
	}
}
