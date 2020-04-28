package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceimpl;

public class Client {
    public static void main(String[] args) {
        //IAccountService as=new AccountServiceimpl();
      for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getbean("accountService");
            System.out.println(as);
            as.saveaccount();
      }

    }
}
