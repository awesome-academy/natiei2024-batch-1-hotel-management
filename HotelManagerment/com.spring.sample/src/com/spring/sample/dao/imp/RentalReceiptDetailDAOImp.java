package com.spring.sample.dao.imp;

import com.spring.sample.dao.RentalReceiptDetailDAO;
import com.spring.sample.entity.RentalReceiptDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalReceiptDetailDAOImp extends GenericDAOImp<RentalReceiptDetail, String> implements RentalReceiptDetailDAO {

    private static final Logger logger = LoggerFactory.getLogger(RentalReceiptDetailDAOImp.class);

    public RentalReceiptDetailDAOImp() {
        super(RentalReceiptDetail.class);
    }

    @Override
    public List<RentalReceiptDetail> getAllRentalReceiptDetails() {
        logger.info("Fetching all rental receipt details from the database");
        return getHibernateTemplate().execute(new HibernateCallback<List<RentalReceiptDetail>>() {
            @Override
            public List<RentalReceiptDetail> doInHibernate(Session session) throws HibernateException {
                Query<RentalReceiptDetail> query = session.createQuery("from RentalReceiptDetail", RentalReceiptDetail.class);
                return query.getResultList();
            }
        });
    }

    @Override
    public RentalReceiptDetail getRentalReceiptDetailById(Integer id) {
        logger.info("Fetching rental receipt detail by ID from the database");
        return getHibernateTemplate().get(RentalReceiptDetail.class, id);
    }

    @Override
    public void saveRentalReceiptDetail(RentalReceiptDetail rentalReceiptDetail) {
        logger.info("Saving or updating a rental receipt detail in the database");
        getHibernateTemplate().saveOrUpdate(rentalReceiptDetail);
    }

    @Override
    public void deleteRentalReceiptDetail(String customerID) {
        logger.info("Deleting a rental receipt detail from the database");
        RentalReceiptDetail rentalReceiptDetail = getRentalReceiptDetailById(customerID);
        if (rentalReceiptDetail != null) {
            getHibernateTemplate().delete(rentalReceiptDetail);
        }
    }
}