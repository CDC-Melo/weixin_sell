package com.imooc.weixin.service.impl;

import com.imooc.weixin.dataobject.ProductInfo;
import com.imooc.weixin.dto.CartDTO;
import com.imooc.weixin.enums.ProductStatusEnum;
import com.imooc.weixin.enums.ResultEnum;
import com.imooc.weixin.exception.SellException;
import com.imooc.weixin.repository.ProductInfoRepository;
import com.imooc.weixin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList)
    {
        for(CartDTO cartDTO : cartDTOList)
        {
            ProductInfo productInfo = repository.findByProductId(cartDTO.getProductId());
            if(productInfo == null)
            {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList)
    {
        for(CartDTO cartDTO : cartDTOList)
        {
            ProductInfo productInfo = repository.findByProductId(cartDTO.getProductId());
            if(productInfo == null)
            {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0)
            {
                throw  new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    @Override
    public ProductInfo onSale(String productId)
    {
        ProductInfo productInfo = repository.findByProductId(productId);
        if(productInfo == null)
        {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if(productInfo.getProductStatusEnum() == ProductStatusEnum.UP)
        {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId)
    {
        ProductInfo productInfo = repository.findByProductId(productId);
        if(productInfo == null)
        {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        if(productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN)
        {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }
}
