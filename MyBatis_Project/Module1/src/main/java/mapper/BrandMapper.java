package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
//    @Select("select * from tb_brand")//简单的sql语句可以使用注解，复杂的使用配置文件
    List<Brand> selectAll();

    Brand selectById(int id);

//    条件查询，接收参数的三种方式：
//    1.散装参数：需要使用@Param("sql中参数的占位符名称")
//    2.实体类封装参数
//    3.map集合

    //    List<Brand> selectByCondition(@Param("status")int status,
//                                  @Param("companyName")String companyName,
//                                  @Param("brandName")String brandName);
//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    List<Brand> selectBySingleCondition(Map map);

    void add(Brand brand);

    void updateAll(Brand brand);

    void updateSingle(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);//使用@Param注解可以指定数组名称
}
