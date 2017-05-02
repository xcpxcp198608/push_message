package com.wiatec.push_message.repository;

import com.wiatec.push_message.entities.ManagerInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuchengpeng on 27/04/2017.
 */
@Repository
public class ManagerDao extends BaseDao {

    @Transactional (readOnly = true)
    public boolean check(ManagerInfo managerInfo){
        sql = "select count(*) from manager where username= ? and password = ?";
        int count = jdbcTemplate.queryForObject(sql ,Integer.class , managerInfo.getUserName() , managerInfo.getPassword());
        return count == 1;
    }

    @Transactional (readOnly = true)
    public boolean checkCountryCode(ManagerInfo managerInfo){
        sql = "select countryCode from manager where username= ? and password = ?";
        String countryCode = jdbcTemplate.queryForObject(sql ,String.class , managerInfo.getUserName() , managerInfo.getPassword());
        return "PUSH".equals(countryCode);
    }
}
