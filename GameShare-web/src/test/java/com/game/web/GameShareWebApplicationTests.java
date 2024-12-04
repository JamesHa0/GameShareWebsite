package com.game.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.game.common.core.domain.entity.Comment;
import com.game.common.core.domain.entity.Order;
import com.game.dao.service.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GameShareWebApplicationTests {

    @Autowired private GameServiceImpl gameServiceImpl;
    @Autowired private com.game.dao.mapper.OrderMapper orderMapper;
    @Autowired private com.game.dao.mapper.CommentMapper commentMapper;

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

    //分页查询
    @Test
    public void selectCommentByPage(){
        Page<Comment> page = new Page<>(2, 2);
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gid", "100000001");
        IPage<Comment> iPage = commentMapper.selectPage(page, queryWrapper);
        //总页数
        System.out.println(iPage.getPages());
        //总条数
        System.out.println(iPage.getTotal());
        //每页条数
        System.out.println(iPage.getSize());
        //当前页的结果集
        System.out.println(iPage.getRecords());
        //当前页号
        System.out.println(iPage.getCurrent());
    }

    @Test
    public void test(){
//        List<String> list2 = new ArrayList<String>();
//        list2.add("1");
//        list2.add("2");
//        Iterator<String> iterator = list2.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if ("2".equals(item)) {
//                iterator.remove();
//            }
//        }
//        System.out.println(list2);

        //反例：
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);
    }

}
