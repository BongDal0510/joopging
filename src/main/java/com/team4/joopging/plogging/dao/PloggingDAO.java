package com.team4.joopging.plogging.dao;

import com.team4.joopging.event.vo.EventCriteria;
import com.team4.joopging.event.vo.EventVO;
import com.team4.joopging.mappers.EventMapper;
import com.team4.joopging.mappers.PloggingMapper;
import com.team4.joopging.plogging.vo.PloggingCriteria;
import com.team4.joopging.plogging.vo.PloggingVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PloggingDAO {

    private final PloggingMapper ploggingMapper;

    public void register(PloggingVO plogging) { ploggingMapper.insertPlogging(plogging); }

    public PloggingVO get(Long ploggingNum) { return ploggingMapper.readPlogging(ploggingNum); }

//    public boolean modify(PloggingVO plogging) { return ploggingMapper.updatePlogging(plogging) == 1; }

    public boolean remove(Long eventNum) { return ploggingMapper.deleteEvent(eventNum) == 1; }

    public List<PloggingVO> getList(PloggingCriteria ploggingCriteria) { return ploggingMapper.getPloggingList(ploggingCriteria); }

    public int getTotal() { return ploggingMapper.getTotal(); }
}
