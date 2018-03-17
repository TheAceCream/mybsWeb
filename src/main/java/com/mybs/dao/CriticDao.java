package com.mybs.dao;

import com.mybs.dto.CriticDto;
import com.mybs.po.Critic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by AceCream on 2018/3/16.
 */
@Repository
public interface CriticDao {

    /**
     * 获取评论详情
     * @param id
     * @return
     */
    CriticDto getCriticById(Long id);

    /**
     * 获取评论列表
     * @param criticDto
     * @return
     */
    List<CriticDto> findList(CriticDto criticDto);

    /**
     * 评论数
     * @param criticDto
     * @return
     */
    int countList(CriticDto criticDto);

    /**
     * 添加评论
     * @param critic
     * @return
     */
    Long addCritic(Critic critic);

    /**
     * 修改评论
     * @param critic
     * @return
     */
    int updateCriticById(Critic critic);

}
