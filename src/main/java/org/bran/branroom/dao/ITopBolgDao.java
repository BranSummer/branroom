package org.bran.branroom.dao;

import org.bran.branroom.entity.TopBolgModel;

public interface ITopBolgDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TopBolgModel record);

    int insertSelective(TopBolgModel record);

    TopBolgModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopBolgModel record);

    int updateByPrimaryKey(TopBolgModel record);
}