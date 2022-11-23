package com.yuanlrc.service;

import com.yuanlrc.entity.se_business_opportunity;

import java.util.List;

public interface se_business_opportunityService {
    List<se_business_opportunity> queryBizOpportunity(Integer pageCount, Integer currentPage);

    List<se_business_opportunity> queryBizOppByKey(String key);

    Integer queryCount();

    String addBizOpp(se_business_opportunity se_business_opportunity);

    String editBizOpp(se_business_opportunity se_business_opportunity);

    String deleteBizOpp(Integer id);
}
