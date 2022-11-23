package com.yuanlrc.dao;

import com.yuanlrc.entity.se_business_opportunity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface se_business_opportunityDao {
    List<se_business_opportunity> queryBizOpportunity(Integer pageCount, Integer currentPage);

    List<se_business_opportunity> queryBizOppByKey(String key);

    Integer queryCount();

    Integer addBizOpp(se_business_opportunity se_business_opportunity);

    Integer editBizOpp(se_business_opportunity se_business_opportunity);

    Integer deleteBizOpp(Integer id);
}
