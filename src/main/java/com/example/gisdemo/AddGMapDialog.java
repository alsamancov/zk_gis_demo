package com.example.gisdemo;

import org.zkoss.gmaps.Gmaps;
import org.zkoss.gmaps.Gmarker;
import org.zkoss.gmaps.event.MapDropEvent;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

public class AddGMapDialog extends GenericForwardComposer {
    private Window addGmapDlg;
    private Gmaps gmap;
    private Gmarker marker;
    private double lat;
    private double lng;

    public void onMapDrop$gmap(MapDropEvent event) throws InterruptedException{
        double lat = event.getLatLng().getLatitude();
        double lng = event.getLatLng().getLongitude();
        gmap.panTo(lat, lng);
    }

    public void onClick$addMapBtn(Event event) throws InterruptedException{
        desktop.setAttribute("lat", lat);
        desktop.setAttribute("lng", lng);

        Toolbarbutton addMapTbb = (Toolbarbutton) Path.getComponent("/mainWindow/addMapTbb");
        addMapTbb.setLabel("Map added");
        addMapTbb.setStyle("color:green");
        addGmapDlg.detach();

        System.out.println("These variables have been set as ZK desktop attributes: lat: " + desktop.getAttribute("lat") + ", lng: " + desktop.getAttribute("lng"));

    }

    public void onClose$AddGmapDlg(Event event) throws InterruptedException{
        addGmapDlg.detach();
    }
}
