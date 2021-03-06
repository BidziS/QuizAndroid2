package com.pracaizynierska.punkty.service;

import com.pracaizynierska.punkty.dto.PunktyDTO;
import com.pracaizynierska.utils.MyServerException;

import java.util.List;

/**
 * Created by Bidzis on 11/11/2016.
 */
public interface IPunktyService {
    List<PunktyDTO> znajdzPunktyPoTrybie(Long aIdTryb);
    List<PunktyDTO> znajdzPunktyPoUzytkowniku(Long aIdUzytkownik);
    PunktyDTO zapiszPunkty(PunktyDTO aPunktyDTO) throws MyServerException;
    void usunPunkty(Long aId);

}
