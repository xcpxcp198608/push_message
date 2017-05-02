package com.wiatec.push_message.service;

import com.wiatec.push_message.entities.PushMessageInfo;
import com.wiatec.push_message.repository.PushMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by xuchengpeng on 27/04/2017.
 */
@Service
public class PushMessageService {

    @Autowired
    private PushMessageDao pushMessageDao;

    @Transactional (readOnly = true)
    public List<PushMessageInfo> getAll(){
        List<PushMessageInfo> pushMessageInfoList = pushMessageDao.getAll();
        Collections.reverse(pushMessageInfoList);
        return pushMessageInfoList;
    }

    @Transactional (readOnly = true)
    public List<PushMessageInfo> getPushMessageByUserName(String userName){
        if(userName ==null){
            return null;
        }else {
            List<PushMessageInfo> pushMessageInfoList = pushMessageDao.getPushMessageByUserName(userName);
            Collections.reverse(pushMessageInfoList);
            return pushMessageInfoList;
        }
    }

    @Transactional (readOnly = true)
    public PushMessageInfo getPushMessageById(int id){
        if(id <= 0){
            return null;
        }else {
            return pushMessageDao.getPushMessageById(id);
        }
    }

    @Transactional
    public void insert (PushMessageInfo pushMessageInfo){
        pushMessageDao.insert(pushMessageInfo);
    }

    @Transactional
    public void update (PushMessageInfo pushMessageInfo){
        pushMessageDao.update(pushMessageInfo);
    }

    @Transactional
    public void delete (int id){
        pushMessageDao.delete(id);
    }
}
