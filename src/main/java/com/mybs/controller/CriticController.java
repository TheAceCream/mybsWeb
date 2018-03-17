package com.mybs.controller;

import com.mybs.dto.CriticDto;
import com.mybs.exception.APICode;
import com.mybs.exception.APIException;
import com.mybs.po.Critic;
import com.mybs.pub.BaseResultMap;
import com.mybs.service.CriticService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by AceCream on 2018/3/16.
 */
@Controller
@RequestMapping("critic")
public class CriticController {

    @Resource
    private CriticService criticService;

    /**
     * 添加评论
     * @param critic
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addCritic", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap addCritic(@RequestBody Critic critic, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            Long orderId = criticService.addCritic(critic);
            resultMap.setData(orderId);
            resultMap.setAPICode(APICode.OK);
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }

    /**
     * 评论详情
     * @param orderId
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getCriticDetail", method = RequestMethod.GET, produces = "application/json")
    public BaseResultMap getCriticDetail(@RequestParam("criticId") Long orderId, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            CriticDto criticDto = criticService.getCriticById(orderId);
            resultMap.setData(criticDto);
            resultMap.setAPICode(APICode.OK);
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }


    /**
     * 获取评论列表
     * @param criticDto
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getCriticList", method = RequestMethod.POST, produces = "application/json")
    public BaseResultMap getCriticList(@RequestBody CriticDto criticDto, HttpServletRequest request) {
        BaseResultMap resultMap = new BaseResultMap();
        try {
            List<CriticDto> criticDtoList = criticService.findList(criticDto);
            resultMap.setData(criticDtoList);
            resultMap.setAPICode(APICode.OK);
        } catch (APIException e) {
            resultMap.setCode(e.getCode());
            resultMap.setMsg(e.getMsg());
        } catch (Exception e) {
            resultMap.setAPICode(APICode.RUNTIME_EXECEPTION);
        }
        return resultMap;
    }




}