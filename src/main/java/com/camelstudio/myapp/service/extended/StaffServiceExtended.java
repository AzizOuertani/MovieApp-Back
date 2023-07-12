package com.camelstudio.myapp.service.extended;

import com.camelstudio.myapp.domain.Staff;
import com.camelstudio.myapp.repository.extended.StaffRepositoryExtended;
import com.camelstudio.myapp.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StaffServiceExtended extends StaffService {

    private final Logger log = LoggerFactory.getLogger(StaffServiceExtended.class);
    private StaffRepositoryExtended staffRepositoryExtended;
    private StaffService staffService;

    public StaffServiceExtended(StaffRepositoryExtended staffRepositoryExtended, StaffService staffService) {
        super(staffRepositoryExtended);
        this.staffRepositoryExtended = staffRepositoryExtended;
        this.staffService = staffService;
    }

    public Boolean StaffExist(Staff staff) {
        if (staff.getId() != null) {
            return true;
        } else return false;
    }
}
