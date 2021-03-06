package com.situ.crm.service;

import java.util.Date;
import java.util.List;

import com.situ.crm.common.EasyUIDataGrid;
import com.situ.crm.common.ServletResponse;
import com.situ.crm.pojo.CustomerContact;

public interface ICustomerContactService {

	EasyUIDataGrid pageList(CustomerContact customerContact, Integer rows, Integer page, Date startTime, Date endTime);

	ServletResponse add(CustomerContact customerContact);

	ServletResponse delete(String ids);

	ServletResponse update(CustomerContact customerContact);

	ServletResponse deleteById(Integer id);


}
