package com.ronz.service.impl;

import com.ronz.dao.PunchDao;
import com.ronz.dao.TeacherDao;
import com.ronz.domain.Page;
import com.ronz.domain.Punch;
import com.ronz.domain.Student;
import com.ronz.domain.Teacher;
import com.ronz.service.TeacherService;
import com.ronz.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-09 10:47
 **/

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao dao;

    @Autowired
    private PunchDao punchDao;

    String[] status = {"正常","呼吸道可疑症状","未发热且隔离","疑似","确诊","疑似转排除","已治愈"};

    /**
     * 1. 分页查询所有教师
     * */
    @Override
    public Page<Teacher> findAll(int currentPage, int size) {
        List<Teacher>  teacherList = dao.findAll((currentPage-1)*size, size);
        int count = dao.findCount();
        Page<Teacher> page = new Page<>();
        page.setList(teacherList);
        page.setCurrentPage(currentPage);
        page.setPageSize(size);
        page.setTotalCount(count);
        page.setTotalPage(count/size + (count%size==0?0:1));
        return page;
    }

    /**
     * 2. 分页查询未打卡教师
     * */
    @Override
    public Page<Teacher> findNoPunchByPage(int currentPage, int size) {
        List<Teacher> teacherList = dao.findNoPunchByPage((currentPage - 1) * size, size);
        int count = dao.findNoPunchCount();
        Page<Teacher> page = new Page<>();
        page.setList(teacherList);
        page.setCurrentPage(currentPage);
        page.setPageSize(size);
        page.setTotalCount(count);
        page.setTotalPage(count/size + (count%size==0?0:1));
        return page;
    }

    /**
     * 查询所有未打卡教师
     * @return
     */
    @Override
    public List<Teacher> findAllNoPunch() {
        return dao.findAllNoPunch();
    }

    /**
     * 3. 根据工号查询教师个人信息
     * */
    @Override
    public Teacher findOne(Integer jobNo) {
        return dao.findOne(jobNo);
    }

    /**
     * 4. 给指定老师修改角色
     * */
    @Override
    public boolean addRoles(int jobNo, int[] roles) {
        boolean flag = true;
        // 1. 首先删除教师的所有角色
        dao.deleteRoles(jobNo);
        // 2. 重新添加角色
        for (int role : roles) {
            System.out.println(jobNo);
            flag = flag && (dao.addRoles(jobNo, role) != 0);
        }
        return flag;
    }

    /**
     * 上传教师打卡信息
     * @param punch
     * @return
     */
    @Override
    public void uploadInfo(Punch punch) {
        dao.updateStatus(punch.getNo(), punch.getPhysical_state().equals("0") ? "Y" : "S");
        punch.setPhysical_state(status[Integer.parseInt(punch.getPhysical_state())]);
        punchDao.uploadInfo(punch);
    }

    /**
     * 6. 重置所有教师打卡状态
     */
    @Override
    public void updateAllStatus() {
        dao.updateAllStatus();
    }

    /**
     * 发送邮件提醒老师打卡
     */
    @Override
    public void sendEmail() {
        // 首先查询出所有今天没打卡的老师
        List<Teacher> teacherList = findAllNoPunch();
        for (int i = 0; i < teacherList.size(); i++){
            String message = "尊敬的" + teacherList.get(i).getName() + "老师，您好，现提醒您今日尚未上报身体健康信息，请及时上报。";
            MailUtils.sendMail(teacherList.get(i).getEmail(), message, "每日健康信息上报提醒");
        }
    }

    /**
     * 更新主页个人信息
     * @param no
     * @param email
     */
    @Override
    public void updateInfo(int no, String email) {
        dao.updateInfo(no, email);
    }

    /**
     * 保存老师个人信息
     * @param teacher
     */
    @Override
    public void saveInfo(Teacher teacher) {
        dao.saveInfo(teacher);
    }
}
