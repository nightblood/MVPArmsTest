package me.jessyan.mvparms.demo.app.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DeviceIDUtil {

	public static String getIMEI(Context context) {
		TelephonyManager TelephonyMgr = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String m_szImei = TelephonyMgr.getDeviceId();
		if(m_szImei==null){
			m_szImei="ff:ff:ff:ff:ff:ff";
		}
		return m_szImei;
	}

	public static String getWlanMacAddressFromADB() {
		String macSerial = null;
		String str = "";
		try {
			Process pp = Runtime.getRuntime().exec(
					"cat /sys/class/net/wlan0/address ");
			InputStreamReader ir = new InputStreamReader(pp.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);

			for (; null != str;) {
				str = input.readLine();
				if (str != null) {
					macSerial = str.trim();// 去空格
					break;
				}
			}
		} catch (IOException ex) {
			// 赋予默认值
			ex.printStackTrace();
		}
		return macSerial;
	}

	public static String getWlanMacAddress(Context context){
		WifiManager wm = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
		String m_szWLANMAC = wm.getConnectionInfo().getMacAddress();
		return m_szWLANMAC;
	}

	public static String getBTMacAddress() {
		BluetoothAdapter m_BluetoothAdapter = null; // Local Bluetooth adapter
		m_BluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if(m_BluetoothAdapter==null){
			return "";
		}
		String m_szBTMAC = m_BluetoothAdapter.getAddress();
		return m_szBTMAC;
	}

	public static String getPseudo_Unique_ID() {
		String m_szDevIDShort = "35"
				+ // we make this look like a valid IMEI
				Build.BOARD.length() % 10 + Build.BRAND.length() % 10
				+ Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10
				+ Build.DISPLAY.length() % 10 + Build.HOST.length() % 10
				+ Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10
				+ Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10
				+ Build.TAGS.length() % 10 + Build.TYPE.length() % 10
				+ Build.USER.length() % 10; // 13 digits
		return m_szDevIDShort;
	}

	public static String getAndroid_ID(Context context) {
		String m_szAndroidID = Secure.getString(context.getContentResolver(),
				Secure.ANDROID_ID);
		return m_szAndroidID;
	}

	public static String getE0575_Device_ID(Context context) {
		String m_szLongID = getAndroid_ID(context) + getIMEI(context) + getPseudo_Unique_ID()
				+ getWlanMacAddress(context) + getBTMacAddress();
		// compute md5
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		m.update(m_szLongID.getBytes(),0,m_szLongID.length());
		// get md5 bytes
		byte p_md5Data[] = m.digest();
		// create a hex string
		StringBuilder m_szUniqueID = new StringBuilder();
		for (int i=0;i<p_md5Data.length;i++) {
			int b =  (0xFF & p_md5Data[i]);
			// if it is a single digit, make sure it have 0 in front (proper padding)
			if (b <= 0xF)
				m_szUniqueID.append("0");
//				m_szUniqueID+="0";

			// add number to string
			m_szUniqueID.append(Integer.toHexString(b));
//			m_szUniqueID+=Integer.toHexString(b);
		}   // hex string to uppercase
		/*m_szUniqueID = m_szUniqueID.toUpperCase();
		return m_szUniqueID;*/
		return m_szUniqueID.toString().toUpperCase();
	}

}
