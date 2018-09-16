package cap.dao.impl;

import cap.dao.AdminDao;
import cap.model.Admin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository(value = "adminDao")
public class AdminDaoImpl implements AdminDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Admin findAdmin(Admin admin) {
        String sql = "select username,password from admin where username=? and password=? limit 0,1";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{admin.getUsername(), admin.getPassword()}, ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));
    }

    @Override
    public Admin findAdmin(int id) {
        String sql = "select * from admin where id= ? limit 0,1";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{id}, ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));
    }

    @Override
    public List<Admin> findPage(int pageNo, int pageSize) {
        String sql = "select * from admin limit ?,?";
        int start = (pageNo - 1) * pageSize;
        return this.jdbcTemplate.query(sql, new Object[]{start, pageSize}, ParameterizedBeanPropertyRowMapper.newInstance(Admin.class));
    }

    @Override
    public int getTotals() {
        String sql = "select count(*) from admin";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int update(int id, Admin admin) {
        String sql = "update admin set username = ? ,password=? where id = ?";
        return jdbcTemplate.update(sql,admin.getUsername(),admin.getPassword(),id);
    }

    @Override
    public int delete(int id) {
        String sql = "delete from admin where id = ?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int insert(Admin admin) {
        String sql = "insert into admin(username,password) values(?,?)";
        return jdbcTemplate.update(sql,admin.getUsername(),admin.getPassword());
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
