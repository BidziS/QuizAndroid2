package com.pracaizynierska.odpowiedzi.api;

import com.pracaizynierska.odpowiedzi.EPoprawna;
import com.pracaizynierska.odpowiedzi.dto.OdpowiedziDTO;
import com.pracaizynierska.odpowiedzi.service.IOdpowiedziService;
import com.pracaizynierska.utils.MyServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bidzis on 11/13/2016.
 */
@RestController
@RequestMapping(value = "/quizAndroid/odpowiedzi")
public class OdpowiedziController {

    @Autowired
    IOdpowiedziService serwisOdpowiedzi;

    @RequestMapping(value = "pobierzPoPytaniu/{pytania.id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<OdpowiedziDTO>> znajdzPytaniaPoKategorii(@PathVariable("pytania.id") Long aIdPytania) {
        return new ResponseEntity<>(serwisOdpowiedzi.znajdzOdpowiedziPoPytaniu(aIdPytania), HttpStatus.OK);
    }

    @RequestMapping(value = "pobierzPoPoprawnosci/{poprawnosc}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<OdpowiedziDTO>> znajdzOdpowiedziPoPoprawnosci(@PathVariable("poprawnosc")EPoprawna aPoprawna){
        return new ResponseEntity<>(serwisOdpowiedzi.znajdzOdpowiedziPoPoprawnosci(aPoprawna),HttpStatus.OK);
    }

    @RequestMapping(value = "/zapiszOdpowiedz",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    @ResponseBody
    public ResponseEntity<OdpowiedziDTO> zapiszOdpowiedz(@RequestBody OdpowiedziDTO aOdpowiedziDTO){
        try {
            return new ResponseEntity<>(serwisOdpowiedzi.zapiszOdpowiedz(aOdpowiedziDTO), HttpStatus.OK);
        }catch (MyServerException e) {
            return new ResponseEntity<>(e.getHeaders(),e.getStatus());
        }
    }
    @RequestMapping(value = "usunPoId/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Void> usunOdpowiedz(@PathVariable("id")Long aId){
        serwisOdpowiedzi.usunOdpowiedzi(aId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
