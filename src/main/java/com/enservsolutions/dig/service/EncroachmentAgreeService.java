package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.EncroachmentAgree.EncroachmentAgreeReq;
import com.enservsolutions.dig.entity.EncroachmentAgree;
import com.enservsolutions.dig.entity.Upload;
import com.enservsolutions.dig.repository.CorrosionInspectionRepository;
import com.enservsolutions.dig.repository.DigRepository;
import com.enservsolutions.dig.repository.EncroachmentAgreeRepository;
import com.enservsolutions.dig.repository.UploadRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EncroachmentAgreeService {
    private final EncroachmentAgreeRepository encroachmentAgreeRepository;
    private final UploadRepository uploadRepository;
    private final DigRepository digRepository;

    public EncroachmentAgree createEncroachmentAgree(EncroachmentAgreeReq req) {
        EncroachmentAgree encroachmentAgree = new EncroachmentAgree();
        encroachmentAgree.setDateFrom(req.getDateFrom());
        encroachmentAgree.setCompanyName(req.getCompanyName());
        encroachmentAgree.setSectionNumber(req.getSectionNumber());
        encroachmentAgree.setLegalDescription(req.getLegalDescription());
        encroachmentAgree.setCounty(req.getCounty());
        encroachmentAgree.setState(req.getState());
        encroachmentAgree.setAlignmentSheetNumber(req.getAlignmentSheetNumber());
        encroachmentAgree.setMilePost(req.getMilePost());
        encroachmentAgree.setTractNumber(req.getTractNumber());
        encroachmentAgree.setEncroachmentType(req.getEncroachmentType());

        encroachmentAgree.setTicketNumber(req.getTicketNumber());
        encroachmentAgree.setCallPerson(req.getCallPerson());
        encroachmentAgree.setDispatchPerson(req.getDispatchPerson());
        encroachmentAgree.setActivity(req.getActivity());
        encroachmentAgree.setRemarks(req.getRemarks());
        encroachmentAgree.setFollowUpAction(req.getFollowUpAction().equalsIgnoreCase("yes"));
        encroachmentAgree.setExplaination(req.getExplaination());

        encroachmentAgree.setPersonMet(req.getPersonMet());
        encroachmentAgree.setPartyName(req.getPartyName());
        encroachmentAgree.setPartyTitle(req.getPartyTitle());
        encroachmentAgree.setPartyCompany(req.getPartyCompany());
        encroachmentAgree.setPartyAddress(req.getPartyAddress());
        encroachmentAgree.setPartyCity(req.getPartyCity());
        encroachmentAgree.setPartyState(req.getPartyState());
        encroachmentAgree.setPartyZip(req.getPartyZip());
        encroachmentAgree.setPartyPhone(req.getPartyPhone());

        encroachmentAgree.setReferencePoint(req.getReferencePoint());
        encroachmentAgree.setReferencePointEsn(req.getReferencePointEsn());
        encroachmentAgree.setDistAndDirFromReference(req.getDistAndDirFromReference());
        encroachmentAgree.setCalcEsnCrossing(req.getCalcEsnCrossing());
        encroachmentAgree.setFacilitySize(req.getFacilitySize());
        encroachmentAgree.setEncased(req.getEncased().equalsIgnoreCase("yes"));
        encroachmentAgree.setEncaseSize(req.getEncaseSize());
        encroachmentAgree.setCasingType(req.getCasingType());
        encroachmentAgree.setCoatingType(req.getCoatingType());

        encroachmentAgree.setPipelineCoatingType(req.getPipelineCoatingType());
        encroachmentAgree.setPipelineCoatingCondition(req.getPipelineCoatingCondition());
        encroachmentAgree.setPsGround(req.getPsGround());
        encroachmentAgree.setPsDitch(req.getPsDitch());
        encroachmentAgree.setPipelineCondition(req.getPipelineCondition());

        encroachmentAgree.setCompanyContact(req.getCompanyContact());
        encroachmentAgree.setEmergency(req.getEmergency());
        encroachmentAgree.setCompanyRep(req.getCompanyRep());
        encroachmentAgree.setPhoneNumber(req.getPhoneNumber());
        encroachmentAgree.setEncroachingPartyRep(req.getEncroachingPartyRep());
        encroachmentAgree.setPersonMet(req.getPersonMet());

        encroachmentAgreeRepository.save(encroachmentAgree);
        Upload upload = new Upload();
        upload.setTag("Encroachment Agreement Form");
        upload.setFileName("na");
        upload.setDig(digRepository.findById(req.getDigId()).get());
        uploadRepository.save(upload);

        return encroachmentAgree;
    }
}
