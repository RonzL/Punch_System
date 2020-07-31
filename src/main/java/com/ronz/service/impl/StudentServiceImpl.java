package com.ronz.service.impl;

import com.ronz.dao.PunchDao;
import com.ronz.dao.StudentDao;
import com.ronz.domain.Page;
import com.ronz.domain.Punch;
import com.ronz.domain.Student;
import com.ronz.service.StudentService;
import com.ronz.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: punchsystem
 * @author: Ronz
 * @create: 2020-06-03 22:19
 **/
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private PunchDao punchDao;

    String[] status = {"正常","呼吸道可疑症状","未发热且隔离","疑似","确诊","疑似转排除","已治愈"};


    /**
     * 1. 根据学号查询学生信息
     * */
    @Override
    public Student findByStudentNo(int no) {
        return studentDao.findByStudentNo(no);
    }

    /**
     * 2. 分页查询所有学生
     * */
    @Override
    public Page<Student> findAll(int currentPage, int pageSize) {
        List<Student> studentList = studentDao.findAll((currentPage-1)*pageSize, pageSize);
        int count = studentDao.findCount();
        Page<Student> page = new Page<>();
        page.setList(studentList);
        page.setCurrentPage(currentPage);
        page.setPageSize(pageSize);
        page.setTotalCount(count);
        page.setTotalPage(count/pageSize + (count%pageSize==0?0:1));
        return page;
    }

    /**
     * 3. 添加学生到数据库
     * */
    @Override
    public void addStudent(Student student) {

    }

    /**
     * 4. 分页查询出今日未打卡的学生
     * */
    @Override
    public Page<Student> findNoPunch(int currentPage, int pageSize) {
        List<Student> studentList = studentDao.findNoPunch((currentPage - 1) * pageSize, pageSize);
        int count = studentDao.findNoPunchCount();
        Page<Student> page = new Page<>();
        page.setTotalPage(count/pageSize + (count%pageSize==0?0:1));
        page.setTotalCount(count);
        page.setList(studentList);
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        return page;
    }

    /**
     * 查询出所有今日未打卡的学生
     * @return
     */
    @Override
    public List<Student> findAllNoPunch() {
        return studentDao.findAllNoPunch();
    }

    /**
     * 5. 查询出今日身体异常的学生
     * */
    @Override
    public List<Student> findIllStudent() {
        return null;
    }

    /**
     * 6. 查询出指定班级未打卡的学生
     * */
    @Override
    public List<Student> findNoPunchInClass(int classNo) {
        return studentDao.findNoPunchInClass(classNo);
    }

    /**
     * 7. 保存学生的个人信息
     * */
    @Override
    public boolean saveInfo(Student student) {
        return studentDao.saveInfo(student) == 1;
    }

    /**
     * 更新主页个人信息
     * @param email
     */
    @Override
    public void updateInfo(int no, String email) {
        studentDao.updateInfo(no, email);
    }

    /**
     * 8. 修改密码
     * */
    @Override
    public boolean modifyPwd(String password, Integer no) {
        return studentDao.modifyPwd(password, no) == 1;
    }

    /**
     * 9. 上传打卡信息
     * */
    @Override
    public void uploadInfo(Punch punch) {
        studentDao.updateStatus(punch.getNo(), punch.getPhysical_state().equals("0") ? "Y" : "S");
        punch.setPhysical_state(status[Integer.parseInt(punch.getPhysical_state())]);
        punchDao.uploadInfo(punch);
    }

    /**
     * 重置所有学生的打卡状态为 'N'
     */
    @Override
    public void updateAllStatus() {
        studentDao.updateAllStatus();
    }

    /**
     * 向所有的学生发送提醒邮件
     * */
    @Override
    public void sendEmail() {
        // 查询出今日未打卡学生
        List<Student> studentList = findAllNoPunch();
        for (int i = 0; i < studentList.size(); i++){
            String message = "尊敬的" + studentList.get(i).getName() + "同学，您好，现提醒您今日尚未上报身体健康信息，请及时上报。";
            MailUtils.sendMail(studentList.get(i).getEmail(), message, "每日健康信息上报提醒");
        }
    }
}
