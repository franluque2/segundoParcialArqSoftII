package ar.edu.ucc.arqSoft.segundoParcial.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;
import ar.edu.ucc.arqSoft.segundoParcial.model.Comment;

@Repository
public class CommentImpDao extends GenericDaoImp<Comment, Long> implements CommentDao{

}
