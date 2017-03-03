package firma.transpordi.controllers;


import firma.transpordi.models.PointOfTransfer;
import firma.transpordi.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping("/transfers")
    List<PointOfTransfer> getAllData() {
        return transferService.getAllData();
    }

    @RequestMapping("/transfers/score/{score}")
    public PointOfTransfer getDataItem(@PathVariable String score) {
        return transferService.getDataItem(score);
    }

    @RequestMapping("/transfers/score/{score}/{active}")
    public List<PointOfTransfer> getDataItemWithBoolean(@PathVariable String score, @PathVariable String active) {
        return transferService.getDataItemWithBoolean(score, active);
    }

    @RequestMapping("/transfers/times/normal")
    public List<PointOfTransfer> getNormalOpenTimes() {
        return transferService.getNormalOpenTimes();
    }

    @RequestMapping("/transfers/times/long")
    public List<PointOfTransfer> getLongOpenTimes() {
        return transferService.getLongOpenTimes();
    }

    @RequestMapping(method=RequestMethod.POST, value="/transfers")
    public void addNewTransfer(@RequestBody PointOfTransfer newTransfer) {
        System.out.println("New add");
        transferService.addNewTransfer(newTransfer);
    }

}
