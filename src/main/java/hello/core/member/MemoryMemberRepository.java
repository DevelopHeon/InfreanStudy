package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {
// 회원 저장소 구현체
	
	private static Map<Long, Member> store = new HashMap<>();
	
	@Override
	public void save(Member member) { // 회원 정보 저장
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) { // 아이디 찾는 메소드
		
		return store.get(memberId);
	}

}
