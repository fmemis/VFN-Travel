package dao;

import javax.persistence.EntityManager;

import jpautils.EntityManagerHelper;
import model.Image;
import model.ImagePK;

public class ImageDAO implements ImageDAOI {
public boolean create(Image image) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		em.persist(image);
		

		em.flush();
		return true;
		
	}
}
