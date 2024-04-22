package org.cutm.lms.Lms_Backend.Service;

import org.cutm.lms.Lms_Backend.Entity.Management;

import java.util.List;

public interface MangementMethods {
    Management createManagement(Management management);
    Management getManagement(String mtId);
    Management updateManagement(String mtId,Management management);
    void deleteManagement(String mtId);
    List<Management> getAllManagement();
}
