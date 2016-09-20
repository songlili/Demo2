package com.hrm.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrm.hb.HibernateSessionFactory;
import com.hrm.entity.Users;

public class UsersDao {
	public void addUsers(Users users){	
	    Session session = HibernateSessionFactory.getSession();
	    Transaction tx = session.beginTransaction();
	    session.save(users);
	    tx.commit();
	    HibernateSessionFactory.closeSession();
	}
	public void deleteUsers(Users users){//ɾ����Ա��Ϣ
		Session session = HibernateSessionFactory.getSession();//���Seesion����
		Transaction tx = session.beginTransaction();//��������
		session.delete(users);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	public void updateUsers(Users users){
		Users u = loadUsers(users.getId());//���ظ�ID��Ӧ����Ա��Ϣ
		if (users.getBirthday() != null){
			u.setBirthday(users.getBirthday());//���ó�������
		}
	    if(users.getSex()!=null){
	    	u.setSex(users.getSex());//�����Ա�
	    }
		if (users.getContent() != null) {
			u.setContent(users.getContent());//������Ա���
	    }
		if (users.getIsadmin() != null) {
			u.setIsadmin(users.getIsadmin());//�����Ƿ�Ϊ����Ա
	    }
		if (users.getPassword() != null) {
			u.setPassword(users.getPassword());//���õ�¼����
		}
		if(users.getUsername()!=null)
		{
			u.setUsername(users.getUsername());
		}
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction tx = session.beginTransaction();//��������
		session.update(u);//���¶���
		tx.commit();//�ύ����
		HibernateSessionFactory.closeSession();//�ر�Session����
	}
	public Users loadUsers(int id){//������Ա��Ϣ
		Session session = HibernateSessionFactory.getSession();//���Session����
		Users u = (Users)session.get(Users.class, id);//����ָ��ID��Users����
		return u;
	}
    public boolean loginUsers(Users users){//��Ա��¼
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Users where username = :name and password =:password");
        query.setString("name", users.getUsername());
        query.setString("password", users.getPassword());
        List<Users> list = null;
        list = query.list();
        tx.commit();
        HibernateSessionFactory.closeSession();
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                
                    return true;    
            }
        }
        return false;
    }
	public static List listUser(){//��ʾ��Ա�б�
	    Session session = HibernateSessionFactory.getSession();//���Session����
	    Query query = session.createQuery
	    	("select u from Users as u");//ִ�в�ѯ
	    List list = query.list();//��ò�ѯ�б�
	    HibernateSessionFactory.closeSession();//�ر�Session����
	    return list;		//������Ա�б�
	}
}
