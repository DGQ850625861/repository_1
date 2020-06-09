package cn.itcast.mongodb_article.Dao;

import cn.itcast.mongodb_article.po.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
//T:对应的实体类 ID：ID的数据类型
public interface CommentRepository extends MongoRepository<Comment,String> {

}
