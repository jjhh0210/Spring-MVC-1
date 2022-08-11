package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
hashmap -> 동시성 문제가 고려되지 않기 때문에 실무에선 ConcurrentHashMap, AtomicLong 사용 고려
*/

public class MemberRepository {

    //모든 instance가 공유하는, 공통의 멤버니까 static으로~
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;  //id가 하나씩 증가하는 sequence


    private static final MemberRepository instance = new MemberRepository();    //싱글톤

    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository() {
        //아무나 생성하지 못하게 막음
    }


    //회원 저장
    public Member save(Member member) {
        member.setId(sequence++);
        member.setGrade(2);
        store.put(member.getId(), member);
        return member;
    }

    //회원을 ID로 찾기
    public Member findById(Long id) {
        return store.get(id);

    }

    //회원 list 모두 반환
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //store에 있는 모든 값을 새로운 arrayList에 담아서 넘김
        //arraylist에 값을 넣거나 조작해도 store에 있는 value들을 건들이고 싶지 않기 때문!(store 자체 보호를 위함)
    }

    //store 비우기 (보통 test용)
    public void clearStore() {
        store.clear();
    }
}
