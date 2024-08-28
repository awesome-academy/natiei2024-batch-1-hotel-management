package com.spring.sample.dao.imp;

import com.spring.sample.dao.ReceiptDAO;
import com.spring.sample.entity.Receipt;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReceiptDAOImp extends GenericDAOImp<Receipt, Long> implements ReceiptDAO {

    private static final Logger logger = LoggerFactory.getLogger(ReceiptDAOImp.class);

    public ReceiptDAOImp() {
        super(Receipt.class);
    }

    @Override
    public List<Receipt> getAllReceipts() {
        logger.info("Fetching all receipts from the database");
        return getHibernateTemplate().execute(new HibernateCallback<List<Receipt>>() {
            @Override
            public List<Receipt> doInHibernate(Session session) throws HibernateException {
                Query<Receipt> query = session.createQuery("from Receipt", Receipt.class);
                return query.getResultList();
            }
        });
    }

    @Override
    public Receipt getReceiptById(Long id) {
        logger.info("Fetching receipt by ID from the database");
        return getHibernateTemplate().get(Receipt.class, id);
    }

    @Override
    public void saveReceipt(Receipt receipt) {
        logger.info("Saving or updating a receipt in the database");
        getHibernateTemplate().saveOrUpdate(receipt);
    }

    @Override
    public void deleteReceipt(Long id) {
        logger.info("Deleting a receipt from the database");
        Receipt receipt = getReceiptById(id);
        if (receipt != null) {
            getHibernateTemplate().delete(receipt);
        }
    }
}