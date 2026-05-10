package com.example.presensiapi.service;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Service;

@Service
public class GeoService {

    private final GeometryFactory gf = new GeometryFactory();
    private final Polygon polygon;

    public GeoService() {
        Coordinate[] coords = new Coordinate[]{
                new Coordinate(107.0309756, -6.3060428),
                new Coordinate(107.0306671, -6.3073891),
                new Coordinate(107.0318554, -6.3077144),
                new Coordinate(107.0321477, -6.3060881),
                new Coordinate(107.0309756, -6.3060428)
        };

        this.polygon = gf.createPolygon(coords);
    }

    public boolean isInside(double lat, double lng) {
        Point point = gf.createPoint(new Coordinate(lng, lat));
        return polygon.covers(point);
    }
}
