package firma.transpordi.services;


import firma.transpordi.models.PointOfTransfer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferService {

    private static final String HOUR_SEPARATOR = ":";
    private static final int OPEN_TIME_FILTER = 8; // value from assignment statement
    private static final int CLOSING_TIME_FILTER = 17; // value from assignment statement
    private static final int LONG_OPEN_FILTER = 10; // value from assignment statement


    private List<PointOfTransfer> transferData = new ArrayList<PointOfTransfer>(Arrays.asList(
                                                new PointOfTransfer(
                                                        "1 New Way"
                                                        , "2:00"
                                                        , "21:00"
                                                        , "true"
                                                        , "FedEx"
                                                        , "5"),
                                                new PointOfTransfer(
                                                        "1 No Way"
                                                        , "3:00"
                                                        , "15:00"
                                                        , "false"
                                                        , "UPS"
                                                        , "9"),
                                                new PointOfTransfer(
                                                        "1 No Way"
                                                        , "0:01"
                                                        , "19:00"
                                                        , "false"
                                                        , "UPS"
                                                        , "9")
                                                ));

    public List<PointOfTransfer> getAllData() {
        return transferData;
    }

    public PointOfTransfer getDataItem(String score) {
        return transferData
                .stream()
                .filter(t ->
                        t.getScore()
                                .equals(score))
                .findFirst()
                .get();
    }

    public List<PointOfTransfer> getDataItemWithBoolean(String score, String active) {
        return transferData
                .stream()
                .filter(t ->
                        t.getScore()
                                .equals(score))
                .filter(t ->
                        t.getActive()
                                .equals(active))
                .collect(Collectors.toList());
    }

    public List<PointOfTransfer> getNormalOpenTimes() {
        return transferData
                .stream()
                .filter(t ->
                        Integer.parseInt(
                                t.getOpenHoursBegin()
                                        .substring(0,
                                                t.getOpenHoursBegin()
                                                        .indexOf(HOUR_SEPARATOR))) <= OPEN_TIME_FILTER
                        && Integer.parseInt(
                                t.getOpenHoursEnd()
                                        .substring(0,
                                                t.getOpenHoursEnd()
                                                        .indexOf(HOUR_SEPARATOR))) >= CLOSING_TIME_FILTER )
                .collect(Collectors.toList());
    }

    public List<PointOfTransfer> getLongOpenTimes() {
        return transferData
                .stream()
                .filter(t ->
                        Integer.parseInt(
                                t.getOpenHoursEnd()
                                        .substring(0,
                                                t.getOpenHoursEnd()
                                                        .indexOf(HOUR_SEPARATOR)))
                        - Integer.parseInt(
                                t.getOpenHoursBegin()
                                        .substring(0,
                                                t.getOpenHoursBegin()
                                                        .indexOf(HOUR_SEPARATOR)))  >= LONG_OPEN_FILTER)
                .collect(Collectors.toList());
    }

    public void addNewTransfer(PointOfTransfer newTransfer) {
        transferData.add(newTransfer);
    }
}
