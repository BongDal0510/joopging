//package com.team4.joopging.mappers;
//
//import com.team4.joopging.beans.vo.MemberVO;
//import com.team4.joopging.community.vo.CommuVO;
//import com.team4.joopging.mypage.vo.*;
//import org.apache.ibatis.annotations.Mapper;
//
//import java.util.List;
//
//@Mapper
//public interface MypageMapper {
//    /*플로깅 예약 목록*/
//    public List<PloResVO> getPloResList(int memberNum);
//    /*찜 목록*/
//    public List<GoodsLikeListVO> getGoodsLikeList(int memberNum);
//    /*내가 작성한 게시판 목록*/
//    public List<CommuVO> getMyCommuList(int memberNum);
//    /*내가 작성한 1:1문의 목록*/
//    public List<CommuVO> getMyQueList(int memberNum);
//    /*플로깅 예약 취소*/
//    public int deletePloRes(Long ploResNum);
//    /*세션 아이디로 세션 넘 찿기*/
//    public int selectMemberNum(String id);
//    /*회원정보 수정*/
//    public int updateMember(MemberVO vo);
//    /*회원정보 탈퇴*/
//    public int deleteMember(String memberId, String memberPw);
//    /*회원정보 불러오기*/
//    public MemberVO selectMember(String memberId);
//}