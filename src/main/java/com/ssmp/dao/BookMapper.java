package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sheep
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
