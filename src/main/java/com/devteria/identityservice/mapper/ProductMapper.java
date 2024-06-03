package com.devteria.identityservice.mapper;

import com.devteria.identityservice.dto.request.ProductCreationRequest;
import com.devteria.identityservice.dto.request.ProductUpdateRequest;
import com.devteria.identityservice.dto.request.UserCreationRequest;
import com.devteria.identityservice.dto.request.UserUpdateRequest;
import com.devteria.identityservice.dto.response.ProductResponse;
import com.devteria.identityservice.dto.response.UserResponse;
import com.devteria.identityservice.entity.Product;
import com.devteria.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    //Product toProduct(UserCreationRequest request);

    ProductResponse toProductResponse(Product product);

    Product toProduct(ProductCreationRequest productCreationRequest);
    //void updateUser(@MappingTarget User user, UserUpdateRequest request);
    @Mapping(target = "id", ignore=true)
    void updateProduct(@MappingTarget Product product, ProductUpdateRequest productUpdateRequest);
}
