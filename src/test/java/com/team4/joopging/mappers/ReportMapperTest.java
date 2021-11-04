package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReportMapperTest {

    @Autowired
    private ReportMapper reportMapper;

    @Test
    public void testInsertReport() {

        CommuVO commu = new CommuVO();
        commu.setCommuTitle("새로 작성한 글 제목");
        commu.setCommuContent("새로 작성한 글 내용");
        commu.setCommuWriter("user009");
        reportMapper.insertCommu(commu);

    }

}
