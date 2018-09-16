package cap.service.impl;

import cap.dao.AdminDao;
import cap.model.Admin;
import cap.service.AdminService;
import cap.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private  AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin login(Admin admin) {
        return adminDao.findAdmin(admin);
    }

    @Override
    public PageBean findPage(int pageNo, int pageSize) {
        PageBean pageBean = new PageBean();
        pageBean.setPageNo(pageNo);
        pageBean.setPageSize(5);
        pageBean.setList(adminDao.findPage(pageNo,pageSize));
        pageBean.setTotalRecords(adminDao.getTotals());
        return  pageBean;
    }

    @Override
    public Admin findAdmin(int id) {
        return adminDao.findAdmin(id);
    }

    @Override
    public int update(int id, Admin admin) {
        return adminDao.update(id,admin);
    }

    @Override
    public int delete(int id) {
        return adminDao.delete(id);
    }

    @Override
    public int insert(Admin admin) {
        return adminDao.insert(admin);
    }


}
