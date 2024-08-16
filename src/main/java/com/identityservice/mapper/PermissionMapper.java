package com.identityservice.mapper;

import org.mapstruct.Mapper;

import com.identityservice.dto.request.PermissionRequest;
import com.identityservice.dto.response.PermissionResponse;
import com.identityservice.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
