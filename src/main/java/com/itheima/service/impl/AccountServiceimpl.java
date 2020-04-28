package com.itheima.service.impl;

import com.itheima.Dao.IAccountDao;
import com.itheima.Dao.Impl.AccountDaoImpl;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

public class AccountServiceimpl implements IAccountService {
    //private IAccountDao accountDao=new AccountDaoImpl();
  //  private  IAccountDao accountDao=(IAccountDao) BeanFactory.getbean("AccountDao");
    private  IAccountDao accountDao=(IAccountDao)BeanFactory.getbean("AccountDao");
    private int i=1;
        public void saveaccount() {
            System.out.println("账户保存了");
            System.out.println(accountDao);
            accountDao.saveaccount();
            System.out.println(i);
            i++;
        }
}
