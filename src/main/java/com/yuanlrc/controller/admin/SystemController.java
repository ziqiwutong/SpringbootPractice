package com.yuanlrc.controller.admin;

import com.yuanlrc.controller.admin.config.SiteConfig;
import com.yuanlrc.dao.studentDao;
import com.yuanlrc.entity.se_business_opportunity;
import com.yuanlrc.entity.se_clue;
import com.yuanlrc.entity.se_clue_status;
import com.yuanlrc.entity.student;
import com.yuanlrc.service.se_business_opportunityService;
import com.yuanlrc.service.se_clueService;
import com.yuanlrc.service.se_clue_statusService;
import com.yuanlrc.service.studentService;
import com.yuanlrc.utils.PageResp;
import com.yuanlrc.utils.Resp;
import com.yuanlrc.utils.mybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统控制器
 */
@RequestMapping(value="/system")
@Controller
public class SystemController {
    @Resource
    private se_clue_statusService se_clue_statusService;

    @Resource
    private se_business_opportunityService se_business_opportunityService;

    @Resource
    private se_clueService se_clueService;

    @Resource
    private studentService studentService;

    @Value("${spring.datasource.url}")
    private String DatasourceUrl;

    @Autowired
    private SiteConfig siteConfig;

    private Logger log = LoggerFactory.getLogger(SystemController.class);

    @RequestMapping(value="/index")
    public String index(String name, Model model){
        log.info("SiteName=" + siteConfig.getSiteName());

        model.addAttribute("name", siteConfig.getSiteName());
        return "index";
    }

    @RequestMapping(value="/selectDatabase")
    @ResponseBody
    public student select(){
        //获取SqlSession
        SqlSession session = mybatisUtil.getSqlSession();
        //获取dao的代理,创建了studentDao接口的对象
        studentDao dao = session.getMapper(studentDao.class);
        student student = dao.selectById(1006);
        //关闭SqlSession对象
        session.close();

        return student;
    }

    @RequestMapping(value="/selectDatabase2")
    @ResponseBody
    public student select2(){
        student student = studentService.selectById(1006);
        return student;
    }

    @RequestMapping(value="/queryClue")
    @ResponseBody
    public PageResp queryClue(
            @RequestParam(value = "pageCount", required = false) Integer pageCount,
            @RequestParam(value = "currentPage", required = false) Integer currentPage)
    {
        return PageResp.success().setData(
                se_clueService.queryClue(pageCount, pageCount)
        ).setPage(1, 1, se_clueService.queryCount()).setMsg("成功");
    }

    @RequestMapping(value="/addClue")
    @ResponseBody
    public Resp addClue(
            @RequestBody se_clue se_clue
    )
    {
        Date date = new Date(System.currentTimeMillis());
        se_clue clue = new se_clue();
        clue.setClue_name("xiaolaodi");
        clue.setClue_date(date);
        clue.setClue_status("nnn");
        clue.setClue_editor("nnn");
        clue.setClue_discover("nnn");
        clue.setClue_responsible("nnn");
        clue.setBusiness_opporitunity_flag(true);


        if (clue == null) {
            return Resp.error().setMsg("不能为空");
        }
        String result = se_clueService.addClue(clue);
        if (result == null) {
            return Resp.success().setMsg("插入成功");
        } else {
            return Resp.error().setMsg(result);
        }
    }

    @RequestMapping(value="/editClue")
    @ResponseBody
    public Resp editClue(
            @RequestBody se_clue se_clue
    )
    {
        Date date = new Date(System.currentTimeMillis());
        se_clue clue = new se_clue();
        clue.setId(8);
        clue.setClue_name("xiaolaodi");
        clue.setClue_date(date);
        clue.setClue_status("ooo");
        clue.setClue_editor("ooo");
        clue.setClue_discover("ooo");
        clue.setClue_responsible("ooo");
        clue.setBusiness_opporitunity_flag(true);


        if (clue == null) {
            return Resp.error().setMsg("不能为空");
        }
        String result = se_clueService.editClue(clue);
        if (result == null) {
            return Resp.success().setMsg("更新成功");
        } else {
            return Resp.error().setMsg(result);
        }
    }

    @RequestMapping(value="/deleteClue")
    @ResponseBody
    public Resp deleteClue(
            @RequestParam(value = "id") Integer id
    )
    {
        String result = se_clueService.deleteClue(2);
        if (result == null) {
            return Resp.success().setMsg("删除成功");
        } else {
            return Resp.error().setMsg(result);
        }
    }

    @RequestMapping(value="/queryClueByKey")
    @ResponseBody
    public Resp queryClueByKey(
            @RequestParam(value = "key") String key
    )
    {
        List<se_clue> se_clue = se_clueService.queryClueByKey("ang");
        if (se_clue.size() == 0) {
            return Resp.error().setMsg("无数据");
        } else {
            return Resp.success().setData(se_clue).setMsg("成功");
        }
    }

    @RequestMapping(value="/queryBizOpportunity")
    @ResponseBody
    public PageResp queryBizOpportunity()

    {
        return PageResp.success().setData(
                se_business_opportunityService.queryBizOpportunity(2, 1)
        ).setPage(2, 1, se_business_opportunityService.queryCount()).setMsg("成功");
    }

    @RequestMapping(value="/queryBizOppByKey")
    @ResponseBody
    public Resp queryBizOppByKey(

    )
    {
        List<se_business_opportunity> se_business_opportunity = se_business_opportunityService.queryBizOppByKey("xx");
        if (se_business_opportunity.size() == 0) {
            return Resp.error().setMsg("无数据");
        } else {
            return Resp.success().setData(
                    se_business_opportunityService.queryBizOppByKey("xi")
            ).setMsg("成功");
        }
    }

    @RequestMapping(value="/addBizOpp")
    @ResponseBody
    public Resp addBizOpp(

    )
    {
        Date date = new Date(System.currentTimeMillis());
        se_business_opportunity se_business_opportunity = new se_business_opportunity();
        se_business_opportunity.setCustomer_id(1001);
        se_business_opportunity.setBo_date(date);
        se_business_opportunity.setBo_status("qqq");
        se_business_opportunity.setBo_follow_status("aaa_acd_qppowi");
        se_business_opportunity.setBo_editor("qqq");
        se_business_opportunity.setBo_template("qqq");
        se_business_opportunity.setBo_responsible("qqq");
        se_business_opportunity.setBo_amount(new BigDecimal(1000.03));
        se_business_opportunity.setBo_expect_date(date);
        se_business_opportunity.setBo_notes("qqq");

        if (se_business_opportunity == null) {
            return Resp.error().setMsg("不能为空");
        }
        String result = se_business_opportunityService.addBizOpp(se_business_opportunity);
        if (result == null) {
            return Resp.success().setMsg("插入成功");
        } else {
            return Resp.error().setMsg(result);
        }
    }

    @RequestMapping(value="/editBizOpp")
    @ResponseBody
    public Resp editBizOpp(

    )
    {
        Date date = new Date(System.currentTimeMillis());
        se_business_opportunity se_business_opportunity = new se_business_opportunity();
        se_business_opportunity.setId(3);
        se_business_opportunity.setCustomer_id(1001);
        se_business_opportunity.setBo_name("gai");
        se_business_opportunity.setBo_date(date);
        se_business_opportunity.setBo_status("gai");
        se_business_opportunity.setBo_follow_status("aosd_asdasouh_qwqqwq");
        se_business_opportunity.setBo_editor("gai");
        se_business_opportunity.setBo_template("gai");
        se_business_opportunity.setBo_responsible("gai");
        se_business_opportunity.setBo_amount(new BigDecimal(7850.55));
        se_business_opportunity.setBo_expect_date(date);
        se_business_opportunity.setBo_notes("gai");


        if (se_business_opportunity == null) {
            return Resp.error().setMsg("不能为空");
        }
        String result = se_business_opportunityService.editBizOpp(se_business_opportunity);
        if (result == null) {
            return Resp.success().setMsg("更新成功");
        } else {
            return Resp.error().setMsg(result);
        }
    }

    @RequestMapping(value="/deleteBizOpp")
    @ResponseBody
    public Resp deleteBizOpp(

    )
    {
        String result = se_business_opportunityService.deleteBizOpp(1);
        if (result == null) {
            return Resp.success().setMsg("删除成功");
        } else {
            return Resp.error().setMsg(result);
        }
    }

    @RequestMapping(value="/addClueStatus")
    @ResponseBody
    public Resp addClueStatus(

    )
    {
        se_clue_status se_clue_status = new se_clue_status();
        se_clue_status.setClue_id(4);
        se_clue_status.setClue_notes("今天啦啦啦");
        se_clue_status.setClue_follow_status("651");
        se_clue_status.setClue_editor("qwe");


        if (se_clue_status == null) {
            return Resp.error().setMsg("不能为空");
        }
        String result = se_clue_statusService.addClueStatus(se_clue_status);
        if (result == null) {
            return Resp.success().setMsg("插入成功");
        } else {
            return Resp.error().setMsg(result);
        }
    }

    @RequestMapping(value="/editClueStatus")
    @ResponseBody
    public Resp editClueStatus(

    )
    {
        se_clue_status se_clue_status = new se_clue_status();
        se_clue_status.setId(1);
        se_clue_status.setClue_id(2);
        se_clue_status.setClue_notes("我修改了");
        se_clue_status.setClue_follow_status("999");
        se_clue_status.setClue_editor("修改");


        if (se_clue_status == null) {
            return Resp.error().setMsg("不能为空");
        }
        String result = se_clue_statusService.editClueStatus(se_clue_status);
        if (result == null) {
            return Resp.success().setMsg("更新成功");
        } else {
            return Resp.error().setMsg(result);
        }
    }

    @RequestMapping(value="/queryClueStatus")
    @ResponseBody
    public Resp queryClueStatus()

    {
        se_clue se_clue = se_clue_statusService.queryClue(4);
        List<se_clue_status> list = se_clue_statusService.queryClueStatus(4);
        List final_list = new ArrayList();
        final_list.add(se_clue);
        final_list.add(list);
        return Resp.success().setData(
                final_list
        ).setMsg("成功");
    }

}