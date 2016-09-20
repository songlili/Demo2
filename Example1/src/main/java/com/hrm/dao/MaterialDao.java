package com.hrm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hrm.hb.HibernateSessionFactory;
import com.hrm.entity.Material;
public class MaterialDao {
	public void addMaterial(Material m){	
	    Session session = HibernateSessionFactory.getSession();
	    Transaction tx = session.beginTransaction();
	    session.save(m);
	    tx.commit();
	    HibernateSessionFactory.closeSession();
	}
	public void deleteMaterial(Material m){//ɾ����Ա��Ϣ
		Session session = HibernateSessionFactory.getSession();//���Seesion����
		Transaction tx = session.beginTransaction();//��������
		session.delete(m);
		tx.commit();
		HibernateSessionFactory.closeSession();
	}
	public void updateMaterial(Material m){
		Material u = loadMaterial(m.getId());//���ظ�ID��Ӧ����Ա��Ϣ
		if (m.getDate() != null){
			u.setDate(m.getDate());//���ó�������
		}
	    if(m.getDescription()!=null){
	    	u.setDescription(m.getDescription());;//�����Ա�
	    }
		if (m.getFile()!=null) {
			u.setFile(m.getFile());//������Ա���
	    }
		if (m.getKeyword()!= null) {
			u.setKeyword(m.getKeyword());//�����Ƿ�Ϊ����Ա
	    }	
		Session session = HibernateSessionFactory.getSession();//���Session����
		Transaction tx = session.beginTransaction();//��������
		session.update(u);//���¶���
		tx.commit();//�ύ����
		HibernateSessionFactory.closeSession();//�ر�Session����
	}
	public Material loadMaterial(int id){//������Ա��Ϣ
		Session session = HibernateSessionFactory.getSession();//���Session����
		Material u = (Material)session.get(Material.class, id);//����ָ��ID��Users����
		return u;
	}
   
	public  static List<Material> listMaterial(){//��ʾ��Ա�б�
	    Session session = HibernateSessionFactory.getSession();//���Session����
	    Query query = session.createQuery
	    	("select u from Material as u");//ִ�в�ѯ
	    List<Material> list = query.list();//��ò�ѯ�б�
	    HibernateSessionFactory.closeSession();//�ر�Session����
	    return list;		//������Ա�б�
	}
}
