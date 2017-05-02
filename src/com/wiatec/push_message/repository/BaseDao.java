package com.wiatec.push_message.repository;

import com.wiatec.push_message.ApplicationContextHelper;
import com.wiatec.push_message.entities.ManagerInfo;
import com.wiatec.push_message.entities.PushMessageInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Created by xuchengpeng on 27/04/2017.
 */
public class BaseDao {

    protected JdbcTemplate jdbcTemplate;
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    protected String sql = "";
    protected RowMapper<PushMessageInfo> pushMessageInfoRowMapper;
    protected RowMapper<ManagerInfo> managerInfoRowMapper;

    public BaseDao (){
        ApplicationContext applicationContext = ApplicationContextHelper.getApplicationContext();
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) applicationContext.getBean("namedParameterJdbcTemplate");
        pushMessageInfoRowMapper = new BeanPropertyRowMapper<>(PushMessageInfo.class);
        managerInfoRowMapper = new BeanPropertyRowMapper<>(ManagerInfo.class);
    }
}
