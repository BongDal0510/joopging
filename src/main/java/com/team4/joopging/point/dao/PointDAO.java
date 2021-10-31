//package com.team4.joopging.point.dao;
//
//import com.team4.joopging.mappers.PointMapper;
//import com.team4.joopging.point.vo.PointVO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//@RequiredArgsConstructor
//public class PointDAO {
//
//    private final PointMapper mapper;
//
//    /*포인트 내역 출력(넘버로)*/
//    public List<PointVO> getPointList(int memberNum){
//        return mapper.getPointList(memberNum);
//    }
//
//    /*포인트 추가*/
//    public boolean addPoint(PointVO vo){
//        return mapper.addPoint(vo) == 1;
//    }
//
//    /*구매 상품 취소()*/
//    public boolean removeOrder(PointVO vo){
//        return mapper.removeOrder(vo)==1;
//    }
//
//    /*구매 취소된 상품 인지 확인 여부*/
//    public boolean checkDeletOrder(int orderNum){return mapper.checkDeletOrder(orderNum)==1;}
//
//}
