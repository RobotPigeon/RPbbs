package com.bbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bbs.domain.vo.FmPlayerVo;
import com.bbs.domain.vo.FmTeamVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FmTeamTotalMapper extends BaseMapper<FmTeamVo> {

    List<FmTeamVo> selectFmTeamVoListWithFmPlayerBasic();

}
