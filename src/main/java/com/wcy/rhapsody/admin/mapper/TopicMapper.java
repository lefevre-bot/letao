package com.wcy.rhapsody.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcy.rhapsody.admin.modules.entity.Topic;
import com.wcy.rhapsody.admin.modules.vo.TopicVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 话题，议题
 *
 * @author Yeeep 2020/11/7
 */
@Mapper
public interface TopicMapper extends BaseMapper<Topic> {
    /**
     * 分页查询首页话题列表
     * <p>
     * // TODO: 2020/11/7 SQL 优化
     *
     * @param page
     * @param tab
     * @return
     */
    Page<TopicVO> selectListAndPage(@Param("page") Page<TopicVO> page, @Param("tab") String tab);

    /**
     * 获取详情页推荐
     *
     * @param id
     * @return
     */
    @Select("select * from topic t where t.id != #{id} order by rand(),t.view limit 10")
    List<Topic> selectRecommend(@Param("id") String id);

    /**
     * 查询指定类目
     *
     * @param id
     * @param topicVOPage
     * @return
     */
    Page<TopicVO> selectTopicsByCategory(@Param("id") Integer id, @Param("topicVOPage") Page<TopicVO> topicVOPage);
}
