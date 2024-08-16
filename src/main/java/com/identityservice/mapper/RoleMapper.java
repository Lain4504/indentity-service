package com.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.identityservice.dto.request.RoleRequest;
import com.identityservice.dto.response.RoleResponse;
import com.identityservice.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
