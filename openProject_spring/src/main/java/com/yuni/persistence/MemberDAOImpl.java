package com.yuni.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.yuni.domain.MemberVO;

@Repository // "@Repository" -> 해당 클래스는 DAO라는 의미
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sqlSession;  //SqlSessionTemplate을 호출함
	
	private static final String namespace = "com.yuni.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace + ".getTime");
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace + ".insertMember", vo);
	}

	@Override
	public MemberVO readMember(String memberId) throws Exception {
		return (MemberVO) sqlSession.selectOne(namespace + ".selectMember", memberId);
	}

	@Override
	public MemberVO readWithPW(String memberId, String memberPwd) throws Exception {
		// 매개변수를 2개 이상 전달해야하니까 Map 객체를 사용한다.
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("memberId", memberId);  //key 값이  myBatis mapper에서   #{memberId} 같아야 값이 들어감 
		paramMap.put("memberPwd", memberPwd);
		return sqlSession.selectOne(namespace + ".selectMember", paramMap);
	}

	@Override
	public List<MemberVO> listAll() throws Exception {
		return sqlSession.selectList(namespace+".selectMemberAll");
	}

	@Override
	public List<MemberVO> listPage(int firstRow, int getRecordCountPerPage) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("firstRow", firstRow);  //key 값이  myBatis mapper에서   #{memberId} 같아야 값이 들어감 
		paramMap.put("getRecordCountPerPage", getRecordCountPerPage);
		
		return sqlSession.selectList(namespace+".listPage", paramMap);
	}

	@Override
	public void updateMember(String oldName, String newName) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("oldName", oldName);  //key 값이  myBatis mapper에서   #{memberId} 같아야 값이 들어감 
		paramMap.put("newName", newName);
		sqlSession.update(namespace+".updateMember", paramMap);
	}

	@Override
	public void deleteMember(String memberId) {
		sqlSession.delete(namespace+".delete", memberId);
		
	}
	
	
}