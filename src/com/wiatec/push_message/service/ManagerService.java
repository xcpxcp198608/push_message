package com.wiatec.push_message.service;

import com.wiatec.push_message.entities.ManagerInfo;
import com.wiatec.push_message.repository.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * Created by xuchengpeng on 27/04/2017.
 */
@Service
public class ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Transactional(readOnly = true)
    public boolean login (ManagerInfo managerInfo , HttpSession session){
        if(managerDao.check(managerInfo) && managerDao.checkCountryCode(managerInfo)){
            session.setAttribute("userName", managerInfo.getUserName());
            return true;
        }else {
            return false;
        }
    }

}
