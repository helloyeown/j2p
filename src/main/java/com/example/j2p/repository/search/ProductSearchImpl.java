package com.example.j2p.repository.search;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.j2p.dto.PageRequestDTO;
import com.example.j2p.dto.PageResponseDTO;
import com.example.j2p.dto.ProductListDTO;
import com.example.j2p.entity.Product;
import com.example.j2p.entity.QProduct;
import com.example.j2p.entity.QProductImage;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;

public class ProductSearchImpl extends QuerydslRepositorySupport implements ProductSearch {

    public ProductSearchImpl() {
        super(Product.class);
    }

    @Override
    public PageResponseDTO<ProductListDTO> list(PageRequestDTO requestDTO) {

        QProduct product = QProduct.product;
        QProductImage productImage = QProductImage.productImage;

        JPQLQuery<Product> query = from(product);
        query.leftJoin(product.images, productImage);
        query.where(productImage.ord.eq(0));
        query.where(product.delFlag.eq(Boolean.FALSE));

        int pageNum = requestDTO.getPage() <= 0 ? 0 : requestDTO.getPage() - 1;
        Pageable pageable = PageRequest.of(pageNum, requestDTO.getSize(), Sort.by("pno").descending());

        this.getQuerydsl().applyPagination(pageable, query);

        JPQLQuery<ProductListDTO> dtoQuery = query.select(Projections.bean(ProductListDTO.class, 
            product.pno, product.pname, product.price, productImage.fname));

        List<ProductListDTO> list = dtoQuery.fetch();
        long totalCount = dtoQuery.fetchCount();

        return new PageResponseDTO<>(list, totalCount, requestDTO);

    }
    


}
