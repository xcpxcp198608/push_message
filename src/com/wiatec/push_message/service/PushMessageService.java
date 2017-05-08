package com.wiatec.push_message.service;

import com.wiatec.push_message.entities.PushMessageInfo;
import com.wiatec.push_message.repository.PushMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by xuchengpeng on 27/04/2017.
 */
@Service
public class PushMessageService {

    @Autowired
    private PushMessageDao pushMessageDao;

    @Transactional (readOnly = true)
    public List<PushMessageInfo> getAll(){
        List<PushMessageInfo> pushMessageInfoList = new ArrayList<>();
        pushMessageInfoList.add(pushMessageDao.getAnnouncementMessage().get(0));
        List<PushMessageInfo> pushMessageInfoList1 = pushMessageDao.getAll();
        Collections.reverse(pushMessageInfoList1);
        for(int i = 0 ; i < pushMessageInfoList1.size() ; i ++){
            PushMessageInfo pushMessageInfo = pushMessageInfoList1.get(i);
            if(!"Announcement".equals(pushMessageInfo.getUserName())){
                if(!"Sponsor".equals(pushMessageInfo.getUserName())) {
                    pushMessageInfoList.add(pushMessageInfo);
                    if (i != 0 && i % 5 == 0) {
                        pushMessageInfoList.add(getSponsorMessage());
                    }
                }
            }
        }
        return pushMessageInfoList;
    }

    @Transactional (readOnly = true)
    public PushMessageInfo getSponsorMessage(){
        List<PushMessageInfo> list = pushMessageDao.getSponsorMessage();
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
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
