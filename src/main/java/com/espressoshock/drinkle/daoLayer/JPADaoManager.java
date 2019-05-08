package com.espressoshock.drinkle.daoLayer;

import com.espressoshock.drinkle.daoLayer.entities.AccountDAL;
import com.espressoshock.drinkle.daoLayer.entities.JPAAAccountDal;
import com.espressoshock.drinkle.daoLayer.entities.JPAAccountDao;
import com.espressoshock.drinkle.models.Account;
import com.espressoshock.drinkle.models.Person;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.security.MessageDigest;

public class JPADaoManager {
    private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("drinklePU");
    private JPAAAccountDal accountDao;

    public JPADaoManager() {
    }

    public Account login(Account account){
        this.accountDao = new JPAAAccountDal(this.EMF.createEntityManager());
        if(true){
            AccountDAL result = this.accountDao.getByKey(account.getEmail());
            /********* ACCOUNT MATCH  */
            if(result != null && compareMD5(account.getPassword(), result.getPassword()))
                System.out.println("logged: "+result.getPassword());
            else
                System.out.println("error");
        }
        return null;
    }

    private boolean compareMD5(String toEncode, String encoded){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(toEncode.getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<byteData.length;i++)
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

            System.out.println(sb.toString());

            if(encoded.equals(sb.toString()))
                return true;

        }catch (Exception e){e.printStackTrace();}

        return false;
    }
}
