package com.panguaxe.sky.land.service;

import com.panguaxe.sky.land.model.RedBagType;

public interface IRedBagTypeService extends IBaseService<RedBagType>{

    RedBagType findByTypeCode(String typeCode);
}
