package at.fh.swengb.resifoAndroid.activities.meldezettelEdit;

/**
 * Created by laszlobalo on 05.02.17.
 */

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import at.fh.swengb.resifoAndroid.R;

public class TEST extends Activity {


    Double yourLatitude;
    Double yourLongitude;

    Geocoder geocoder;
    List<Address> yourAddresses;
    geocoder = new Geocoder(this, Locale.getDefault());
    yourAddresses= geocoder.getFromLocation(yourLatitude, yourLongitude, 1);

    if (yourAddress.size() > 0)
    {
        String yourAddress = yourAddresses.get(0).getAddressLine(0);
        String yourCity = yourAddresses.get(0).getAddressLine(1);
        String yourCountry = yourAddresses.get(0).getAddressLine(2);
    }

}