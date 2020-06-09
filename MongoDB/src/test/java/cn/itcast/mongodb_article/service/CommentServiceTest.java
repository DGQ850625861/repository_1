package cn.itcast.mongodb_article.service;

import cn.itcast.mongodb_article.Service.CommentService;
import cn.itcast.mongodb_article.po.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: mongodb_aticle
 * @ClassName CommentServiceTest
 * @description:
 * @author: DGQ
 * @create: 2020-06-06 22:45
 * @Version 1.0
 **/


//SpringBoot的Junit集成测试
@RunWith(SpringRunner.class)
//SpringBoot的测试环境初始化，参数：启动类
@SpringBootTest
public class CommentServiceTest {
    //注入Service
    @Autowired
    private CommentService commentService;

    /**
     * 高效点赞
     */
    @Test
    public void testupdateCommentLikenum(){
        commentService.updateCommentLikenum("2");
    }




    /**
     * 保存一个评论
     */
    @Test
    public void testSaveComment(){
        Comment comment=new Comment();
       // comment.setArticleid("100000");
        comment.setId("7");
        comment.setArticleid("100007");
        comment.setContent("study MongoDb day 7");
        //comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("008");
        comment.setNickname("susu");
        comment.setState("1");
        comment.setLikenumm(1111);
        //comment.setReplynum(1212);
        commentService.saveComment(comment);
    }
    /**
     * 查询所有数据
     */
    @Test
    public void testFindAll(){
        List<Comment> list = commentService.findCommentList();
        System.out.println(list);
    }
    /**
     * 测试根据id查询
     */
    @Test
    public void testFindCommentById(){
        Comment comment = commentService.findCommentById("3");
        System.out.println(comment);
    }


}
