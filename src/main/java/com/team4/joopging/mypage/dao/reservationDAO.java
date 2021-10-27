package com.team4.joopging.mypage.dao;

import com.team4.joopging.mappers.MypageMapper;
import com.team4.joopging.mypage.vo.reservationVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class reservationDAO {

    private final MypageMapper mapper;

    public void reservationList(){
        mapper.getReservationList();
    }
}
