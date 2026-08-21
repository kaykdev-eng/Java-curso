package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entites.Department;
import model.entites.Seller;

import java.util.List;

public class Program {
    static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(5);
        seller.setName("Eduarda mozao");
        sellerDao.update(seller);
        System.out.println(seller);

    }
}
