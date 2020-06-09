package cn.itcast.mongodb_article.Service;

import cn.itcast.mongodb_article.Dao.CommentRepository;
import cn.itcast.mongodb_article.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

//修改commentService
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 点赞——高效的方式，自增
     * @param
     */
    public void updateCommentLikenum(String id){
        //查询对象
        Query query=Query.query(Criteria.where("_id").is(id));
        //更新对象
        Update update=new Update();
        //局部更新，相当于$set
        // update.set(key,value)
        //递增$inc
         update.inc("likenumm",1);//这里递增不是增加的1L
        //update.inc("likenumm");
        //参数1：查询对象
        //参数2：更新对象
        //参数3：集合的名字或实体类的类型Comment.class
        mongoTemplate.updateFirst(query,update,"comment");
    }


    /**
     * 保存一个评论
     * @param comment
     */
    public void saveComment(Comment comment){
        //如果需要自定义主键，可以在这里指定主键；如果不指定主键，MongoDB会自动生成主键
        //设置一些默认初始值。。。
        //调用dao
        commentRepository.save(comment);
    }
    /**
     * 更新评论
     * @param comment
     */
    public void updateComment(Comment comment){
        //调用dao
        commentRepository.save(comment);
        //mongoTemplate.upsert(, , );

    }
    /**
     * 根据id删除评论
     * @param id
     */
    public void deleteCommentById(String id){
        //调用dao
        commentRepository.deleteById(id);
    }
    /**
     * 查询所有评论
     * @return
     */

    public List<Comment> findCommentList(){
//调用dao
        return commentRepository.findAll();
    }
    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    public Comment findCommentById(String id){
//调用dao
        return commentRepository.findById(id).get();
    }
}
