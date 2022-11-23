package com.yuanlrc.service.impl;

import com.yuanlrc.dao.se_business_opportunityDao;
import com.yuanlrc.entity.se_business_opportunity;
import com.yuanlrc.service.se_business_opportunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class se_business_opportunityServiceImpl implements se_business_opportunityService {
    @Resource
    private se_business_opportunityDao se_business_opportunityDao;

    @Override
    public List<se_business_opportunity> queryBizOpportunity(Integer pageCount, Integer currentPage) {
        return se_business_opportunityDao.queryBizOpportunity(pageCount, currentPage);
    }

    @Override
    public List<se_business_opportunity> queryBizOppByKey(String key) {
        return se_business_opportunityDao.queryBizOppByKey(key);
    }

    @Override
    public Integer queryCount() {
        return se_business_opportunityDao.queryCount();
    }

    @Override
    public String addBizOpp(se_business_opportunity se_business_opportunity) {
        int result = se_business_opportunityDao.addBizOpp(se_business_opportunity);
        if (result < 1) {
            return "插入失败";
        }
        return null;
    }

    @Override
    public String editBizOpp(se_business_opportunity se_business_opportunity) {
        int result = se_business_opportunityDao.editBizOpp(se_business_opportunity);
        if (result < 1) {
            return "更新失败";
        }
        return null;
    }

    @Override
    public String deleteBizOpp(Integer id) {
        int result = se_business_opportunityDao.deleteBizOpp(id);
        if (result < 1) {
            return "删除失败";
        }
        return null;
    }
}
