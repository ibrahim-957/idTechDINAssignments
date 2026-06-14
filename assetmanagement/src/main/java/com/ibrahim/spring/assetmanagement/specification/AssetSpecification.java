package com.ibrahim.spring.assetmanagement.specification;

import com.ibrahim.spring.assetmanagement.entity.Asset;
import com.ibrahim.spring.assetmanagement.model.enums.AssetStatus;
import com.ibrahim.spring.assetmanagement.model.enums.AssetType;
import org.springframework.data.jpa.domain.Specification;

public class AssetSpecification {
    private AssetSpecification() {}

    public static Specification<Asset> hasName(String name){
        return (root, query, cb) ->
                name == null ? null
                        : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Asset> hasType(AssetType type) {
        return (root, query, cb) ->
                type == null ? null :
                        cb.equal(root.get("type"), type);
    }

    public static Specification<Asset> hasStatus(AssetStatus status) {
        return (root, query, cb) ->
                status == null ? null :
                        cb.equal(root.get("status"), status);
    }

    public static Specification<Asset> hasSerialNumber(String serialNumber) {
        return (root, query, cb) ->
                serialNumber == null ? null :
                        cb.like(cb.lower(root.get("serialNumber")),
                                "%" + serialNumber.toLowerCase() + "%");
    }
}
