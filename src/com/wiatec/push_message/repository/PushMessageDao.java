package com.wiatec.push_message.repository;

import com.wiatec.push_message.entities.PushMessageInfo;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xuchengpeng on 27/04/2017.
 */
@Repository
public class PushMessageDao extends BaseDao {

    @Transactional (readOnly = true)
    public List<PushMessageInfo> getAll(){
        sql = "select * from push_message";
        return jdbcTemplate.query(sql , pushMessageInfoRowMapper);
    }

    @Transactional (readOnly = true)
    public List<PushMessageInfo> getPushMessageByUserName (String userName){
        sql = "select * from push_message where userName=?";
        return jdbcTemplate.query(sql , pushMessageInfoRowMapper , userName);
    }

    @Transactional (readOnly = true)
    public PushMessageInfo getPushMessageById (int id){
        sql = "select * from push_message where id=?";
        return jdbcTemplate.queryForObject(sql , pushMessageInfoRowMapper , id);
    }

    @Transactional
    public void insert (PushMessageInfo pushMessageInfo){
        sql = "insert into push_message (userName , message , img1 , img2) values (:userName ,:message ,:img1 ,:img2)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(pushMessageInfo);
        namedParameterJdbcTemplate.update(sql , sqlParameterSource);
    }

    @Transactional
    public void update (PushMessageInfo pushMessageInfo){
        sql = "update push_message set userName=:userName , message=:message , img1=:img1 , img2=:img2 where id=:id";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(pushMessageInfo);
        namedParameterJdbcTemplate.update(sql , sqlParameterSource);
    }

    @Transactional
    public void delete (int id){
        sql ="delete from push_message where id=?";
        jdbcTemplate.update(sql , id);
    }
}
