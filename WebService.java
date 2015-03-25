/**
 * KryptoHelper 1.0 Copyright Stefan Gsottbauer © 2015. all rights reserved
 *
 * @author: Stefan Gsottbauer
 */

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import eu.gsottbauer.divisiontrainer.helper.KryptoHelper;

public class WebService {

    private final String mUserManagerServiceURL = "http://schule-dev.tugraz.at/usermanager/soap?wsdl";
    private final int mAppId = **;
    private final String mAppKey = "******************************************************";

    public SoapObject isUserAllowed(String username, String password_hash) throws Exception {

        SoapObject _client = new SoapObject("", "isUserAllowed");
        _client.addProperty("username", username);
        _client.addProperty("password", password_hash);
        _client.addProperty("idApp", mAppId);

        String hmac = username + password_hash + mAppId;
        String hmac_hash = KryptoHelper.getHMAC(hmac, mAppKey, "HmacSHA256");

        _client.addProperty("hmacClient", hmac_hash);

        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.bodyOut = _client;

        HttpTransportSE androidHttpTransport = new HttpTransportSE(mUserManagerServiceURL);
        androidHttpTransport.call("", _envelope);

        return (SoapObject) _envelope.bodyIn;
    }


    public SoapObject getID(String username) throws Exception {

        SoapObject _client = new SoapObject("", "getID");
        _client.addProperty("username", username);

        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.bodyOut = _client;

        HttpTransportSE androidHttpTransport = new HttpTransportSE(mUserManagerServiceURL);
        androidHttpTransport.call("", _envelope);

        return (SoapObject) _envelope.bodyIn;
    }

    public SoapObject getName(int idUser) throws Exception {

        SoapObject _client = new SoapObject("", "getName");
        _client.addProperty("idUser", idUser + "");

        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.bodyOut = _client;

        HttpTransportSE androidHttpTransport = new HttpTransportSE(mUserManagerServiceURL);
        androidHttpTransport.call("", _envelope);

        return (SoapObject) _envelope.bodyIn;
    }

    public SoapObject getRoles() throws Exception {

        SoapObject _client = new SoapObject("", "getRoles");

        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.bodyOut = _client;

        HttpTransportSE androidHttpTransport = new HttpTransportSE(mUserManagerServiceURL);
        androidHttpTransport.call("", _envelope);

        return (SoapObject) _envelope.bodyIn;
    }

    public SoapObject getSchoolclasses(int idUser) throws Exception {

        SoapObject _client = new SoapObject("", "getSchoolclasses");
        _client.addProperty("idUser", idUser + "");

        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.bodyOut = _client;

        HttpTransportSE androidHttpTransport = new HttpTransportSE(mUserManagerServiceURL);
        androidHttpTransport.call("", _envelope);

        return (SoapObject) _envelope.bodyIn;
    }

    public SoapObject getStudentsToClass(int idSchoolclass) throws Exception {

        SoapObject _client = new SoapObject("", "getSchoolclasses");
        _client.addProperty("idSchoolclass", idSchoolclass + "");

        SoapSerializationEnvelope _envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        _envelope.bodyOut = _client;

        HttpTransportSE androidHttpTransport = new HttpTransportSE(mUserManagerServiceURL);
        androidHttpTransport.call("", _envelope);

        return (SoapObject) _envelope.bodyIn;
    }
}
