package com.identityservice.mapper;

import com.identityservice.dto.request.PermissionRequest;
import com.identityservice.dto.response.PermissionResponse;
import com.identityservice.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
