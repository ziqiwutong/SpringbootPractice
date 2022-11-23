package com.yuanlrc.dao;

import com.yuanlrc.entity.se_clue;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface se_clueDao {
    List<se_clue> queryClue(Integer pageCount, Integer currentPage);

    List<se_clue> queryClueByKey(String key);

    Integer queryCount();

    Integer addClue(se_clue se_clue);

    Integer editClue(se_clue se_clue);

    Integer deleteClue(Integer id);

    Integer deleteClueStatus(Integer id);
}

