package com.team4.joopging.community.dao;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mappers.CommuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//원격에서 수정함
@Repository //컴포넌트의 자식 어노테이션. 다오임을 특정지어줌.
@RequiredArgsConstructor //생성자로 주입 --인터페이스에서 구현된 클래스를 찾을 수 없기 때문에 원래는 필드 주입을 해야하지만
//Mapper가 xml에서 구현된 부분도 클래스로 인식해서 실행한다. (정상적인 방법은 아님)
public class CommuDAO {

    /*    @Autowired
        private final BoardMapper mapper;*/
    private final CommuMapper mapper;

    /*게시글 등록*/
    public void registerCommu(CommuVO commu){
        mapper.insertSelectKey_commuBno(commu);
    }
    /*특정 게시물 가져오기*/
    public CommuVO getCommu(Long commuBno){
        return mapper.readCommu(commuBno);
    }
    /*게시글 수정하기*/
    public boolean modifyCommu(CommuVO commu){
        return mapper.updateCommu(commu) == 1;
    }
    /*게시글 삭제*/
    public boolean removeCommu(Long commuBno){
        return mapper.deleteCommu(commuBno) == 1;
    }
    /*전체 목록*/
    public List<CommuVO> getCommuList(Criteria criteria){
        return mapper.getCommuList(criteria);
    }
    /*전체 게시글 수*/
    public int getCommuTotal(Criteria criteria){ return mapper.getCommuTotal(criteria);}
    /*게시글 조회수*/
    public boolean updateCommuViewCnt(Long commuBno){return mapper.updateCommuViewCnt(commuBno) == 1; }
    /*공지글 가져오기*/
    public List<CommuVO> getAnnounceList(int commuBoardStatus) {return mapper.getAnnounceList(commuBoardStatus);}
}
