package com.rokey.myshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.rokey.myshop.mapper.PmsBrandMapper;
import com.rokey.myshop.model.PmsBrand;
import com.rokey.myshop.model.PmsBrandExample;
import com.rokey.myshop.service.PmsBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/5/12 2:39 下午
 * @description：商品品牌Service实现类
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @Resource
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

}
