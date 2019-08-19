package com.peng.lammy.dao.work;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.peng.lammy.domain.po.work.Reagent;

public interface ReagentDao {
	/**
	 * 新增
	 * 
	 * @param gauging
	 */
	void insert(Reagent reagent);

	/**
	 * 查询试剂信息
	 * 
	 * @return
	 */
	List<Reagent> listReagent(Reagent reagent);

	/**
	 * 修改库存
	 */
	@Update("UPDATE LAMMY_REAGENT SET STOCK = #{stock} WHERE ID = #{id}")
	void updateStock(@Param("stock") int stock, @Param("id") Integer id);

	@Select("SELECT ID,REAGENT_NAME,STANDARD,\"TYPE\",STOCK,UNIT FROM LAMMY_REAGENT WHERE ID = #{id}")
	Reagent getReagentById(Integer id);

	void update(Reagent reagent);

	@Delete("UPDATE LAMMY_REAGENT SET IS_DELETE = 1 WHERE ID = #{id}")
	void deleteById(Integer id);

}
