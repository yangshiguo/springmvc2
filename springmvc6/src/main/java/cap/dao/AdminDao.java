package cap.dao;

import cap.model.Admin;

import java.util.List;

public interface AdminDao {
    public Admin findAdmin(Admin admin);
    public Admin findAdmin(int id);
    public List<Admin> findPage(int pageNo,int pageSize);
    public  int getTotals();
    public int update(int id,Admin admin);
    public int delete(int id);
    public int insert(Admin admin);
}
