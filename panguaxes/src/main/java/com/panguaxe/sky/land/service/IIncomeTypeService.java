package com.panguaxe.sky.land.service;

import com.panguaxe.sky.land.model.IncomeType;

public interface IIncomeTypeService extends IBaseService<IncomeType>{

    IncomeType findByIncomeType(Integer incomeType);
}
