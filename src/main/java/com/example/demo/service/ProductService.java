package com.example.demo.service;

import com.example.demo.Dtos.ProductDetailViewDTO;
import com.example.demo.Dtos.ProductViewDTO;
import com.example.demo.Dtos.SpecificationProductDetailDTO;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SpecificationRepository specificationRepository;

    public List<ProductViewDTO> findAll() {
        var product = productRepository.findAll();
        return product.stream().map(p -> new ProductViewDTO(
                p.getProductID(),
                p.getName(),
                p.getPrice(),
                p.getDiscountDefault(),
                p.getThumbnail(),
                p.getCategoryID().getName()
        )).toList();
    }

    public ProductDetailViewDTO getDetail(String productID) {
        var product = productRepository.findByIdFetchJoin(productID).orElseThrow(() -> new ResourceNotFoundException(String.format("Không tìm thấy sản phẩm %s", productID)));
        var spec = specificationRepository.findById(productID).orElse(null);
        return new ProductDetailViewDTO(
                product.getProductID(),
                product.getName(),
                product.getPrice(),
                product.getDiscountDefault(),
                product.getThumbnail(),
                product.getCategoryID(),
                product.getSubimages(),
                product.getQuanlityStock(),
                product.getQuanlitySell(),
                product.getCreateAt(),
                product.getMinStockLevel(),
                new SpecificationProductDetailDTO(spec.getSpecificationID(), spec.getDimensions(),  spec.getMaterial(), spec.getOriginal(), spec.getStandard(), spec.getProductID())
        );
    }
}
