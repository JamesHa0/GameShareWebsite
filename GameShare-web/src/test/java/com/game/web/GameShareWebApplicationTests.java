package com.game.web;

import com.game.common.core.domain.entity.Order;
import com.game.dao.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GameShareWebApplicationTests {

    @Autowired private GameServiceImpl gameServiceImpl;
    @Autowired private com.game.dao.mapper.OrderMapper orderMapper;

    @Test
    public void insertOrder(){
        Order newOrder = new Order("1", "49520");
        System.out.println("newOrder="+newOrder);
        orderMapper.insert(newOrder);
    }

    @Test
    public void testDownloadFile() {
        // 假设有一个文件名为 "testFile.txt" 存在于 FILE_DOWNLOAD_DIRECTORY 路径下
        String fileName = "testFile.txt";
        Resource resource = gameServiceImpl.downloadGame(fileName);

        assertThat(resource).isNotNull();
        assertThat(resource.exists()).isTrue();
        assertThat(resource.getFilename()).isEqualTo(fileName);
    }

}
