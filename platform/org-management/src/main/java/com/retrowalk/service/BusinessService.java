package com.retrowalk.service;

import com.retrowalk.entities.Business;
import com.retrowalk.models.request.BusinessRequest;

public interface BusinessService {

    Business reqisterBusiness(BusinessRequest businessRequest);
}
