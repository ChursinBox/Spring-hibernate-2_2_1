package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<Car> listCars() {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }

//   @SuppressWarnings("unchecked")
//   @Override
//   public User getUserByCar(String model, int series) {
//      String hql = "From User user where user.car.model = :model and user.car.series = :series";
//      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
//      query.setParameter("model", model).setParameter("series", series);
//      return query.getSingleResult();
//
//   }

}
