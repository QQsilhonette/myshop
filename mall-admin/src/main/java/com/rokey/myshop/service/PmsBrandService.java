package com.rokey.myshop.service;

import com.rokey.myshop.model.PmsBrand;

import java.util.List;

/**
 * 商品品牌Service
 */
public interface PmsBrandService {
    /**
     * 获取所有品牌
     */
    List<PmsBrand> listAllBrand();

    /**
     * 创建品牌
     */
    int createBrand(PmsBrand brand);

    /**
     * 修改品牌
     */
    int updateBrand(Long id, PmsBrand brand);

    /**
     * 删除品牌
     */
    int deleteBrand(Long id);

    /**
     * 分页查询品牌
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 获取品牌
     */
    PmsBrand getBrand(Long id);
}
