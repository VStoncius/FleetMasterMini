package lt.fleetmaster.Mini.utils;

import lt.fleetmaster.Mini.domain.Driver;

import java.util.HashSet;
import java.util.Set;

public class Utils {

    public static Set<String> convertDriverSet(Set<Driver> originalSet) {
        Set<String> setOfNames = new HashSet<>();
        for (Driver driver: originalSet) {
            setOfNames.add(driver.getFirstName() + " " + driver.getLastName());
        }
        return setOfNames;
    }
}
