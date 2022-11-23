package com.yuanlrc.service.impl;

import com.yuanlrc.dao.se_clueDao;
import com.yuanlrc.dao.se_clue_statusDao;
import com.yuanlrc.entity.se_clue;
import com.yuanlrc.entity.se_clue_status;
import com.yuanlrc.service.se_clue_statusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class se_clue_statusServiceImpl implements se_clue_statusService {

    @Resource
    private se_clue_statusDao se_clue_statusDao;

    @Override
    public List<se_clue_status> queryClueStatus(Integer id) {
        return se_clue_statusDao.queryClueStatus(id);
    }

    @Override
    public String addClueStatus(se_clue_status se_clue_status) {
        int result = se_clue_statusDao.addClueStatus(se_clue_status);
        if (result < 1) {
            return "插入失败";
        }
        return null;
    }

    @Override
    public String editClueStatus(se_clue_status se_clue_status) {
        int result = se_clue_statusDao.editClueStatus(se_clue_status);
        if (result < 1) {
            return "更新失败";
        }
        return null;
    }

    @Override
    public se_clue queryClue(Integer clue_id) {
        return se_clue_statusDao.queryClue(clue_id);
    }
}
