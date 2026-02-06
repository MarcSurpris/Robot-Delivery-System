package com.Maxxbytes.Robot.Delivery.System.util;

import com.Maxxbytes.Robot.Delivery.System.model.Location;


public class NavigationUtil {

    private NavigationUtil() { }


    public static double distance(Location from, Location to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Locations cannot be null");
        }

        double dx = to.getX() - from.getX();
        double dy = to.getY() - from.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }


    public static long etaMinutes(Location from, Location to, double mph) {
        double dist = distance(from, to);

        // hours = distance / mph; minutes = hours * 60
        double minutes = (dist / mph) * 60.0;

        return (long) Math.ceil(minutes);
    }
}
